package com.photoshare.authorization;

import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.user.User;
import com.photoshare.validate.AuthValidator;

/**
 * @author Aron
 * 
 *         The Authorizer manages all authorization business.
 * 
 */
public interface Authorizer {
	/**
	 * Initialize the Authorizer with the given Configuration.
	 * 
	 * @param Authrizer
	 *            Configuration.{@link AuthorizeConfig}
	 */
	public void init(AuthorizeConfig config);

	/**
	 * Authorize the request User.
	 * 
	 * @param user
	 *            {@link User}
	 * @throws AuthorizeException
	 */
	public void authorize(User user) throws AuthorizeException;

	/**
	 * Unauthorizes the request User.
	 * 
	 * @param user
	 *            {@link User}
	 * @throws AuthorizeException
	 */
	public void unauthorize(User user) throws AuthorizeException;

	/**
	 * @return
	 */
	public AuthDecoder getDecoder();

	/**
	 * @return
	 */
	public AuthValidator getValidator();

	/**
	 * Delete the Authorizer.
	 */
	public void deinit();
}
