package com.photoshare.auth;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.user.User;
import com.photoshare.validate.AuthValidator;

/**
 * @author Aron <br/>
 *         The Authenticator manages all client calls for authentication, such
 *         as login.
 * 
 */
public interface Authenticator {
	/**
	 * Initialize the Authenticator with the given Configuration.
	 * {@link AuthConfig}
	 * 
	 * @param config
	 */
	public void init(AuthConfig config);

	/**
	 * Authenticate the user. {@link User}
	 * 
	 * @param user
	 * @throws AuthenticateException
	 */
	public void authenticate(User user) throws AuthenticateException;

	/**
	 * @return
	 */
	public AuthDecoder getDecoder();
	
	/**
	 * @return
	 */
	public AuthValidator getValidator();

	/**
	 * Delete the Authenticator.
	 */
	public void deinit();
}
