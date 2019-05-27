package view;

import contract.IController;

/**
* Class View
* @author LANGLOIS Theo
*/

public class View implements IView {
	
	private ViewFrame frame;
	
	public View() {
		this.frame = new ViewFrame();
	}
	
	public void repaint()
	{
		
	}
	
	public void openFrame()
	{
		this.frame.setVisible(true);
	}
	
	
	public void closeFrame()
	{
		this.frame.setVisible(false);
	}
	
	
	public Observer getObserver()
	{
		return this.frame.getViewPanel();
	}
	
	public void setController(IController controller)
	{
		this.frame.setController(controller);
	}
	
	
	
	
}