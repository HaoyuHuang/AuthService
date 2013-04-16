package com.photoshare.auth.context;

import com.photoshare.authorization.TokenGenerator;

public class GetTokenValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		valveContext.getContext().getResponse()
				.setToken(TokenGenerator.generate());
	}
}
