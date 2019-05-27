package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entity.BorderBlock;
import entity.Boulder;
import entity.Diamond;
import entity.Dirt;
import entity.DirtAfterHero;
import entity.Enemy;
import entity.Entity;
import entity.ExitDoor;
import entity.Hero;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		//graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		//graphics.drawString(this.getViewFrame().getModel().getHelloWorld().getMessage(), 10, 20);
		
		String[][] levelTab = new String[20][20];
		levelTab = this.getViewFrame().getLevelTab();
		levelTab = this.getViewFrame().getModel().levelBehavior(levelTab);
		
		Image img = null;
		
		int i = 0;
		int j = 0;
		 
		//this.removeAll();
		this.repaint();
		this.removeAll();
		
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  int dimensionX = this.getWidth() / 16;
		  int dimensionY = this.getHeight() / 16;
		  
		  for(String str : subTab)
		  {     
		    System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " + levelTab[j][i]);
		    if(levelTab[j][i] != null) {
				  
				  if(levelTab[j][i].equals("BorderBlock")){
				    	Entity borderBlock = new BorderBlock("BorderBlock", false, j, i);
				    	img = borderBlock.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				  }
				    	
				  if(levelTab[j][i].equals("Diamond")) {
				    	Entity diamond = new Diamond("Diamond", false, j, i);
				    	img = diamond.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Dirt")) {
				    	Entity dirt = new Dirt("Dirt", false, j, i);
				    	img = dirt.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("DirtAfterHero")) {
				    	Entity dirtafterhero = new DirtAfterHero("DirtAfterHero", false, j, i);
				    	img = dirtafterhero.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Boulder")) {
				    	Entity boulder = new Boulder("Boulder", false, j, i);
				    	img = boulder.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("ExitDoor")) {
				    	Entity exitdoor = new ExitDoor("ExitDoor", false, j, i);
				    	img = exitdoor.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Enemy")) {
				    	Entity enemy = new Enemy("Enemy", false, j, i);
				    	img = enemy.loadImage(1);
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }

				try {
					img = ImageIO.read(new File("entity\\ressource\\clockBoard.png"));
					graphics.drawImage(img, 20, 95, this.getWidth() /4, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					img = ImageIO.read(new File("entity\\ressource\\DiamondBoard.png"));
					graphics.drawImage(img, 20, 40, this.getWidth() /4, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					img = ImageIO.read(new File("entity\\ressource\\ScoreBoard.png"));
					graphics.drawImage(img, 270, 10, this.getWidth() /3, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}



				String diamond = String.valueOf(this.getViewFrame().getModel().getDiamond());
				Font font = new Font("TimesRoman", Font.BOLD, 42);
				graphics.setFont(font);
				graphics.setColor(Color.white);
				graphics.drawString(diamond, 150, 82);


				String timeleft = String.valueOf(this.getViewFrame().getModel().getTimeLeft());
				Font fonte = new Font("TimesRoman", Font.BOLD, 42);
				graphics.setFont(fonte);
				graphics.setColor(Color.white);
				graphics.drawString(timeleft, 110, 137);
				  
				  Entity hero = new Hero();
			      img = hero.loadImage(1);
			      graphics.drawImage(img, this.getViewFrame().getModel().getCoordXHero() * dimensionX, this.getViewFrame().getModel().getCoordYHero() * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
		    }
		    i++;
		  }
		  j++;
		}
	}
}