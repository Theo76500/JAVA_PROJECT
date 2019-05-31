package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.GameOver;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

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
		
		model.loadLevel(1);
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
		
		boolean isCheckGood = true;
		boolean isCheckGoodMovingBoulder;
		boolean isCheckInteraction = true;
		
		switch (controllerOrder) {
		
			case LEFT:
				isCheckGood = model.checkCollision(model.getCoordXHero() - 1, model.getCoordYHero());
				isCheckGoodMovingBoulder = model.checkCollisionBoulder(model.getCoordXHero() - 1, model.getCoordYHero());
				isCheckInteraction = model.checkInteraction(model.getCoordXHero() - 1, model.getCoordYHero());
				
				if(isCheckGood && isCheckInteraction) {
					model.setCharacterCoords(model.getCoordXHero() - 1, model.getCoordYHero());
					model.setDirection("left");
					System.out.println("left");
				}
				if(isCheckGoodMovingBoulder == false) {
					model.setBoulderLeft(true);
				}else {
					model.setBoulderLeft(false);
					model.setBoulderRight(false);

				}
				break;
				
			case RIGHT:
				isCheckGood = model.checkCollision(model.getCoordXHero() + 1, model.getCoordYHero());
				isCheckGoodMovingBoulder = model.checkCollisionBoulder(model.getCoordXHero() + 1, model.getCoordYHero());
				isCheckInteraction = model.checkInteraction(model.getCoordXHero() + 1, model.getCoordYHero());
				
				if(isCheckGood && isCheckInteraction) {
					model.levelCamera(model.getLevelTab());
					model.setCharacterCoords(model.getCoordXHero() + 1, model.getCoordYHero());
					model.setDirection("right");
					System.out.println("right");
				}
				if(isCheckGoodMovingBoulder == false) {
					model.setBoulderRight(true);
				}
				else {
					model.setBoulderRight(false);
					model.setBoulderLeft(false);

				}
				break;
				
			case UP:
				isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() - 1);
				isCheckInteraction = model.checkInteraction(model.getCoordXHero(), model.getCoordYHero() - 1);
				
				if(isCheckGood && isCheckInteraction) {
					model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() - 1);
					model.setDirection("up");
					System.out.println("up");
				}
				break;
				
			case DOWN:
				isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() + 1);
				isCheckInteraction = model.checkInteraction(model.getCoordXHero(), model.getCoordYHero() + 1);
				
				if(isCheckGood && isCheckInteraction) {
					model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() + 1);
					model.setDirection("down");
					System.out.println("down");
				}
				break;

			case RETRY:
				GameOver.gameState = false;
				model.loadLevel(1);
				view.printLevel();
				model.setScore(0);
				break;

			default:
				model.setStartLevel();
				model.setDirection("nothing");
				System.out.println("nothing");
				break;
		}
	}

}
