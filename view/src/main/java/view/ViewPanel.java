package view;

import java.awt.*;
import java.awt.image.BufferedImage;
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
class ViewPanel extends JPanel implements Observer{
	
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
		
		Toolkit.getDefaultToolkit().sync();
		
		String[][] levelTab = new String[20][20];
		levelTab = this.getViewFrame().getLevelTab();
		levelTab = this.getViewFrame().getModel().levelBehavior(levelTab);
		
		
		BufferedImage img = null;
		
		int i = 0;
		int j = 0;
		
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  int dimensionX = this.getWidth() / 16;
		  int dimensionY = this.getHeight() / 16;
		  
		  for(String str : subTab)
		  {     
		    //System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " + levelTab[j][i]);
		    if(levelTab[j][i] != null) {
		    	
				  
				 if(levelTab[j][i].equals("BorderBlock")){
					  img = BorderBlock.getImg();
				      graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				  }
				    	
				  if(levelTab[j][i].equals("Diamond")) {
					    img = Diamond.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Dirt")) {
					    img = Dirt.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("DirtAfterHero")) {
					    img = DirtAfterHero.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Boulder")) {
					    img = Boulder.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("ExitDoor")) {
					    img = ExitDoor.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				  if(levelTab[j][i].equals("Enemy")) {
					    img = Enemy.getImg();
				    	graphics.drawImage(img, j * dimensionX, i * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);
				    }
				  
				
				  Entity hero = new Hero();
			      img = hero.loadImage(1);
			      graphics.drawImage(img, this.getViewFrame().getModel().getCoordXHero() * dimensionX, this.getViewFrame().getModel().getCoordYHero() * dimensionY, this.getWidth() / 16, this.getHeight() / 16, this);

				if (this.getViewFrame().getModel().getGameOver() == true)
				{
					try {
						img = ImageIO.read(new File("model\\src\\main\\resources\\sprites\\GameOver.png"));
						graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				try {
					img = ImageIO.read(new File("model\\src\\main\\resources\\sprites\\clockBoard.png"));
					graphics.drawImage(img, 20, 95, this.getWidth() /4, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					img = ImageIO.read(new File("model\\src\\main\\resources\\sprites\\DiamondBoard.png"));
					graphics.drawImage(img, 20, 40, this.getWidth() /4, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

				try {
					img = ImageIO.read(new File("model\\src\\main\\resources\\sprites\\ScoreBoard.png"));
					graphics.drawImage(img, 270, 10, this.getWidth() /3, this.getHeight() /13, this);
				} catch (IOException e) {
					e.printStackTrace();
				}

				String diamond = String.valueOf(this.getViewFrame().getModel().getDiamond());
				Font font = new Font("TimesRoman", Font.BOLD, 42);
				graphics.setFont(font);
				graphics.setColor(Color.white);
				graphics.drawString(diamond, 132, 82);


				String timeleft = String.valueOf(this.getViewFrame().getModel().getTimeLeft());
				Font fonte = new Font("TimesRoman", Font.BOLD, 42);
				graphics.setFont(fonte);
				graphics.setColor(Color.white);
				graphics.drawString(timeleft, 110, 137);

			}
		    i++;
		  }
		  j++;
		}
	}
}