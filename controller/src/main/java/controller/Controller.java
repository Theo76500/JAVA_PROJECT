package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.GameOver;
import entity.GameWin;
import entity.Timer;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
	
	/** The level */
	public static int level;
	
	public int getLevel() {return level;}
	public void setLevel(int level) {Controller.level = level;}

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
		
		switch (controllerOrder) {
		
			case LEFT:
				isCheckGood = model.checkCollision(model.getCoordXHero() - 1, model.getCoordYHero());
				
				if(isCheckGood) {
					model.setCharacterCoords(model.getCoordXHero() - 1, model.getCoordYHero());
					model.setDirection("left");
				}
				break;
				
			case RIGHT:
				isCheckGood = model.checkCollision(model.getCoordXHero() + 1, model.getCoordYHero());
				
				if(isCheckGood) {
					model.levelCamera(model.getLevelTab());
					model.setCharacterCoords(model.getCoordXHero() + 1, model.getCoordYHero());
					model.setDirection("right");
				}
				break;
				
			case UP:
				isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() - 1);
				
				if(isCheckGood) {
					model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() - 1);
					model.setDirection("up");
				}
				break;
				
			case DOWN:
				isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() + 1);
				
				if(isCheckGood) {
					model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() + 1);
					model.setDirection("down");
					}
				break;

			case RETRY:
				GameOver.gameState = false;
				GameWin.gameState = false;
				Timer.timerOn = true;
				level = 1;
				model.loadLevel(1);
				view.printLevel();
				model.setScore(0);
				break;

			case NEXT:
				GameOver.gameState = false;
				GameWin.gameState = false;
				Timer.timerOn = true;
				level = level + 1;
				model.loadLevel(level +1);
				view.printLevel();
				break;
				
			default:
				model.setStartLevel();
				model.setDirection("nothing");
				break;
		}
	}

}
