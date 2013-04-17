package com.photoshare.authorization;

import java.util.Date;
import java.util.UUID;

import com.photoshare.auth.user.Credential;

public class TokenGenerator {

	private static String UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static Token generate(String userName, Credential credential,
			Date loginDate) {
		return new Token(UUID(), userName, credential, loginDate, null);
	}

	public static void main(String[] args) {
		System.out.println(UUID());
	}
}
