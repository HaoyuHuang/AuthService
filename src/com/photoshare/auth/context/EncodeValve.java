package com.photoshare.auth.context;

import java.io.IOException;

public class EncodeValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {

		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);

		Response response = valveContext.getContext().getResponse();
		AuthEncoder authEncoder = response.getAuthEncoder();
		try {
			String encodedResponse = authEncoder.encode(response);
			response.clear();
			response.append(encodedResponse);
		} catch (EncoderException e) {
			throw new ValveException(401, e.getMessage());
		} catch (IOException e) {
			throw new ValveException(401, e.getMessage());
		}

	}

}
