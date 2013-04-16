package com.photoshare.auth;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.user.User;
import com.photoshare.validate.Validator;

/**
 * @author Aron
 * 
 *         The standard implementation of the authenticator
 * 
 */
public class StandardAuthenticator implements Authenticator {

	@Override
	public void init(AuthConfig config) {
		// TODO Auto-generated method stub

	}

	@Override
	public void authenticate(User user) throws AuthenticateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deinit() {
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
