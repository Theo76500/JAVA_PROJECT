package view;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;

/**
 * Class ViewFrame.
 *
 * @author LANGLOIS Theo
 */
class ViewFrame extends JFrame implements KeyListener {
	

		private int width = 655;
		
		private int height = 465;
		
		private IController controller;
		
		private ViewPanel panel;
		
		ViewFrame()
		{
			this.setTitle("Boulder Dash");
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.panel = new ViewPanel();
			this.panel.setBackground(Color.BLACK);
			this.setContentPane(this.panel);
			this.setResizable(false);
			
			this.addKeyListener(this);
		}
		
		public void repaint()
		{
			this.panel.repaint();
		}
		
		public int getWidth()
		{
			return width;
		}
		
		public int getHeight()
		{
			return height;
		}
		
		public IController getController()
		{
			return controller;
		}
		
		public void setController(IController controller)
		{
			this.controller = controller;
		}
		
		
		public void keyPressed(KeyEvent e) 
		{
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_Z: 
				case KeyEvent.VK_W:
				case KeyEvent.VK_UP:
				this.controller.orderPerform(ControllerOrder.CHARACTER_UP);
				break;
				
				
				case KeyEvent.VK_S:
				case KeyEvent.VK_DOWN:
				this.controller.orderPerform(ControllerOrder.CHARACTER_DOWN);
				break;
				
				
				case KeyEvent.VK_Q:
				case KeyEvent.VK_LEFT:
				this.controller.orderPerform(ControllerOrder.CHARACTER_LEFT);
				break;
				
				
				case KeyEvent.VK_D:
				case KeyEvent.VK_RIGHT:
				this.controller.orderPerform(ControllerOrder.CHARACTER_RIGHT);
				break;
				

				case KeyEvent.VK_R:
					this.controller.orderPerform(ControllerOrder.RETRY);
					break;
					
			}
		}
		
		public void keyReleased(KeyEvent e)
		{
			
		}
		
		public void KeyTyped(KeyEvent e)
		{
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
}
