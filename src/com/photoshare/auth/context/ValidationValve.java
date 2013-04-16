package com.photoshare.auth.context;

import com.photoshare.auth.user.User;
import com.photoshare.validate.ValidationException;
import com.photoshare.validate.Validator;

public class ValidationValve implements Valve {

	@Override
	public void invoke(ValveContext valveContext) throws ValveException {
		// TODO Auto-generated method stub
		Validator validator = valveContext.getContext().getRequest()
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
