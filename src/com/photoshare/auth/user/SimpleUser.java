package com.photoshare.auth.user;

import java.util.Date;

import com.photoshare.authorization.Token;

public final class SimpleUser implements User {

	private final String ip;

	private final String userAgent;

	private final String userName;

	private final Credential credential;

	private final Date loginDate;

	private final Token authToken;

	public SimpleUser(String ip, String userAgent, String userName,
			Credential credential, Date loginDate, Token authToken) {
		super();
		this.ip = ip;
		this.userAgent = userAgent;
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

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return ip;
	}

	@Override
	public String getUserAgent() {
		// TODO Auto-generated method stub
		return userAgent;
	}

}
