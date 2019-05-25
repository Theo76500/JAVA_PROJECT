package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import contract.IMouvement;

/**
 * The Class Controller.
 * @author LALISSE Adrien
 */
public final class Controller implements IController {

	/** The view. */

	/** The model. */
	private IModel	model;
	private IView view;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(IModel model) {
		this.model = model;
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	public void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	public void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Perform an order to the controller
	 *
	 * @param order
	 * The order to perform
     */
	public void orderPerform(ControllerOrder controllerOrder) {
		System.out.println(controllerOrder);
		switch (controllerOrder) {
		case CHARACTER_UP:
			this.mouvement.movePlayer("UP");
			break;
			
		case CHARACTER_DOWN:
			this.mouvement.movePlayer("DOWN");
			break;
			
		case CHARACTER_LEFT:
			this.model.mouvement("LEFT");
			break;
			
		case CHARACTER_RIGHT:
			this.model.mouvement("RIGHT");
			break;
			
		case RETRY:
			System.exit(0);
			break;
		}
		model.getUser().setDirection(direction);
		//model.collision();
	}
	
	
}
