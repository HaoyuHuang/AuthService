package com.photoshare.auth.context;

import com.photoshare.authorization.Authorizer;
import com.photoshare.authorization.StandardAuthorizeConfig;
import com.photoshare.authorization.StandardAuthorizer;

public class LogoutEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		Authorizer authorizer = new StandardAuthorizer();
		authorizer.init(new StandardAuthorizeConfig());
		valveContext.getContext().getRequest().bindAuthorizer(authorizer);
		valveContext.getContext().getRequest()
				.bindAuthDecoder(authorizer.getDecoder());
		valveContext.getContext().getRequest()
				.bindValidator(authorizer.getValidator());
	}

}
