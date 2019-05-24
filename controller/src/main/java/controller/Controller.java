package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;
	
	/** The thread of the clock */
	private Thread clockThread;
	
	/** The clock */
	private Clock clock;

	public static int LEVELID = 1;
	
	
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
     * Start the game
	 */
	public void start(){
		if(this.model.loadlevel(1)){
			this.view.openFrame();
			this.model.flush();
			
			this.clock = new Clock();
			this.clockThread = new Thread(this.clock);
			this.clockThread.start();
			
		} else {
			System.out.println("ERROR : Can't load level : "+LEVELID);
		}
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

	}
	
	
}
