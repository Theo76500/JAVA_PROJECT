package entity;

import java.awt.image.BufferedImage;
 

/**
 * The class Animated
 * @author PAIN Valentin
 */
public abstract class Animated extends Entity{

	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * The boolean move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 */
	public Animated(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	/**
	 * Animated
	 */
	public Animated() {
		this("", true, 0, 0);
	}
	
	/**
	 * Sets the string code
	 * @param stringCode
	 * The string code
	 */
	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 */
	public abstract BufferedImage loadImage(int levelNumber);

	/**
	 * Gets the CoordX
	 * @return coordX
	 */
	public int getCoordX() {
		return coordX;
	}

	/**
	 * Sets the coordX
	 * @param coordX
	 * The coordX
	 */

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	/**
	 * Gets the coordY
	 * @return coordY
	 */
	public int getCoordY() {
		return coordY;
	}

	/**
	 * Sets the coordY
	 * @param coordY
	 * The coord Y
	 */
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	/**
	 * Gets the move
	 * @return move
	 */
	public boolean getMove() {
		
		return this.move;
	}
	
	/**
	 * Sets the move
	 * @param move
	 * the move
	 */
	public void setMove(boolean move) {
		
		this.move = move;
	}
}
