package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Timer extends Inanimated{

	public static BufferedImage img;
	public static boolean timerOn;

	public Timer(String stringCode, boolean move, int coordX, int coordY, boolean timerOn) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		Timer.timerOn = true;
	}
	
	public Timer(String stringCode, boolean move, int coordX, int coordY, BufferedImage img, boolean gameState) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		Timer.img = this.loadImage(1);
		Timer.timerOn = true;
	}
	
	public Timer() throws IOException {
		this("Timer", true, 0, 0, ImageIO.read(new File("main\\Sprites\\timer.png")), true);
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("main\\Sprites\\timer.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}
	
	@Override
	public BufferedImage loadImage(String direction) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
