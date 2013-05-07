package com.photoshare.auth.context;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.SimpleAuthConfig;
import com.photoshare.auth.SimpleAuthenticator;

public class LoginEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		System.out.println("LoginEntryValve");
		Authenticator authenticator = new SimpleAuthenticator();
		authenticator.init(new SimpleAuthConfig());
		Request request = valveContext.getContext().getRequest();
		request.bindAuthenticator(authenticator);
		request.bindAuthDecoder(authenticator.getDecoder());
		request.bindValidator(authenticator.getValidator());
	}

}
