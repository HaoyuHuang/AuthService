package com.photoshare.auth;

import com.photoshare.auth.context.Processor;
import com.photoshare.auth.context.ProcessorException;
import com.photoshare.auth.user.PasswordCredential;
import com.photoshare.auth.user.SimpleUser;
import com.photoshare.authorization.AuthorizeProcessor;
import com.photoshare.authorization.UnAuthorizeProcessor;

/**
 * @author Aron
 * 
 *         The Auth Connector used to connect the user to the authentication and
 *         authorization service.
 * 
 */
public class AuthConnector {
	public String authenticate(String content) {
		Processor processor = new AuthenticateProcessor();
		String response = "";
		try {
			processor.init(content);
			response = processor.process(content);
		} catch (ProcessorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public String authorize(String content) {
		Processor processor = new AuthorizeProcessor();
		String response = "";

		try {
			processor.init(content);
			response = processor.process(content);
		} catch (ProcessorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public String logout(String content) {
		Processor processor = new UnAuthorizeProcessor();
		String response = "";
		try {
			processor.init(content);
			response = processor.process(content);
		} catch (ProcessorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
