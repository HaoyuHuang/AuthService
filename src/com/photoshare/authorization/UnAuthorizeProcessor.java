package com.photoshare.authorization;

import java.io.IOException;

import com.photoshare.auth.Authenticator;
import com.photoshare.auth.context.AuthDecoder;
import com.photoshare.auth.context.AuthEncoder;
import com.photoshare.auth.context.Context;
import com.photoshare.auth.context.DecoderValve;
import com.photoshare.auth.context.EncodeValve;
import com.photoshare.auth.context.ExceptionWrapper;
import com.photoshare.auth.context.FlushValve;
import com.photoshare.auth.context.LogoutEntryValve;
import com.photoshare.auth.context.Pipeline;
import com.photoshare.auth.context.Processor;
import com.photoshare.auth.context.ProcessorException;
import com.photoshare.auth.context.Request;
import com.photoshare.auth.context.Response;
import com.photoshare.auth.context.SimpleAuthenticationPipeline;
import com.photoshare.auth.context.UnAuthorizeValve;
import com.photoshare.auth.context.ValidationValve;
import com.photoshare.auth.context.ValveException;
import com.photoshare.auth.user.User;
import com.photoshare.validate.AuthValidator;

public class UnAuthorizeProcessor implements Processor {
	private Pipeline pipeline;

	private Context context;

	private String request;

	@Override
	public String process(String content) throws ProcessorException {
		pipeline = new SimpleAuthenticationPipeline();
		context = new UnAuthorizeContext();
		pipeline.setBasic(new LogoutEntryValve());
		pipeline.addValve(new DecoderValve());
		pipeline.addValve(new ValidationValve());
		pipeline.addValve(new UnAuthorizeValve());
		pipeline.addValve(new EncodeValve());
		pipeline.addValve(new FlushValve());
		pipeline.setContext(context);
		try {
			pipeline.invoke(context.getRequest(), context.getResponse(), null);
		} catch (ValveException e) {
			User user = context.getRequest().getCurrentUser();
			String response = "";
			if (user == null || user.getUserName() == null) {
				response = ExceptionWrapper.toJSON(503, "Internal Error");
			} else {
				response = ExceptionWrapper.toJSON(user, e.getCode(),
						e.getMessage());
			}
			return response;
		}
		return context.getResponse().getResponse();
	}

	protected class UnAuthorizeContext implements Context {

		private Request request = new BaseRequest();

		private Response response = new BaseResponse();

		@Override
		public Request getRequest() {
			// TODO Auto-generated method stub
			return request;
		}

		@Override
		public Response getResponse() {
			// TODO Auto-generated method stub
			return response;
		}
	}

	protected class BaseRequest implements Request {

		private User user;

		private Authenticator authenticator;

		private Authorizer authorizer;

		private AuthValidator authValidator;

		private AuthDecoder authDecoder;

		@Override
		public User getCurrentUser() {
			return user;
		}

		@Override
		public void bindUser(User user) {
			if (this.user == null) {
				this.user = user;
			}
		}

		@Override
		public void bindAuthenticator(Authenticator authenticator) {
			if (this.authenticator == null) {
				this.authenticator = authenticator;
			}
		}

		@Override
		public Authenticator getAuthenticator() {
			return authenticator;
		}

		@Override
		public void bindAuthorizer(Authorizer authorizer) {
			if (this.authorizer == null) {
				this.authorizer = authorizer;
			}
		}

		@Override
		public Authorizer getAuthorizer() {
			return authorizer;
		}

		@Override
		public void bindValidator(AuthValidator validator) {
			if (this.authValidator == null) {
				this.authValidator = validator;
			}
		}

		@Override
		public AuthValidator getValidator() {
			return authValidator;
		}

		@Override
		public void bindAuthDecoder(AuthDecoder decoder) {
			if (this.authDecoder == null) {
				this.authDecoder = decoder;
			}
		}

		@Override
		public AuthDecoder getAuthDecoder() {
			return authDecoder;
		}

		@Override
		public String getRequest() {
			// TODO Auto-generated method stub
			return request;
		}

	}

	protected class BaseResponse implements Response {

		private AuthEncoder authEncoder;

		private Token token;

		private String response;

		private boolean isFlushed = false;

		@Override
		public void setToken(Token token) {
			this.token = token;
			this.response = token.json();
		}

		@Override
		public String getResponse() {
			return response;
		}

		@Override
		public void bindEncoder(AuthEncoder authEncoder) {
			this.authEncoder = authEncoder;
		}

		@Override
		public AuthEncoder getAuthEncoder() {
			return authEncoder;
		}

		@Override
		public Token getToken() {
			return token;
		}

		@Override
		public void flush() throws IOException {
			if (isFlushed)
				throw new IOException("The Response has already been flushed");
			isFlushed = true;
		}

		@Override
		public void clear() throws IOException {
			if (isFlushed)
				throw new IOException("The Response has already been flushed");
			this.response = new String();
		}

		@Override
		public void append(String append) throws IOException {
			StringBuilder builder = new StringBuilder();
			builder.append(response);
			builder.append(append);
			this.response = builder.toString();
		}

	}

	@Override
	public void init(String request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
}
