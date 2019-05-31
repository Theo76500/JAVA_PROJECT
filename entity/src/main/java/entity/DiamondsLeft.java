package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DiamondsLeft extends Inanimated{

	public static BufferedImage img;
	
	public DiamondsLeft(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "DiamondsLeft";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public DiamondsLeft(String stringCode, boolean move, int coordX, int coordY, BufferedImage img) {
		this.stringCode = "DiamondsLeft";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		DiamondsLeft.img = this.loadImage(1);
	}
	
	public DiamondsLeft() throws IOException {
		this("DiamondsLeft", true, 0, 0, ImageIO.read(new File("Sprites\\diamondsleft.png")));
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("Sprites\\diamondsleft.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
			    img = ImageIO.read(new File(fileName));
				break;
			
			case 2 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 3 :
				img = ImageIO.read(new File(fileName));
				break;
			
			case 4 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 5 :
				img = ImageIO.read(new File(fileName));
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

}
