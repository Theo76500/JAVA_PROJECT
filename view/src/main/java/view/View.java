package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Pierre Forques
 */
public final class View implements IView, Runnable {

	/** The levelTab */
	//private String[][] levelTab = new String[20][20];
	
	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	//public ViewFrame getViewFrame() {
		//return viewFrame;
	//}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 * @throws InterruptedException 
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_D:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_S:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_R:
				return ControllerOrder.RETRY;
			case KeyEvent.VK_N:
				return ControllerOrder.NEXT;

			default:
				return ControllerOrder.NOTHING;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void loadLevelInTab() {
		this.viewFrame.loadLevelInTab();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
