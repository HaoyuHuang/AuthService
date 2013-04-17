package com.photoshare.auth.context;

public class UnAuthorizeValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
	}

}
