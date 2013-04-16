package com.photoshare.auth.context;

import com.photoshare.auth.user.User;

public class DecoderValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		AuthDecoder decoder = valveContext.getContext().getRequest()
				.getAuthDecoder();
		User user = null;
		try {
			user = decoder.decode(valveContext.getContext().getRequest()
					.getRequest());
		} catch (DecodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valveContext.getContext().getRequest().bindUser(user);
	}

}
