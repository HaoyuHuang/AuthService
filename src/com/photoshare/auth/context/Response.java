package com.photoshare.auth.context;

import com.photoshare.authorization.Token;

public interface Response {
	public void setToken(Token token);
	
	public String getResponse();
}
