package view;

import java.io.File;

import contract.IModel;
import entity.GameOver;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewMusic implements Runnable{

	File backgroundMusic = new File("Songs\\boulderDashTheme.wav");
	
	private ViewFrame viewFrame;
	
	/** The model. */
	//private IModel model;
	
	@Override
	public void run() {
			this.getViewFrame().playBackGroundMusic(backgroundMusic);
	}
	
	public ViewFrame getViewFrame() {
		return viewFrame;
	}

	public void setViewFrame(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*public ViewMusic(
			//final IModel model, 
			ViewFrame viewFrame){
		//this.setModel(model);
		this.viewFrame = viewFrame;
	}*/

	public ViewMusic(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	/*protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	/*private void setModel(final IModel model) {
		this.model = model;
	}*/
}