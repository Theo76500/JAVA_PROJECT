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
	
	Entity hero = new Hero();
	Entity enemy = new Enemy();
	
	public int dimensionX;
	public int dimensionY;
	
	public BufferedImage img = null;
	
	public int getDimensionX() {return dimensionX;}
	public void setDimensionX(int dimensionX) {this.dimensionX = dimensionX;}

	public int getDimensionY() {return dimensionY;}
	public void setDimensionY(int dimensionY) {this.dimensionY = dimensionY;}

	public BufferedImage getImg() {return img;}
	public void setImg(BufferedImage img) {this.img = img;}

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
	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	public void setViewFrame(final ViewFrame viewFrame) {
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
		int i = 0;
		int j = 0;
		this.setDimensionX(this.getWidth() / 16);
		this.setDimensionY(this.getHeight() / 16);
		
		for(String subTab[] : this.getViewFrame().getModel().getLevelCamera()){
		  i = 0;
		  for (int k = 0; k < subTab.length; k++) {
			   if(this.getViewFrame().getModel().getLevelCamera()[j][i] != null) {
				   Font font = new Font("TimesRoman", Font.BOLD, 42);
				   graphics.setFont(font);
				   graphics.setColor(Color.white);
				   printLevel(graphics, i, j, this.getViewFrame().getModel().getLevelCamera());
				 }
			   i++;
			   }
		  j++;
		}
	}
	 
	 public void printLevel(Graphics graphics, int i, int j, String[][] levelCamera) {
		 printMap(graphics, i, j, levelCamera);
		 printHero(graphics,i, j, levelCamera);
		 printGameState(graphics);
		 printInformations(graphics);
		 printStrings(graphics);
	 }
	 
	 public void printMap(Graphics graphics, int i, int j, String[][] levelCamera){
		 printBorderBlock(graphics, i, j, levelCamera);
	     printDirt(graphics, i, j, levelCamera);
	     printDiamond(graphics, i, j, levelCamera);
	     printDirtAfterHero(graphics, i, j, levelCamera);
	     printBoulder(graphics, i, j, levelCamera);
	     printExitDoor(graphics, i, j, levelCamera);
	     printEnemy(graphics, i, j, levelCamera);
	 }
	 
	public void printHero(Graphics graphics, int i, int j, String[][] levelCamera){
		 printHeroNothing(graphics, i, j, levelCamera);
		 printHeroRight(graphics, i, j, levelCamera);
		 printHeroLeft(graphics, i, j, levelCamera);
	     printHeroDown(graphics, i, j, levelCamera);
	     printHeroUp(graphics, i, j, levelCamera);
	 }
	 
	 public void printGameState(Graphics graphics){
		 printGameOver(graphics);
	     printGameWin(graphics);
	 }
	 
	 public void printInformations(Graphics graphics){
	    	printExitMessage(graphics);
	    	printScore(graphics);
	    	printDiamondsLeft(graphics);
	    	printTimer(graphics);
	 }
	 
	 public void printStrings(Graphics graphics) {
		 printStringDiamondsLeft(graphics);
		 printStringTimeLeft(graphics);
		 printStringFinalTime(graphics);
		 printStringScore(graphics);
	 }
	
	public void printBorderBlock(Graphics graphics, int i, int j, String[][] levelCamera) {
		 if(levelCamera[j][i].equals("BorderBlock")){
			 switch(this.getViewFrame().getModel().getLevelNumber()) {
			 case 1 :
				 printBorderBlock1(graphics, i, j);
			      break;
			 case 2 :
				 printBorderBlock2(graphics, i, j);
			      break;
			 case 3 :
				 printBorderBlock3(graphics, i, j);
			      break;   
			 case 4 :
				 printBorderBlock4(graphics, i, j);
			      break; 
			 case 5 :
				 printBorderBlock4(graphics, i, j);
			      break;
			 }
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
		
		if(levelCamera[j][i].equals("Enemy")) {
		    img = enemy.loadImage(1);
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
				 if (GameWin.gameState){
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
		    	 graphics.drawImage(img, this.getViewFrame().getModel().getCoordXHero() + 300, this.getViewFrame().getModel().getCoordYHero() + 75, 150, 75, this);
			 }
		 }
		 
		 public void printStringDiamondsLeft(Graphics graphics) {
			 if (this.getViewFrame().getModel().getDiamond() < 10){
					graphics.drawString("00" +String.valueOf(this.getViewFrame().getModel().getDiamond()), 110, 82);
				}
				else {
					graphics.drawString("0" +String.valueOf(this.getViewFrame().getModel().getDiamond()), 110, 82);
				}
		 }
		 
		 public void printStringTimeLeft(Graphics graphics) {
			 if(!GameWin.gameState && !GameOver.gameState){
				 if (this.getViewFrame().getModel().getTimeLeft() < 30){
						graphics.drawString("00" + String.valueOf(this.getViewFrame().getModel().getTimeLeft() / 3), 110, 137);
					}
					else if (this.getViewFrame().getModel().getTimeLeft() < 300)
					{
						graphics.drawString("0" + String.valueOf(this.getViewFrame().getModel().getTimeLeft() / 3), 110, 137);
					}
					else 
					{
						
						graphics.drawString(String.valueOf(this.getViewFrame().getModel().getTimeLeft() / 3), 110, 137);
					}
				}
		 }
		 
		 public void printStringFinalTime(Graphics graphics) {
				if(GameOver.gameState || GameWin.gameState) {
					graphics.drawString(String.valueOf(this.getViewFrame().getModel().getFinalTime()), 110, 137);
				}
		 }
		 
		 public void printStringScore(Graphics graphics) {
			 if (this.getViewFrame().getModel().getScore() < 10){
					graphics.drawString("00000" + String.valueOf(this.getViewFrame().getModel().getScore()), 327, 53);
				}
			else if (this.getViewFrame().getModel().getScore() < 100)
			{
				graphics.drawString("0000" + String.valueOf(this.getViewFrame().getModel().getScore()), 327, 53);
			}
			else if (this.getViewFrame().getModel().getScore() < 1000)
			{
				graphics.drawString("000" + String.valueOf(this.getViewFrame().getModel().getScore()), 327, 53);
			}
			else if (this.getViewFrame().getModel().getScore() < 10000)
			{
				graphics.drawString("00" + String.valueOf(this.getViewFrame().getModel().getScore()), 327, 53);
			}
			else if (this.getViewFrame().getModel().getScore() < 100000)
			{
				graphics.drawString("0" + String.valueOf(this.getViewFrame().getModel().getScore()), 327, 53);
			}
		 }
		 
		 public void printHeroNothing(Graphics graphics, int i, int j, String[][] levelCamera) {
				
			  if(this.getViewFrame().getModel().getDirection().equals("nothing") && levelCamera[j][i].equals("Hero")) {
				  img = hero.loadImage(1);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
		    }
		
		public void printHeroRight(Graphics graphics, int i, int j, String[][] levelCamera) {
			
			 if(this.getViewFrame().getModel().getDirection().equals("right") && levelCamera[j][i].equals("Hero") &&  this.getViewFrame().getModel().isHeroright()) {
				  img = hero.loadImage(2);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
			 if(this.getViewFrame().getModel().getDirection().equals("right") && levelCamera[j][i].equals("Hero") && !this.getViewFrame().getModel().isHeroright()) {
				  img = hero.loadImage(6);
				  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
			    }
		}
			 
			 public void printHeroLeft(Graphics graphics, int i, int j, String[][] levelCamera) {

				 if(this.getViewFrame().getModel().getDirection().equals("left") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroleft()) {
					  img = hero.loadImage(3);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				 
				 if(this.getViewFrame().getModel().getDirection().equals("left") && levelCamera[j][i].equals("Hero") && !this.getViewFrame().getModel().isHeroleft()) {
					  img = hero.loadImage(7);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
			 }
			 
			 public void printHeroDown(Graphics graphics, int i, int j, String[][] levelCamera) {

				 if(this.getViewFrame().getModel().getDirection().equals("down") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHerodown()) {
					  img = hero.loadImage(4);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				 
				 if(this.getViewFrame().getModel().getDirection().equals("down") && levelCamera[j][i].equals("Hero") && !this.getViewFrame().getModel().isHerodown()) {
					  img = hero.loadImage(8);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
			 }
			 
			 public void printHeroUp(Graphics graphics, int i, int j, String[][] levelCamera) {

				 if(this.getViewFrame().getModel().getDirection().equals("up") && levelCamera[j][i].equals("Hero") && this.getViewFrame().getModel().isHeroup()) {
					  img = hero.loadImage(5);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
				 
				 if(this.getViewFrame().getModel().getDirection().equals("up") && levelCamera[j][i].equals("Hero") && !this.getViewFrame().getModel().isHeroup()) {
					  img = hero.loadImage(9);
					  graphics.drawImage(img, j * dimensionX, i * dimensionY, dimensionX, dimensionY, this);
				    }
			 }
		 
		 public void printBorderBlock1(Graphics graphics, int i, int j) {
			  this.setImg(BorderBlock.getImg());
		      graphics.drawImage(this.getImg(), j * this.getDimensionX(), i * this.getDimensionY(), this.getDimensionX(), this.getDimensionY(), this);
		 }
		 
		 public void printBorderBlock2(Graphics graphics, int i, int j) {
			  this.setImg(BorderBlock.getImg2());
		      graphics.drawImage(this.getImg(), j * this.getDimensionX(), i * this.getDimensionY(), this.getDimensionX(), this.getDimensionY(), this);
		 }
		 
		 public void printBorderBlock3(Graphics graphics, int i, int j) {
			  this.setImg(BorderBlock.getImg3());
		      graphics.drawImage(this.getImg(), j * this.getDimensionX(), i * this.getDimensionY(), this.getDimensionX(), this.getDimensionY(), this);
		 }
		 
		 public void printBorderBlock4(Graphics graphics, int i, int j) {
			  this.setImg(BorderBlock.getImg4());
		      graphics.drawImage(this.getImg(), j * this.getDimensionX(), i * this.getDimensionY(), this.getDimensionX(), this.getDimensionY(), this);
		 }
}