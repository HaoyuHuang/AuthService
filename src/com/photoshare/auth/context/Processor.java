package com.photoshare.auth.context;

public interface Processor {
	public String process() throws ProcessorException;
}
