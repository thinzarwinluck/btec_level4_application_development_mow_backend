package com.dev.mealsOnWheel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.mealsOnWheel.dao.*;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
	
    Store findByEmail(String email);
}
