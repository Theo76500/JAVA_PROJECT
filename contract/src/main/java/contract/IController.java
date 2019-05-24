package contract;

/**
 * The Interface IController.
 *
 * @author LANGLOIS Theo
 */
public interface IController {

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
	
	
	/**
	 * Set the model of the controller
	 *
	 * @param model
	 * The model of the controller
     */
	public void setModel(IModel model);
	
	
	/**
	 * Start the game
	 */
	public void start();
	
	
}
