package com.photoshare.authorization;

import java.util.Collection;

/**
 * @author Aron
 * 
 *         The Token Keeper has the privileges to keep the users token.
 * 
 */
public interface TokenKeepper {
	/**
	 * check if the token exists
	 * 
	 * @param token
	 * @return true if token exists.
	 */
	public boolean checkToken(Token token);

	/**
	 * @param token
	 * @return
	 */
	public Token putToken(Token token);

	/**
	 * @param token
	 * @return
	 */
	public Token removeToken(Token token);

	/**
	 * @return
	 */
	public Collection<Token> removeAll(Collection<Token> tokens);

	/**
	 * 
	 */
	public void clear();

	/**
	 * @return
	 */
	public String getTokenId();
}
