package com.photoshare.auth.context;

import java.io.IOException;

public class FlushValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {

		Response response = valveContext.getContext().getResponse();
		try {
			response.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ValveException(e.getMessage());
		}
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
	}

}
