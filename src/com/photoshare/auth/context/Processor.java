package com.photoshare.auth.context;

public interface Processor {

	public void init(String request);

	public String process() throws ProcessorException;
}
