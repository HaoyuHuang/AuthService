package com.photoshare.authorization;

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
	public void configEncoder();

	/**
	 * Configure the Decoder for request.
	 */
	public void configDecoder();

	/**
	 * Configure the Validator for validation.
	 */
	public void configValidator();

	/**
	 * Configure the Token Keeper for preparation to authorization.
	 */
	public void configTokenKeeper();

	/**
	 * Configure the Token Pool for preparation to authorization.
	 */
	public void configTokenPool();
}
