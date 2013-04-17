package com.photoshare.authorization;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.auth.context.AuthSimpleDecoder;
import com.photoshare.auth.context.AuthSimpleEncoder;
import com.photoshare.validate.AuthValidator;
import com.photoshare.validate.AuthSimpleValidator;

public class SimpleAuthorizeConfig implements AuthorizeConfig {

	@Override
	public void configTokenPool() {
		// TODO Auto-generated method stub

	}

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
	public void configValidator(AuthValidator validator) {
		// TODO Auto-generated method stub
		validator = new AuthSimpleValidator();
	}

	@Override
	public void configTokenKeeper(TokenKeepper keeper) {
		// TODO Auto-generated method stub

	}

}
