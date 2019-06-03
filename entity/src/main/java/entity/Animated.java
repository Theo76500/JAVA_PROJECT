package entity;

import java.awt.image.BufferedImage;

public abstract class Animated extends Entity{

	public Animated(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public Animated() {
		this("", true, 0, 0);
	}
	
	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}
	
	public abstract BufferedImage loadImage(int levelNumber);

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
