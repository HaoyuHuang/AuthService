package com.photoshare.authorization;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.photoshare.auth.AuthUtils;
import com.photoshare.auth.user.Credential;

/**
 * @author Aron
 * 
 *         The Token that is used for authorization and SSO.
 * 
 */
public final class Token {
	private final String token;

	private final String userName;

	private final Credential credential;

	private final Date startDate;

	private final Date expireDate;

	public Token(String token, String userName, Credential credential,
			Date startDate, Date expireDate) {
		super();
		this.token = token;
		this.userName = userName;
		this.credential = credential;
		this.startDate = startDate;
		this.expireDate = expireDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((credential == null) ? 0 : credential.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	public String getToken() {
		return token;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public String getUserName() {
		return userName;
	}

	public Credential getCredential() {
		return credential;
	}

	public String json() {
		JSONObject wrapper = new JSONObject();
		JSONObject user = new JSONObject();
		try {
			user.put(AuthUtils.KEY_USER_NAME, userName);
			user.put(AuthUtils.KEY_CODE, 200);
			user.put(AuthUtils.KEY_MESSAGE, token);
			wrapper.put(AuthUtils.KEY_USER, user);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper.toString();
	}

}
