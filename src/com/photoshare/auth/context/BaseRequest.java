package com.photoshare.auth.context;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.user.User;
import com.photoshare.authorization.Authorizer;
import com.photoshare.validate.Validator;

public class BaseRequest implements Request {

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bindAuthenticator(Authenticator authenticator) {
		// TODO Auto-generated method stub

	}

	@Override
	public Authenticator getAuthenticator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindAuthorizer(Authorizer authorizer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Authorizer getAuthorizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindValidator(Validator validator) {
		// TODO Auto-generated method stub

	}

	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bindAuthDecoder(AuthDecoder decoder) {
		// TODO Auto-generated method stub

	}

	@Override
	public AuthDecoder getAuthDecoder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return null;
	}

}
