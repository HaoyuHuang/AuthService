package com.photoshare.auth.context;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.SimpleAuthConfig;
import com.photoshare.auth.SimpleAuthenticator;

public class LoginEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		Authenticator authenticator = new SimpleAuthenticator();
		authenticator.init(new SimpleAuthConfig());
		valveContext.getContext().getRequest().bindAuthenticator(authenticator);
		valveContext.getContext().getRequest()
				.bindAuthDecoder(authenticator.getDecoder());
		valveContext.getContext().getRequest()
				.bindValidator(authenticator.getValidator());
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
	}

}
