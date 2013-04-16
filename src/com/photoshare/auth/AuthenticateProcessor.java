package com.photoshare.auth;

import com.photoshare.auth.context.AuthenticateValve;
import com.photoshare.auth.context.AuthenticationPipeline;
import com.photoshare.auth.context.BaseRequest;
import com.photoshare.auth.context.BaseResponse;
import com.photoshare.auth.context.Context;
import com.photoshare.auth.context.DecoderValve;
import com.photoshare.auth.context.GetTokenValve;
import com.photoshare.auth.context.LoginEntryValve;
import com.photoshare.auth.context.Pipeline;
import com.photoshare.auth.context.Processor;
import com.photoshare.auth.context.ProcessorException;
import com.photoshare.auth.context.Request;
import com.photoshare.auth.context.Response;
import com.photoshare.auth.context.ValidationValve;
import com.photoshare.auth.context.ValveException;

public class AuthenticateProcessor implements Processor {

	private Pipeline pipeline;

	private Context context;

	@Override
	public String process() throws ProcessorException {
		// TODO Auto-generated method stub
		pipeline = new AuthenticationPipeline();
		context = new AuthenticateContext();
		pipeline.setBasic(new LoginEntryValve());
		pipeline.addValve(new DecoderValve());
		pipeline.addValve(new ValidationValve());
		pipeline.addValve(new AuthenticateValve());
		pipeline.addValve(new GetTokenValve());
		pipeline.setContext(context);
		try {
			pipeline.invoke(context.getRequest(), context.getResponse(), null);
		} catch (ValveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return context.getResponse().getResponse();
	}

	protected class AuthenticateContext implements Context {

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
}