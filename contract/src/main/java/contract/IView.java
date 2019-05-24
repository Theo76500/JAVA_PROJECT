package contract;

import java.util.Observable;

/**
 * The Interface IView.
 *
 * @author LANGLOIS Theo
 */
public interface IView {

	/**
	 update the screen
	 */
	void repaint();
	
	/**
	 * Open the frame
	 */
	void openFrame();
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * Set the controller of the view
	 */
	void setController(IController controller);
	
}
