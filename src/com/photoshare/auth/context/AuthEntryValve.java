package com.photoshare.auth.context;

import com.photoshare.authorization.Authorizer;
import com.photoshare.authorization.SimpleAuthorizeConfig;
import com.photoshare.authorization.SimpleAuthorizer;

public class AuthEntryValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		Authorizer authorizer = new SimpleAuthorizer();
		authorizer.init(new SimpleAuthorizeConfig());

		Request request = valveContext.getContext().getRequest();
		Response response = valveContext.getContext().getResponse();

		request.bindAuthorizer(authorizer);
		request.bindAuthDecoder(authorizer.getDecoder());
		request.bindValidator(authorizer.getValidator());

		response.bindEncoder(authorizer.getEncoder());

	}

}
