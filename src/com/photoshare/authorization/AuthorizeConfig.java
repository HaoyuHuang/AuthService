package com.photoshare.authorization;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.validate.AuthValidator;

/**
 * @author Aron <br/>
 *         The Authorize Configuration to configure and initialize the
 *         Authorizer {@link Authorizer}
 * 
 */
public interface AuthorizeConfig {
	/**
	 * Configure the Encoder for response.
	 */
	public void configEncoder(AuthEncoder encoder);

	/**
	 * Configure the Decoder for request.
	 */
	public void configDecoder(AuthDecoder decoder);

	/**
	 * Configure the Validator for validation.
	 */
	public void configValidator(AuthValidator validator);

	/**
	 * Configure the Token Keeper for preparation to authorization.
	 */
	public void configTokenKeeper(TokenKeepper keeper);

	/**
	 * Configure the Token Pool for preparation to authorization.
	 */
	public void configTokenPool();
}
