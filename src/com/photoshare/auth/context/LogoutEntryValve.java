package com.photoshare.auth.context;

import com.photoshare.authorization.Authorizer;
import com.photoshare.authorization.SimpleAuthorizeConfig;
import com.photoshare.authorization.SimpleAuthorizer;

public class LogoutEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		Authorizer authorizer = new SimpleAuthorizer();
		authorizer.init(new SimpleAuthorizeConfig());
		valveContext.getContext().getRequest().bindAuthorizer(authorizer);
		valveContext.getContext().getRequest()
				.bindAuthDecoder(authorizer.getDecoder());
		valveContext.getContext().getRequest()
				.bindValidator(authorizer.getValidator());
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
	}

}
