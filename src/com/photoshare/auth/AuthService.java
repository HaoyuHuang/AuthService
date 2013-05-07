package com.photoshare.auth;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.photoshare.auth.context.AuthSimpleEncoder;

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

	public static void main(String[] args) {
		AuthService authService = new AuthService();
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put(AuthUtils.KEY_USER_NAME, "user");
			jsonObject.put(AuthUtils.KEY_USER_PASSWORD, "12345");
			jsonObject.put(AuthUtils.KEY_TOKEN, "ebr24ee");
			JSONObject object = new JSONObject();
			object.put(AuthUtils.KEY_USER, jsonObject);
			System.out.println(object.toString());
			String content = new AuthSimpleEncoder().encode(object.toString());
			System.out.println(authService.login(content));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
