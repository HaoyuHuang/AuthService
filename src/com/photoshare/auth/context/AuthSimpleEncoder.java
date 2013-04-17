package com.photoshare.auth.context;

public class AuthSimpleEncoder implements AuthEncoder {

	@Override
	public String encode(Response response) throws EncoderException {
		if (response.getResponse() == null)
			return "";

		char[] a = response.getResponse().toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		
		return s;
	}

}
