package com.photoshare.auth.context;

public class SimpleUnAuthorizePipeline extends PipelineSupport {

	private Context context;

	@Override
	public void invoke(Request request, Response response,
			ValveContext valveContext) throws ValveException {
		(new SimplePipelineValveContext()).invokeNext(request, response,
				valveContext);
	}

	protected class SimplePipelineValveContext implements ValveContext {

		protected int stage = 0;

		public String getInfo() {
			return null;
		}

		@Override
		public void invokeNext(Request request, Response response,
				ValveContext valveContext) throws ValveException {
			int subscript = stage;
			stage = stage + 1;
			// Invoke the requested Valve for the current request thread
			if (subscript < valves.length) {
				valves[subscript].invoke(this);
			} else if (subscript == valves.length && (basic != null)) {
				basic.invoke(this);
			} else {
				throw new ValveException(404, "No valve");
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
