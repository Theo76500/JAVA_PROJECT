package entity;

import java.awt.image.BufferedImage;

/**
 * The Class Entity.
 *
 * @author Valentin Pain
 */
public abstract class Entity {
	
	protected String stringCode;
	protected boolean move;
	protected int coordX;
	protected int coordY;
	
	public Entity(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public Entity() {
		this("", false, 0, 0);
	}
	
	public abstract BufferedImage loadImage(int levelNumber);
	
	public String getStringCode() {
		return stringCode;
	}

	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public boolean getMove() {
		
		return this.move;
	}
	
	public void setMove(boolean move) {
		
		this.move = move;
	}
}
