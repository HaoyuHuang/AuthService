package com.photoshare.auth.context;

import com.photoshare.auth.AuthenticateException;
import com.photoshare.auth.Authenticator;
import com.photoshare.auth.user.User;

public class AuthenticateValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
		System.out.println("AuthenticateValve");
		Authenticator authenticator = valveContext.getContext().getRequest()
				.getAuthenticator();
		User user = valveContext.getContext().getRequest().getCurrentUser();
		try {
			authenticator.authenticate(user);
		} catch (AuthenticateException e) {
			throw new ValveException(401, "Login Denied");
		}

	}

}
