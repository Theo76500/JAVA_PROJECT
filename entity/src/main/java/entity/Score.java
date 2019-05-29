package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Score extends Inanimated{

	public static BufferedImage img;
	
	public Score(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Score";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}

	public Score(String stringCode, boolean move, int coordX, int coordY, BufferedImage img) {
		this.stringCode = "Score";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		Score.img = this.loadImage(1);
	}
	
	public Score() throws IOException {
		this("Score", true, 0, 0, ImageIO.read(new File("C:\\Users\\valen\\OneDrive\\Bureau\\Sprites\\score.png")));
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("C:\\Users\\valen\\OneDrive\\Bureau\\Sprites\\score.png"));
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

	public boolean getMove() {
		
		return this.move;
	}
	
	public void setMove(boolean move) {
		
		this.move = move;
	}

	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
}
