package com.photoshare.auth.context;

import java.io.IOException;

import javax.servlet.ServletException;

/**
 * @author Aron
 * 
 */
public interface Pipeline {

	// ------------------------------------------------------------- Properties
	
	public void setContext(Context context);
	
	/**
	 * <p>
	 * Return the Valve instance that has been distinguished as the basic Valve
	 * for this Pipeline (if any).
	 */
	public Valve getBasic();

	/**
	 * <p>
	 * Set the Valve instance that has been distinguished as the basic Valve for
	 * this Pipeline (if any). Prioer to setting the basic Valve, the Valve's
	 * <code>setContainer()</code> will be called, if it implements
	 * <code>Contained</code>, with the owning Container as an argument. The
	 * method may throw an <code>IllegalArgumentException</code> if this Valve
	 * chooses not to be associated with this Container, or
	 * <code>IllegalStateException</code> if it is already associated with a
	 * different Container.
	 * </p>
	 * 
	 * @param valve
	 *            Valve to be distinguished as the basic Valve
	 */
	public void setBasic(Valve valve);

	// --------------------------------------------------------- Public Methods

	/**
	 * <p>
	 * Add a new Valve to the end of the pipeline associated with this
	 * Container. Prior to adding the Valve, the Valve's
	 * <code>setContainer()</code> method will be called, if it implements
	 * <code>Contained</code>, with the owning Container as an argument. The
	 * method may throw an <code>IllegalArgumentException</code> if this Valve
	 * chooses not to be associated with this Container, or
	 * <code>IllegalStateException</code> if it is already associated with a
	 * different Container.
	 * </p>
	 * 
	 * @param valve
	 *            Valve to be added
	 * 
	 * @exception IllegalArgumentException
	 *                if this Container refused to accept the specified Valve
	 * @exception IllegalArgumentException
	 *                if the specifie Valve refuses to be associated with this
	 *                Container
	 * @exception IllegalStateException
	 *                if the specified Valve is already associated with a
	 *                different Container
	 */
	public void addValve(Valve valve);

	/**
	 * Return the set of Valves in the pipeline associated with this Container,
	 * including the basic Valve (if any). If there are no such Valves, a
	 * zero-length array is returned.
	 */
	public Valve[] getValves();

	/**
	 * Cause the specified request and response to be processed by the Valves
	 * associated with this pipeline, until one of these valves causes the
	 * response to be created and returned. The implementation must ensure that
	 * multiple simultaneous requests (on different threads) can be processed
	 * through the same Pipeline without interfering with each other's control
	 * flow.
	 * 
	 * @param valveContext
	 * @throws IOException
	 * @throws ServletException
	 */
	public void invoke(Request request, Response response,
			ValveContext valveContext) throws ValveException;

	/**
	 * Remove the specified Valve from the pipeline associated with this
	 * Container, if it is found; otherwise, do nothing. If the Valve is found
	 * and removed, the Valve's <code>setContainer(null)</code> method will be
	 * called if it implements <code>Contained</code>.
	 * 
	 * @param valve
	 *            Valve to be removed
	 */
	public void removeValve(Valve valve);
}
