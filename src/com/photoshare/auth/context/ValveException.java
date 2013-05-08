package com.photoshare.auth.context;

import org.codehaus.jettison.json.JSONObject;

public class ValveException extends Throwable {

	private int code;

	private String message;

	public ValveException(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6566541692563925106L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public int getCode() {
		return code;
	}

}
