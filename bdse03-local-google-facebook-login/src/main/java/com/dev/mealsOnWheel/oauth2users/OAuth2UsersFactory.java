package com.dev.mealsOnWheel.oauth2users;

import java.util.Map;

import com.dev.mealsOnWheel.dao.AuthProvider;
import com.dev.mealsOnWheel.exception.OAuthAuthenticationException;

public class OAuth2UsersFactory{
	public static OAuth2Users getInstance(String registerId, Map<String, Object> attributes) throws OAuthAuthenticationException {
		if(registerId.equalsIgnoreCase(AuthProvider.google.toString())) {
			return new GoogleOAuth2Users(attributes);
		}
		else if(registerId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
			return new FacebookOAuth2Users(attributes);
		}
		else {
			throw new OAuthAuthenticationException("Login with" + registerId + "is not supported yet!!!");
		}
	}
}
