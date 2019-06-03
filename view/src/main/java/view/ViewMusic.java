package view;

import java.io.File;

/**
 * The Class ViewFrame.
 *
 * @author Valentin pain
 */
class ViewMusic implements Runnable{
	
	/** Instanciate new File **/
	File backgroundMusic = new File("Songs\\boulderDashTheme.wav");
	
	/** The viewFrame **/
	private ViewFrame viewFrame;
	
	/**
	 * Constructor ViewFrame
	 * @param viewFrame
	 */
	public ViewMusic(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	
	/**
	 * 
	 * Play the music
	 */
	@Override
	public void run() {
			this.getViewFrame().playBackGroundMusic(backgroundMusic);
	}
	
	/**
	 * get the ViewFrame
	 * @return viewFrame
	 */
	public ViewFrame getViewFrame() {
		return viewFrame;
	}

	/**
	 * 
	 * set the viewFrame
	 * @param viewFrame
	 */
	public void setViewFrame(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
}