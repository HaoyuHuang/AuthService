package com.photoshare.auth;

/**
 * @author Aron <br/>
 *         The Authentication Configuration to initialize the Authenticator
 *         {@link Authenticator}
 * 
 */
public interface AuthConfig {
	/**
	 * Configure the Encoder for response.
	 */
	public void configEncoder();

	/**
	 * Configure the Decoder for in coming request.
	 */
	public void configDecoder();

	/**
	 * Configure the Data source for Authentication.
	 */
	public void configDataSource();

	/**
	 * Configure the Validator for Authentication.
	 */
	public void configValidator();
}
