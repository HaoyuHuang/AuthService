package com.photoshare.validate;

import com.photoshare.auth.user.User;

/**
 * @author Aron
 * 
 *         The Validator is responsible for validating all incoming request.
 * 
 */
public interface AuthValidator {
	public void validate(User user) throws ValidationException;
}
