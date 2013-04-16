package com.photoshare.auth.context;

import com.photoshare.auth.user.User;

public interface AuthDecoder {
	public User decode(String str) throws DecodeException;
}
