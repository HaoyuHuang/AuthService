package com.photoshare.auth;

import javax.persistence.EntityManager;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.auth.context.AuthSimpleDecoder;
import com.photoshare.auth.context.AuthSimpleEncoder;
import com.photoshare.validate.AuthSimpleValidator;
import com.photoshare.validate.AuthValidator;

public class SimpleAuthConfig implements AuthConfig {

	@Override
	public void configEncoder(AuthEncoder encoder) {
		// TODO Auto-generated method stub
		encoder = new AuthSimpleEncoder();
	}

	@Override
	public void configDecoder(AuthDecoder decoder) {
		// TODO Auto-generated method stub
		decoder = new AuthSimpleDecoder();
	}

	@Override
	public void configDataSource(EntityManager manager) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configValidator(AuthValidator validator) {
		// TODO Auto-generated method stub
		validator = new AuthSimpleValidator();
	}

}
