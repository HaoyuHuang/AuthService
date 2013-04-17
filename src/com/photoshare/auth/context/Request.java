package com.photoshare.auth.context;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.user.User;
import com.photoshare.authorization.Authorizer;
import com.photoshare.validate.AuthValidator;

public interface Request {
	public User getCurrentUser();

	public void bindUser(User user);

	public void bindAuthenticator(Authenticator authenticator);

	public Authenticator getAuthenticator();

	public void bindAuthorizer(Authorizer authorizer);

	public Authorizer getAuthorizer();

	public void bindValidator(AuthValidator validator);

	public AuthValidator getValidator();

	public void bindAuthDecoder(AuthDecoder decoder);

	public AuthDecoder getAuthDecoder();
	
	public String getRequest();

}
