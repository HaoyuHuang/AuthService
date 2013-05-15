package com.photoshare.auth;

import java.util.UUID;

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
		for (int i = 0; i < 99999; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					AuthService authService = new AuthService();
					try {
						JSONObject jsonObject = new JSONObject();
						jsonObject.put(AuthUtils.KEY_USER_NAME, "user");
						jsonObject.put(AuthUtils.KEY_USER_PASSWORD, "12345");
						jsonObject.put(AuthUtils.KEY_MESSAGE, "ebr24ee");
						JSONObject object = new JSONObject();
						object.put(AuthUtils.KEY_USER, jsonObject);
						String content = new AuthSimpleEncoder().encode(object
								.toString());
						content = authService.login(content);
						// Thread.sleep(1000);
						System.out.println(authService.authorize(content));
					} catch (JSONException e) {
						e.printStackTrace();
						// } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
					}
				}
			});
			t.start();
		}
	}
}
