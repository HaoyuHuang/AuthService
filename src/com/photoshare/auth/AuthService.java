package com.photoshare.auth;

/**
 * @author Aron
 * 
 *         The Auth Service open API for remote procedure calls.
 * 
 */
public class AuthService {
	public String login(String content) {
		return new AuthConnector().authenticate(content);
	}

	public String authorize(String content) {
		return new AuthConnector().authorize(content);
	}

	public String logout(String content) {
		return new AuthConnector().logout(content);
	}
}
