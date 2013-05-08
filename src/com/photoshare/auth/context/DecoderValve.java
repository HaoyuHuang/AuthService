package com.photoshare.auth.context;

import com.photoshare.auth.user.User;

public class DecoderValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
		System.out.println("DecoderValve");
		AuthDecoder decoder = valveContext.getContext().getRequest()
				.getAuthDecoder();
		User user = null;
		try {
			user = decoder.decode(valveContext.getContext().getRequest()
					.getRequest());
		} catch (DecodeException e) {
			throw new ValveException(401, "Decode Exception Occured");
		}
		valveContext.getContext().getRequest().bindUser(user);
	}

}
