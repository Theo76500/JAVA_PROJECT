package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class DirtAfterHero
 * @author PAIN Valentin
 */
public class DirtAfterHero extends Inanimated{

	/**
	 * The image
	 */
	private static BufferedImage img;
	
	/**
	 * Sets the string code
	 * @param stringCode
	 * The code
	 */
	public void setStringCode(String stringCode) {this.stringCode = stringCode;}
	/**
	 * Gets the coordX
	 * @return coordX
	 */
	public int getCoordX() {return coordX;}
	/** Sets the coordX
	 *
	 * @param coordX
	 * The coordX
	 */
	public void setCoordX(int coordX) {this.coordX = coordX;}
	/**
	 * Gets the coordY
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
	 * Gets the image
	 * @return img
	 */
	public static BufferedImage getImg() {return img;}
	/**
	 * Sets the image
	 * @param img
	 * The image
	 */
	public static void setImg(BufferedImage img) {DirtAfterHero.img = img;}
	
	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * The move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 */
	public DirtAfterHero(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "DirtAfterHero";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		DirtAfterHero.img = this.loadImage(1);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public DirtAfterHero() throws IOException {
		this("DirtAfterHero", true, 0, 0);
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return null
	 */
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("Sprites\\dirtafterhero.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2 :
				img = ImageIO.read(new File(""));
				break;
				
			case 3 :
				img = ImageIO.read(new File(""));
				break;
			
			case 4 :
				img = ImageIO.read(new File(""));
				break;
				
			case 5 :
				img = ImageIO.read(new File(""));
				break;
			
			default :
				break;
		}
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
