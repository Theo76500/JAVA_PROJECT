package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOver extends Inanimated{

	public static BufferedImage img;
	public static boolean gameState;
	
	public GameOver(String stringCode, boolean move, int coordX, int coordY, boolean gameState) {
		this.stringCode = "Game";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		GameOver.gameState = false;
	}
	
	public GameOver(String stringCode, boolean move, int coordX, int coordY, BufferedImage img, boolean gameState) {
		this.stringCode = "GameOver";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		GameOver.img = this.loadImage(1);
		GameOver.gameState = false;
	}
	
	public GameOver() throws IOException {
		this("GameOver", true, 0, 0, ImageIO.read(new File("C:\\Users\\valen\\OneDrive\\Bureau\\Sprites\\gameover.png")), false);
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("C:\\Users\\valen\\OneDrive\\Bureau\\Sprites\\gameover.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}

	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage loadImage(String direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
