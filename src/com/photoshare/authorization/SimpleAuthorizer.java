package com.photoshare.authorization;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.auth.context.AuthSimpleDecoder;
import com.photoshare.auth.context.AuthSimpleEncoder;
import com.photoshare.auth.user.User;
import com.photoshare.validate.AuthSimpleValidator;
import com.photoshare.validate.AuthValidator;

/**
 * @author Aron
 * 
 *         The Standard Implementation of the Authorizer
 * 
 */
public class SimpleAuthorizer implements Authorizer {

	private AuthDecoder authDecoder;

	private AuthValidator authValidator;

	private AuthEncoder authEncoder;

	private TokenKeepper keepper;

	@Override
	public void init(AuthorizeConfig config) {
		authDecoder = new AuthSimpleDecoder();
		authEncoder = new AuthSimpleEncoder();
		authValidator = new AuthSimpleValidator();
		config.configDecoder(authDecoder);
		config.configEncoder(authEncoder);
		config.configTokenKeeper(keepper);
		config.configTokenPool();
		config.configValidator(authValidator);
	}

	@Override
	public void authorize(User user) throws AuthorizeException {
		// TODO Auto-generated method stub
		TokenPool pool = TokenPool.Instance();
		TokenKeepper keeper = pool.retrieveTokenKeeper(user.getUserName());
		if (keeper == null) {
			System.out.println("keeper is null");
			throw new AuthorizeException();
		}

		boolean exist = keeper.checkToken(user.getAuthToken());
		System.out.println("user token: " + user.getAuthToken());
		if (!exist) {
			System.out.println("check failed");
			throw new AuthorizeException();
		}
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
		return authDecoder;
	}

	@Override
	public AuthValidator getValidator() {
		// TODO Auto-generated method stub
		return authValidator;
	}

	@Override
	public AuthEncoder getEncoder() {
		// TODO Auto-generated method stub
		return authEncoder;
	}

}
