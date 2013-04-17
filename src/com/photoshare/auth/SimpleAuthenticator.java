package com.photoshare.auth;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.auth.user.User;
import com.photoshare.persistence.DateManager;
import com.photoshare.validate.AuthValidator;

/**
 * @author Aron
 * 
 *         The standard implementation of the authenticator
 * 
 */
public class SimpleAuthenticator implements Authenticator {

	private AuthDecoder authDecoder;
	
	private AuthEncoder authEncoder;

	private AuthValidator authValidator;

	@Override
	public void init(AuthConfig config) {
		// TODO Auto-generated method stub
		config.configDataSource(null);
		config.configDecoder(authDecoder);
		config.configEncoder(authEncoder);
		config.configValidator(authValidator);
	}

	@Override
	public void authenticate(User user) throws AuthenticateException {
		// TODO Auto-generated method stub
		boolean retAuth = DateManager.authenticate(user);
		if (!retAuth)
			throw new AuthenticateException();
	}

	@Override
	public void deinit() {
		// TODO Auto-generated method stub

	}

	@Override
	public AuthDecoder getDecoder() {
		// TODO Auto-generated method stub
		return authDecoder;
	}

	@Override
	public AuthValidator getValidator() {
		// TODO Auto-generated method stub
		return authValidator;
	}

}
