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

	public IModel getModel() {
		return model;
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
		view.loadLevelInTab();
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
				triggerLeft();
				break;
				
			case RIGHT:
				triggerRight();
				break;
				
			case UP:
				triggerUp();
				break;
				
			case DOWN:
				triggerDown();
				break;

			case NEXT:
				triggerNext();
				break;
				
			case RETRY:
				triggerRetry();
				break;

			default:
				model.setStartLevel();
				model.setDirection("nothing");
				break;
		}
	}
	
	public void triggerLeft() {
		
		boolean isCheckGood = true;
		boolean isCheckGoodMovingBoulder;
		boolean isCheckInteraction = true;
		
		isCheckGood = this.getModel().checkCollision(this.getModel().getCoordXHero() - 1, this.getModel().getCoordYHero());
		isCheckGoodMovingBoulder = this.getModel().checkCollisionBoulder(this.getModel().getCoordXHero() - 1, this.getModel().getCoordYHero());
		isCheckInteraction = this.getModel().checkInteraction(model.getCoordXHero() - 1, this.getModel().getCoordYHero());
		
		if(isCheckGood && isCheckInteraction) {
			this.getModel().setCharacterCoords(this.getModel().getCoordXHero() - 1, this.getModel().getCoordYHero());
			this.getModel().setDirection("left");
		}
		if(isCheckGoodMovingBoulder == false) {
			this.getModel().setBoulderLeft(true);
		}else {
			this.getModel().setBoulderLeft(false);
			this.getModel().setBoulderRight(false);
		}
	}
	
	public void triggerRight() {
		
		boolean isCheckGood = true;
		boolean isCheckGoodMovingBoulder;
		boolean isCheckInteraction = true;
		
		isCheckGood = model.checkCollision(model.getCoordXHero() + 1, model.getCoordYHero());
		isCheckGoodMovingBoulder = model.checkCollisionBoulder(model.getCoordXHero() + 1, model.getCoordYHero());
		isCheckInteraction = model.checkInteraction(model.getCoordXHero() + 1, model.getCoordYHero());
		
		if(isCheckGood && isCheckInteraction) {
			model.levelCam(model.getLevelTab());
			model.setCharacterCoords(model.getCoordXHero() + 1, model.getCoordYHero());
			model.setDirection("right");
		}
		if(isCheckGoodMovingBoulder == false) {
			model.setBoulderRight(true);
		}
		else {
			model.setBoulderRight(false);
			model.setBoulderLeft(false);
		}
	}
	
	public void triggerUp() {
		
		boolean isCheckGood = true;
		boolean isCheckInteraction = true;
		
		isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() - 1);
		isCheckInteraction = model.checkInteraction(model.getCoordXHero(), model.getCoordYHero() - 1);
		
		if(isCheckGood && isCheckInteraction) {
			model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() - 1);
			model.setDirection("up");
		}
	}
	
	public void triggerDown() {
		
		boolean isCheckGood = true;
		boolean isCheckInteraction = true;
		
		isCheckGood = model.checkCollision(model.getCoordXHero(), model.getCoordYHero() + 1);
		isCheckInteraction = model.checkInteraction(model.getCoordXHero(), model.getCoordYHero() + 1);
		
		if(isCheckGood && isCheckInteraction) {
			model.setCharacterCoords(model.getCoordXHero(), model.getCoordYHero() + 1);
			model.setDirection("down");
		}
	}
	
	public void triggerNext() {
		GameOver.gameState = false;
		GameWin.gameState = false;
		model.setReadyToLeave(false);
		if(model.getLevelNumber() < 5) {
			model.setLevelNumber(model.getLevelNumber() + 1);
		}
		else {
			model.setLevelNumber(1);
		}
		model.setCoordXEnemy(7);
		model.setCoordYEnemy(14);
		model.loadLevel(model.getLevelNumber());
		view.loadLevelInTab();
		model.setStartLevel();
	}
	
	public void triggerRetry() {
		GameOver.gameState = false;
		GameWin.gameState = false;
		Timer.timerOn = true;
		model.setLevelNumber(1);
		model.setReadyToLeave(false);
		model.loadLevel(model.getLevelNumber());
		view.loadLevelInTab();
		model.setCoordXHero(4);
		model.setCoordYHero(4);
		model.setCoordXEnemy(7);
		model.setCoordYEnemy(14);
		model.setScore(0);
		model.setTimeLeft(360);
		model.setStartLevel();
	}
}
