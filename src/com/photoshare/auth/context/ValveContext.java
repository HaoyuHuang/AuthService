package com.photoshare.auth.context;

/**
 * @author Aron
 * 
 */
public interface ValveContext {

	public void invokeNext(Request request, Response response,
			ValveContext valveContext) throws ValveException;

	public String getInfo();
	
	public Context getContext();

}
