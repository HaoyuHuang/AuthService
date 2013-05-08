package com.photoshare.auth.context;

import com.photoshare.auth.user.User;
import com.photoshare.authorization.AuthorizeException;
import com.photoshare.authorization.Authorizer;

public class AuthorizeValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {

		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
		System.out.println("AuthorizeValve");

		Authorizer authorizer = valveContext.getContext().getRequest()
				.getAuthorizer();
		User user = valveContext.getContext().getRequest().getCurrentUser();
		try {
			authorizer.authorize(user);
		} catch (AuthorizeException e) {
			throw new ValveException(405, "Access Denied");
		}

	}

}
