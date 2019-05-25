package controller;

import java.awt.event.KeyEvent;
import java.util.List;

import model.IModel;
import view.IView;

/**
 * Design Pattern Facade Controller.
 *
 * @author LALISSE Adrien
 */

public class ControllerFacade implements IController {
	private final IView view;
	private final IModel model;
	
	public ControllerFacade(final IView view, final IModel model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	public void start() {
		
	}
	
	public IView getView() {
		return this.view;
	}
	
	public IModel getModel() {
		return this.model;
	}
}
