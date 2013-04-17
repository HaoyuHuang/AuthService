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
			user.put(AuthUtils.KEY_TOKEN, token);
			wrapper.put(AuthUtils.KEY_USER, user);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wrapper.toString();
	}

}
