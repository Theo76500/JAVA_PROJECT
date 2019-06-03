package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * The class Hero
 * @author PAIN Valentin
 */
public class Hero extends Animated{

	/**
	 * The class Hero
	 * @author PAIN Valentin
	 */
	/**
	 * The heroSprite
	 */
	public static ArrayList<BufferedImage> heroSprites = new ArrayList<BufferedImage>();
	
	/**
	 * Sets the string code
	 * @param stringCode
	 * The string code
	 */
	public void setStringCode(String stringCode) {this.stringCode = stringCode;}
	/**
	 * Gets the coordX
	 * @return coordX
	 */
	public int getCoordX() {return coordX;}
	/**
	 * Sets the coordX
	 * @param coordX
	 * The coordX
	 */
	public void setCoordX(int coordX) {this.coordX = coordX;}
	/**
	 * The coordY
	 * @return coordY
	 */
	public int getCoordY() {return coordY;}
	/**
	 * Sets the coordY
	 * @param coordY
	 * The coordY
	 */
	public void setCoordY(int coordY) {this.coordY = coordY;}
	/**
	 * Gets the move
	 * @return move
	 */
	public boolean getMove() {return this.move;}
	/**
	 * Sets the move
	 * @param move
	 * the move
	 */
	public void setMove(boolean move) {this.move = move;}
	
	
	/**
	 * The method that put the Hero
	 * @param stringCode
	 * The string code
	 * @param move
	 * The move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 */
	public Hero(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Hero";
		this.move = true;
		this.coordX = 7;
		this.coordY = 7;
		Hero.heroSprites.add(this.loadImage(1));
		Hero.heroSprites.add(this.loadImage(2));
		Hero.heroSprites.add(this.loadImage(3));
		Hero.heroSprites.add(this.loadImage(4));
		Hero.heroSprites.add(this.loadImage(5));
		Hero.heroSprites.add(this.loadImage(6));
		Hero.heroSprites.add(this.loadImage(7));
		Hero.heroSprites.add(this.loadImage(8));
		Hero.heroSprites.add(this.loadImage(9));
	}
	
	/**
	 * Hero
	 */
	public Hero() {
		this("Hero", true, 7, 7);
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return null
	 */
	@Override
	public BufferedImage loadImage(int levelNumber) {
		BufferedImage img = null;
		
		switch(levelNumber) {
		case 1 :
			try {
		    	img = ImageIO.read(new File("Sprites\\hero.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
		case 2 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroright1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 3 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroleft1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
		case 4 :
			try {
		    	img = ImageIO.read(new File("Sprites\\herodown1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 5 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroup1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 6 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroright2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 7 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroleft2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 8 :
			try {
		    	img = ImageIO.read(new File("Sprites\\herodown2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 9 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroup1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		default :
			break;
		}
		return img;
		
	}
}
