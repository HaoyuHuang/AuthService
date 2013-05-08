package com.photoshare.auth.context;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.photoshare.auth.user.User;

public class ExceptionWrapper {
	public static String toJSON(User user, int code, String message) {

		JSONObject object = new JSONObject();
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put("userName", user.getUserName());
			jsonObject.put("code", code);
			jsonObject.put("message", message);
			object.put("user", jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String toJSON(int code, String message) {
		JSONObject object = new JSONObject();
		JSONObject jsonObject = new JSONObject();

		try {
			jsonObject.put("userName", "");
			jsonObject.put("code", code);
			jsonObject.put("message", message);
			object.put("user", jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

}
