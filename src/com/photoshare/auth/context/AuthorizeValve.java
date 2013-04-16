package com.photoshare.auth.context;

import com.photoshare.auth.user.User;
import com.photoshare.authorization.AuthorizeException;
import com.photoshare.authorization.Authorizer;

public class AuthorizeValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		Authorizer authorizer = valveContext.getContext().getRequest()
				.getAuthorizer();
		User user = valveContext.getContext().getRequest().getCurrentUser();
		try {
			authorizer.authorize(user);
		} catch (AuthorizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
