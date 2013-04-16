package com.photoshare.auth.context;

public abstract class PipelineSupport implements Pipeline {

	// The basic Valve (if any) associated with this Pipeline.
	protected Valve basic = null;
	// the array of Valves
	protected Valve valves[] = new Valve[0];

	public Valve getBasic() {
		return basic;
	}

	public void setBasic(Valve valve) {
		this.basic = valve;
	}

	public void addValve(Valve valve) {

		synchronized (valves) {
			Valve results[] = new Valve[valves.length + 1];
			System.arraycopy(valves, 0, results, 0, valves.length);
			results[valves.length] = valve;
			valves = results;
		}
	}

	public Valve[] getValves() {
		return valves;
	}

	public abstract void invoke(Request request, Response response,
			ValveContext valveContext) throws ValveException;

	public void removeValve(Valve valve) {
	}

}
