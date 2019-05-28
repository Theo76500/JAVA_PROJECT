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
	private IView		view;

	/** The model. */
	private IModel	model;

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
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		
		model.loadLevel();
		view.printLevel();
	}

	public IView getView() {
		return view;
	}
	
	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
     * Order perform.
     *
     * @param controllerOrder
     *            the controller order
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		
		switch (controllerOrder) {
		
			case LEFT:
				model.setCharacterCoords(model.getCoordXHero() - 1, model.getCoordYHero());
				System.out.println("left");
				break;
				
			case RIGHT:
				model.setCharacterCoords(model.getCoordXHero() 	+ 1, model.getCoordYHero());
				System.out.println("right");
				break;
				
			case UP:
				model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() - 1);
				System.out.println("up");
				break;
				
			case DOWN:;
			model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() + 1);
				System.out.println("down");
				break;
				
			default:
				break;
		}
	}

}
