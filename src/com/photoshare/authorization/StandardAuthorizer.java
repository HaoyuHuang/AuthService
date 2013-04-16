package com.photoshare.authorization;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.user.User;
import com.photoshare.validate.Validator;

/**
 * @author Aron
 * 
 *         The Standard Implementation of the Authorizer
 * 
 */
public class StandardAuthorizer implements Authorizer {

	@Override
	public void init(AuthorizeConfig config) {
		// TODO Auto-generated method stub
		config.configDecoder();
		config.configEncoder();
		config.configTokenKeeper();
		config.configTokenPool();
		config.configValidator();
	}

	@Override
	public void authorize(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deinit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unauthorize(User user) throws AuthorizeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AuthDecoder getDecoder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

}
