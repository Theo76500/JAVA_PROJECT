package entity;

import java.awt.Image;

/**
 * 
 * @author PAIN Valentin
 *
 */

public abstract class Inanimated extends Entity{

	public Inanimated(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public Inanimated() {
		this("", false, 0, 0);
	}
	
	public abstract Image loadImage(int levelNumber);
	public abstract Image loadImage(int levelNumber, String fileName);
	
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
