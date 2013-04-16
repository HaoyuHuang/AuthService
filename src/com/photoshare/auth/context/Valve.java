package com.photoshare.auth.context;

/**
 * @author Aron
 * 
 */
public interface Valve {

	public void invoke(ValveContext valveContext) throws ValveException;
}
