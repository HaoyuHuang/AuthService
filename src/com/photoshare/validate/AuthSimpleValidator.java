package com.photoshare.validate;

import java.util.Date;

import com.photoshare.auth.AuthUtils;
import com.photoshare.auth.user.Credential;
import com.photoshare.auth.user.User;
import com.photoshare.authorization.Token;

/**
 * @author Aron
 * 
 *         The Standard Implementation of the validator
 * 
 */
public class AuthSimpleValidator implements AuthValidator {

	@Override
	public void validate(User user) throws ValidationException {
		// TODO Auto-generated method stub
		String userName = user.getUserName();
		Token token = user.getAuthToken();
		Credential credential = user.getCredential();
		Date loginDate = user.getLoginDate();

		if (AuthUtils.isBlank(userName) || AuthUtils.isBlank(token.getToken())) {
			throw new ValidationException();
		}

	}

}
