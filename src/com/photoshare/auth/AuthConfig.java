package com.photoshare.auth;

import javax.persistence.EntityManager;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.validate.AuthValidator;

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
	public void configEncoder(AuthEncoder encoder);

	/**
	 * Configure the Decoder for in coming request.
	 */
	public void configDecoder(AuthDecoder decoder);

	/**
	 * Configure the Data source for Authentication.
	 */
	public void configDataSource(EntityManager manager);

	/**
	 * Configure the Validator for Authentication.
	 */
	public void configValidator(AuthValidator validator);
}
