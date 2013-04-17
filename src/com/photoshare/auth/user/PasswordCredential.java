package com.photoshare.auth.user;

public final class PasswordCredential implements Credential {

	private final String password;

	public PasswordCredential(String password) {
		super();
		this.password = password;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

}
