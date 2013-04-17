package com.photoshare.auth.user;

import java.util.Date;

import com.photoshare.authorization.Token;

public final class SimpleUser implements User {

	private final String userName;

	private final Credential credential;

	private final Date loginDate;

	private final Token authToken;

	public SimpleUser(String userName, Credential credential, Date loginDate,
			Token authToken) {
		super();
		this.userName = userName;
		this.credential = credential;
		this.loginDate = loginDate;
		this.authToken = authToken;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public Credential getCredential() {
		// TODO Auto-generated method stub
		return credential;
	}

	@Override
	public Date getLoginDate() {
		// TODO Auto-generated method stub
		return loginDate;
	}

	@Override
	public Token getAuthToken() {
		// TODO Auto-generated method stub
		return authToken;
	}

}
