package contract;

import entity.RowLevel;

/**
 * The Interface IController.
 *
 * @author LANGLOIS Theo
 */
public interface IController {

	/**
	 * Control.
	 */
	public void control();

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 */
	public void orderPerform(ControllerOrder controllerOrder);
}
