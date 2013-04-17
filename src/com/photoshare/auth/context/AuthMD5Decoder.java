package com.photoshare.auth.context;

import com.photoshare.auth.user.User;

public class AuthMD5Decoder implements AuthDecoder {

	@Override
	public User decode(String str) throws DecodeException {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return null;
	}

}
