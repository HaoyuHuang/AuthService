package com.photoshare.auth.context;

import java.io.IOException;

import com.photoshare.authorization.Token;

public interface Response {
	public void setToken(Token token);

	public Token getToken();

	public String getResponse();

	public void flush() throws IOException;

	public void bindEncoder(AuthEncoder authEncoder);

	public AuthEncoder getAuthEncoder();

	public void clear() throws IOException;

	public void append(String append) throws IOException;

}
