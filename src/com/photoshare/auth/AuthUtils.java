package com.photoshare.auth;

/**
 * @author Aron
 * 
 *         The Authentication Utils.
 * 
 */
public class AuthUtils {
	public static final String KEY_USER = "user";

	public static final String KEY_USER_NAME = "userName";

	public static final String KEY_USER_PASSWORD = "password";

	public static final String KEY_TOKEN = "token";

	public static final String KEY_IP = "ip";

	public static final String KEY_USER_AGENT = "userAgent";

	public static final String KEY_MESSAGE = "message";

	public static final String KEY_CODE = "code";

	public static boolean isBlank(String str) {
		if (str == null)
			return true;
		if ("".equals(str))
			return true;
		return false;
	}
}
