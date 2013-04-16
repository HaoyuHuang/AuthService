package com.photoshare.auth.context;

public class AuthorizePipeline extends PipelineSupport {

	private Context context;

	@Override
	public void invoke(Request request, Response response,
			ValveContext valveContext) throws ValveException {
		// Invoke the first Valve in this pipeline for this request
		(new SimplePipelineValveContext()).invokeNext(request, response,
				valveContext);
	}

	// this class is copied from org.apache.catalina.core.StandardPipeline
	// class's
	// StandardPipelineValveContext inner class.
	protected class SimplePipelineValveContext implements ValveContext {

		protected int stage = 0;

		public String getInfo() {
			return null;
		}

		@Override
		public void invokeNext(Request request, Response response,
				ValveContext valveContext) throws ValveException {
			// TODO Auto-generated method stub
			int subscript = stage;
			stage = stage + 1;
			// Invoke the requested Valve for the current request thread
			if (subscript < valves.length) {
				valves[subscript].invoke(this);
			} else if ((subscript == valves.length) && (basic != null)) {
				basic.invoke(this);
			} else {
				throw new ValveException("No valve");
			}
		}

		@Override
		public Context getContext() {
			// TODO Auto-generated method stub
			return context;
		}
	} // end of inner class

	public void setContext(Context context) {
		this.context = context;
	}

}
