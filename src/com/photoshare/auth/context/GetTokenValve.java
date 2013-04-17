package com.photoshare.auth.context;

import java.util.Date;

import com.photoshare.auth.user.Credential;
import com.photoshare.auth.user.User;
import com.photoshare.authorization.Token;
import com.photoshare.authorization.TokenGenerator;

public class GetTokenValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		User user = valveContext.getContext().getRequest().getCurrentUser();
		String userName = user.getUserName();
		Credential credential = user.getCredential();
		Date date = user.getLoginDate();
		Token token = TokenGenerator.generate(userName, credential, date);
		valveContext.getContext().getResponse().setToken(token);
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
	}
}
