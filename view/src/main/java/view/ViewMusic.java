package view;

import java.io.File;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewMusic implements Runnable{

	File backgroundMusic = new File("Songs\\boulderDashTheme.wav");
	
	private ViewFrame viewFrame;
	
	public ViewMusic(ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}
	
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
}