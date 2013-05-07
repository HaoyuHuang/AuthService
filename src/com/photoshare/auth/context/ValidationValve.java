package com.photoshare.auth.context;

import com.photoshare.auth.user.User;
import com.photoshare.validate.ValidationException;
import com.photoshare.validate.AuthValidator;

public class ValidationValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		valveContext.invokeNext(valveContext.getContext().getRequest(),
				valveContext.getContext().getResponse(), valveContext);
		System.out.println("ValidationValve");
		AuthValidator validator = valveContext.getContext().getRequest()
				.getValidator();
		User user = valveContext.getContext().getRequest().getCurrentUser();
		try {
			validator.validate(user);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
