package com.photoshare.auth.context;

import java.util.Date;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.photoshare.auth.AuthUtils;
import com.photoshare.auth.user.Credential;
import com.photoshare.auth.user.PasswordCredential;
import com.photoshare.auth.user.SimpleUser;
import com.photoshare.auth.user.User;
import com.photoshare.authorization.Token;

public class AuthSimpleDecoder implements AuthDecoder {

	@Override
	public User decode(String str) throws DecodeException {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		JSONObject json = null;
		try {
			json = new JSONObject(k);
		} catch (JSONException e) {
			e.printStackTrace();
			throw new DecodeException();
		}
		JSONObject obj = json.optJSONObject(AuthUtils.KEY_USER);
		String ip = obj.optString(AuthUtils.KEY_IP);
		String userAgent = obj.optString(AuthUtils.KEY_USER_AGENT);
		String userName = obj.optString(AuthUtils.KEY_USER_NAME);
		String userPassword = obj.optString(AuthUtils.KEY_USER_PASSWORD);
		String token = obj.optString(AuthUtils.KEY_MESSAGE);
		Credential credential = new PasswordCredential(userPassword);
		Token authToken = new Token(token, userName, credential, new Date(),
				null);
		User user = new SimpleUser(ip, userAgent, userName, credential,
				new Date(), authToken);
		return user;
	}
}
