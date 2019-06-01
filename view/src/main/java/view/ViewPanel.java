package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
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
	
	public int getDimensionX() {
		return dimensionX;
	}

	public void setDimensionX(int dimensionX) {
		this.dimensionX = dimensionX;
	}

	public int getDimensionY() {
		return dimensionY;
	}

	public void setDimensionY(int dimensionY) {
		this.dimensionY = dimensionY;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	
	
	Entity hero = new Hero();
	Entity enemy = new Enemy();
	public int dimensionX = this.getWidth() / 16;
	public int dimensionY = this.getHeight() / 16;
	
	public BufferedImage img = null;
	
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
		Toolkit.getDefaultToolkit().sync();

	}

	@Override
	protected void paintComponent(final Graphics graphics) {		
		//this.getViewFrame().getModel().setLevelTab(this.getViewFrame().getModel().levelBehavior(this.getViewFrame().getModel().getLevelTab()));
		//this.getViewFrame().getModel().setLevelCamera(this.getViewFrame().getModel().getLevelTab());s
		
		int i = 0;
		int j = 0;
		
		this.setDimensionX(this.getWidth() / 16);
		this.setDimensionY(this.getHeight() / 16);
		
		for(String subTab[] : this.getViewFrame().getModel().getLevelCamera()){
		  i = 0;
		  for(String str : subTab) {     
		   //System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " +this.getViewFrame().getModel().getLevelCamera()[j][i]);
		   if(this.getViewFrame().getModel().getLevelCamera()[j][i] != null) {
			   
		    	printBorderBlock(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printDirt(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printDiamond(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printDirtAfterHero(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printBoulder(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printExitDoor(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printEnemy(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	
		    	printHeroNothing(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printHeroRight(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printHeroLeft(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printHeroDown(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	printHeroUp(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
		    	
		    	printGameOver(graphics);
		    	printGameWin(graphics);
		    	
		    	printExitMessage(graphics);
		    	printScore(graphics);
		    	printDiamondsLeft(graphics);
		    	printTimer(graphics);
		    	

					Font font = new Font("TimesRoman", Font.BOLD, 42);
					graphics.setFont(font);
					graphics.setColor(Color.white);
					graphics.drawString(String.valueOf(this.getViewFrame().getModel().getDiamond()), 110, 82);
					
					if(!GameWin.gameState){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getTimeLeft() / 3), 110, 137);
					}
				
					if(GameOver.gameState || GameWin.gameState) {
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getFinalTime()), 110, 137);
					}
					if(GameWin.gameState == false){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getScore()), 385, 53);
					}

					if(GameWin.gameState == true){
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getFinalScore()), 385, 53);
					}
		    }
		    i++;
		  }
		  j++;
		}
	}
	
	public void printBorderBlock(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		 if(levelCamera[j][i].equals("BorderBlock")){
			  this.setImg(BorderBlock.getImg());
		      graphics.drawImage(this.getImg(), j * this.getDimensionX(), i * this.getDimensionY(), this.getDimensionX(), this.getDimensionY(), this);
		  }
	}
	
	public void printDirt(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		 if(levelCamera[j][i].equals("Dirt")){
			  img = Dirt.getImg();
		      graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		  }
	}
	
	public void printDiamond(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		if(levelCamera[j][i].equals("Diamond")) {
	  		if (this.getViewFrame().getModel().isDiamondSprite() == true){
				img = Diamond.img;
				graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			}
	  		
	  		if (this.getViewFrame().getModel().isDiamondSprite() == false){
				img = Diamond.img2;
				graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			}
	    }
	}
	
	public void printDirtAfterHero(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		  if(levelCamera[j][i].equals("DirtAfterHero")) {
			    img = DirtAfterHero.getImg();
		    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		  }
	    }
	
	public void printBoulder(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		  if(levelCamera[j][i].equals("Boulder")) {
			    img = Boulder.getImg();
		    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		  }
	    }
	
	public void printExitDoor(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		  if(levelCamera[j][i].equals("ExitDoor") && this.getViewFrame().getModel().getDiamond() == 0) {
			    img = ExitDoor.getImg();
		    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		  }
	    }
	
	public void printEnemy(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		
		//System.out.println("x = " +this.getViewFrame().getModel().getCoordXEnemy());
		//System.out.println("y = " +this.getViewFrame().getModel().getCoordYEnemy());
		
		  	/*if(levelCamera[j][i].equals("Enemy")) {
			    img = Enemy.getImg();
		    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		  }*/
		
		if(levelCamera[j][i].equals("Enemy")) {
		    img = enemy.loadImage(1);
	    	graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		}
	  }
	
	public void printHeroNothing(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		  if(this.getViewFrame().getModel().getDirection().equals("nothing") && levelCamera[j][i].equals("Hero")) {
			  img = hero.loadImage(1);
			  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		    }
	    }
	
	public void printHeroRight(Graphics graphics, int i, int j, String[][] levelCamera) {
		
		 if(this.getViewFrame().getModel().getDirection().equals("right") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroright() == true) {
			  img = hero.loadImage(2);
			  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		    }
		 if(this.getViewFrame().getModel().getDirection().equals("right") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroright() == false) {
			  img = hero.loadImage(6);
			  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
		    }
	}
		 
		 public void printHeroLeft(Graphics graphics, int i, int j, String[][] levelCamera) {

			 if(this.getViewFrame().getModel().getDirection().equals("left") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroleft() == true) {
				  img = hero.loadImage(3);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
			 
			 if(this.getViewFrame().getModel().getDirection().equals("left") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroleft() == false) {
				  img = hero.loadImage(7);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
		 }
		 
		 public void printHeroDown(Graphics graphics, int i, int j, String[][] levelCamera) {

			 if(this.getViewFrame().getModel().getDirection().equals("down") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHerodown() == true) {
				  img = hero.loadImage(4);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
			 
			 if(this.getViewFrame().getModel().getDirection().equals("down") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHerodown() == false) {
				  img = hero.loadImage(8);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
		 }
		 
		 public void printHeroUp(Graphics graphics, int i, int j, String[][] levelCamera) {

			 if(this.getViewFrame().getModel().getDirection().equals("up") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroup() == true) {
				  img = hero.loadImage(5);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
			 
			 if(this.getViewFrame().getModel().getDirection().equals("up") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroup() == false) {
				  img = hero.loadImage(9);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
		 }	 
		 
		 public void printScore(Graphics graphics) {
				
				img = Score.img;
				graphics.drawImage(img, 307, 12, this.getWidth() /4, this.getHeight() /13, this);
		 }
		 
		 public void printDiamondsLeft(Graphics graphics) {
				
					img = DiamondsLeft.img;
					graphics.drawImage(img, 20, 40, this.getWidth() /4, this.getHeight() /13, this);
		 }
		 
		 public void printTimer(Graphics graphics) {
					img = Timer.img;
					graphics.drawImage(img, 20, 95, this.getWidth() /4, this.getHeight() /13, this);
		 }
		 
		 public void printGameOver(Graphics graphics) {
				if(GameOver.gameState == true) {
			      	  img = GameOver.img;
			    	  graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				}
		 }
		 
		 public void printGameWin(Graphics graphics) {
				
				 if (GameWin.gameState == true && this.getViewFrame().getModel().getDiamond() == 0){
			      	  img = GameWin.img;
			    	  graphics.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    	}
		 }
		 
		 public void printExitMessage(Graphics graphics){
			 if(this.viewFrame.getModel().getDiamond() == 0 && this.getViewFrame().getModel().isExit() && !GameOver.gameState && !GameWin.gameState) {
				 try {
					img = ImageIO.read(new File("Sprites\\exit.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
				 System.out.println(this.getViewFrame().getModel().getCoordXHero());
				 System.out.println(this.getViewFrame().getModel().getCoordYHero());
				 
		    	 graphics.drawImage(img, this.getViewFrame().getModel().getCoordXHero() + 300, this.getViewFrame().getModel().getCoordYHero() + 75, 150, 75, this);
			 }
		 }
	
}