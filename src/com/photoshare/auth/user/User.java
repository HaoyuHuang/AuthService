package com.photoshare.auth.user;

import java.util.Date;

import com.photoshare.authorization.Token;

/**
 * @author Aron <br/>
 *         The User for authentication and authorization.
 * 
 */
public interface User {

	/**
	 * Get the Name of the request User.
	 * 
	 * @return user name
	 */
	public String getUserName();

	/**
	 * Get the credential of the request User.
	 * 
	 * @return user credential. {@link Credential}
	 */
	public Credential getCredential();

	/**
	 * Get the login date of the request User.
	 * 
	 * @return the login date. {@link Date}
	 */
	public Date getLoginDate();

	/**
	 * Get the Auth Token with the request User, if any.
	 * 
	 * @return the Auth Token {@link Token}
	 */
	public Token getAuthToken();
	
}
