package com.dev.mealsOnWheel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.mealsOnWheel.dao.AuthProvider;
import com.dev.mealsOnWheel.dao.Users;
import com.dev.mealsOnWheel.exception.BadRequestException;
import com.dev.mealsOnWheel.exception.DuplicateEmailException;
import com.dev.mealsOnWheel.payload.AfterRegister;
import com.dev.mealsOnWheel.payload.IssueHandling;
import com.dev.mealsOnWheel.payload.Register;
import com.dev.mealsOnWheel.repository.UsersRepository;

@RestController
@RequestMapping(value = "/api")
public class RegisterController {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;                      ;
	
	//Register User for Local 
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody Register register){
		try {
		//Checking duplicate email
		 if(usersRepository.existsByEmail(register.getEmail())) {
	            throw new DuplicateEmailException("Email is already registered.");
	        }
		
		//Create new register user
		Users users = new Users();
		users.setUserName(register.getUserName());
		users.setEmail(register.getEmail());
		users.setAge(register.getAge());
		users.setLatitude(register.getLatitude());
		users.setLongitude(register.getLongitude());
		users.setExperience(register.getExperience());
		users.setWork_type(register.getWork_type());
		users.setPrevious_work(register.getPrevious_work());
		users.setUser_profile(register.getUser_profile());
		users.setPassword(register.getPassword());
		users.setProvider(AuthProvider.local);
		
		//Encode Password
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		//Save new user in the database
		Users newUser = usersRepository.save(users);
		
		java.net.URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(newUser.getUsersId()).toUri();
		
		//Return to RegisterResponse Payload
		return ResponseEntity.created(location)
				.body(new AfterRegister(true, "Successful Register"));
	}
	catch(DuplicateEmailException e) {
		IssueHandling errorResponse = e.getErrorResponse();
        return ResponseEntity.status(errorResponse.getStatus())
                .body(errorResponse);
    }}
	
}