package com.photoshare.auth;

/**
 * @author Aron
 * 
 *         The Auth Service open API for remote procedure calls.
 * 
 */
public class AuthService {
	public String login() {
		return new AuthConnector().login();
	}

	public String authenticate() {
		return new AuthConnector().authenticate();
	}

	public String logout() {
		return new AuthConnector().logout();
	}
}
