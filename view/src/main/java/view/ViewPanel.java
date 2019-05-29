package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import entity.BorderBlock;
import entity.Boulder;
import entity.Diamond;
import entity.DiamondsLeft;
import entity.Dirt;
import entity.DirtAfterHero;
import entity.Enemy;
import entity.Entity;
import entity.ExitDoor;
import entity.GameOver;
import entity.GameWin;
import entity.Hero;
import entity.Score;
import entity.Timer;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer{
	
	/** The view frame. */
	private ViewFrame viewFrame;
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
		
		Toolkit.getDefaultToolkit().sync();
		
		String[][] levelTab = this.getViewFrame().getModel().levelBehavior(this.getViewFrame().getModel().getLevelTab());
		levelTab = this.getViewFrame().getModel().levelCamera(levelTab);
		
		
		BufferedImage img = null;
		
		int i = 0;
		int j = 0;
		
		int dimensionX = this.getWidth() / 16;
		int dimensionY = this.getHeight() / 16;
		
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  for(String str : subTab)
		  {     
		    //System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " + levelTab[j][i]);
		    if(levelTab[j][i] != null) {
		    	
				 if(levelTab[j][i].equals("BorderBlock")){
					  img = BorderBlock.getImg();
				      graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				  }
				    	
				  if(levelTab[j][i].equals("Diamond")) {
					    img = Diamond.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				  if(levelTab[j][i].equals("Dirt")) {
					    img = Dirt.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				  if(levelTab[j][i].equals("DirtAfterHero")) {
					    img = DirtAfterHero.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				  if(levelTab[j][i].equals("Boulder")) {
					    img = Boulder.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				  if(levelTab[j][i].equals("ExitDoor")) {
					    img = ExitDoor.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				  if(levelTab[j][i].equals("Enemy")) {
					    img = Enemy.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				  
				
				  Entity hero = new Hero();
			      img = hero.loadImage(1);
			      graphics.drawImage(img, this.getViewFrame().getModel().getCoordXHero() * dimensionX, this.getViewFrame().getModel().getCoordYHero() * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
			      
			      
			      if (GameOver.gameState == true){
			    	  img = GameOver.img;
			    	  graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    	}

				  if (GameWin.gameState == true){	
						img = GameWin.img;
				    	graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				    }
				
				img = Score.img;
				graphics.drawImage(img, 307, 12, this.getWidth() /4, this.getHeight() /13, this);

				img = DiamondsLeft.img;
				graphics.drawImage(img, 20, 40, this.getWidth() /4, this.getHeight() /13, this);
				
				img = Timer.img;
				graphics.drawImage(img, 20, 95, this.getWidth() /4, this.getHeight() /13, this);

					Font font = new Font("TimesRoman", Font.BOLD, 42);
					graphics.setFont(font);
					graphics.setColor(Color.white);
					graphics.drawString(String.valueOf(this.getViewFrame().getModel().getDiamond()), 132, 82);
					
					if(this.getViewFrame().getModel().getGameWin() == false){
					graphics.drawString(String.valueOf(this.getViewFrame().getModel().getTimeLeft()), 110, 137);
					}
					
					if(this.getViewFrame().getModel().getGameWin() == true){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getFinalTime()), 110, 137);
					}

					if(this.getViewFrame().getModel().getGameWin() == false){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getScore()), 385, 53);
					}

					if(this.getViewFrame().getModel().getGameWin() == true){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getFinalScore()), 385, 53);
					}
		    }
		    i++;
		  }
		  j++;
		}
	}
}