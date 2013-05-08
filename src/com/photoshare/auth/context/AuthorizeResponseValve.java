package com.photoshare.auth.context;

import com.photoshare.auth.user.User;
import com.photoshare.authorization.Token;

public class AuthorizeResponseValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
		System.out.println("AuthorizeResponseValve");
		User user = valveContext.getContext().getRequest().getCurrentUser();
		Token token = user.getAuthToken();
		valveContext.getContext().getResponse().setToken(token);
	}
}
