package entity;

import java.awt.image.BufferedImage;

/**
 * The Class Entity.
 *
 * @author Valentin Pain
 */
public abstract class Entity {
	
	/**
	 * The String Code
	 */
	protected String stringCode;
	/**
	 * The move
	 */
	protected boolean move;
	/**
	 * The coord X
	 */
	protected int coordX;
	/**
	 * The coord Y
	 */
	protected int coordY;
	
	/**
	 * Enitity constructor
	 * @param stringCode
	 * The string code
	 * @param move
	 * The move
	 * @param coordX
	 * The coord X
	 * @param coordY
	 * The coord Y
	 */
	public Entity(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	/**
	 * ENTITY
	 */
	public Entity() {
		this("", false, 0, 0);
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return null
	 */
	public abstract BufferedImage loadImage(int levelNumber);
	
	/**
	 * Gets the string code
	 * @return stringCode
	 */
	public String getStringCode() {
		return stringCode;
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
	 * Gets the coordX
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
	 * The coordY
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
	 * The move
	 */
	public void setMove(boolean move) {
		
		this.move = move;
	}
}
