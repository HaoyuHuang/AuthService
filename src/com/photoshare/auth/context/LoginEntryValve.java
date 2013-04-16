package com.photoshare.auth.context;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.StandardAuthConfig;
import com.photoshare.auth.StandardAuthenticator;

public class LoginEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		Authenticator authenticator = new StandardAuthenticator();
		authenticator.init(new StandardAuthConfig());
		valveContext.getContext().getRequest().bindAuthenticator(authenticator);
		valveContext.getContext().getRequest()
				.bindAuthDecoder(authenticator.getDecoder());
		valveContext.getContext().getRequest()
				.bindValidator(authenticator.getValidator());
	}

}
