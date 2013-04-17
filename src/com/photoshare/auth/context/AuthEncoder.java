package com.photoshare.auth.context;

public interface AuthEncoder {
	public String encode(Response response) throws EncoderException;
}
