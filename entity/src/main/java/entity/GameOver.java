package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameOver extends Inanimated{

	private static BufferedImage img;
	private static boolean gameState;
	
	public static BufferedImage getImg() {
		return img;
	}

	public static void setImg(BufferedImage img) {
		GameOver.img = img;
	}
	
	public GameOver(String stringCode, boolean move, int coordX, int coordY, boolean gameState) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		GameOver.setGameState(false);
	}
	
	public GameOver(String stringCode, boolean move, int coordX, int coordY, BufferedImage img, boolean gameState) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		GameOver.img = this.loadImage(1);
		GameOver.setGameState(false);
	}
	
	public GameOver() throws IOException {
		this("GameOver", true, 0, 0, ImageIO.read(new File("C:\\Users\\Perso Pierre\\Desktop\\Sprites\\gameover.png")), false);
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("C:\\Users\\Perso Pierre\\Desktop\\Sprites\\gameover.png"));
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

	public static boolean isGameState() {
		return gameState;
	}

	public static void setGameState(boolean gameState) {
		GameOver.gameState = gameState;
	}

}
