package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DirtAfterHero extends Inanimated{

	private static BufferedImage img;
	
	public void setStringCode(String stringCode) {this.stringCode = stringCode;}
	public int getCoordX() {return coordX;}
	public void setCoordX(int coordX) {this.coordX = coordX;}
	public int getCoordY() {return coordY;}
	public void setCoordY(int coordY) {this.coordY = coordY;}
	public boolean getMove() {return this.move;}
	public void setMove(boolean move) {this.move = move;}
	public static BufferedImage getImg() {return img;}
	public static void setImg(BufferedImage img) {DirtAfterHero.img = img;}
	
	public DirtAfterHero(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "DirtAfterHero";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		DirtAfterHero.img = this.loadImage(1);
	}
	
	public DirtAfterHero() throws IOException {
		this("DirtAfterHero", true, 0, 0);
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("Sprites\\dirtafterhero.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2 :
				img = ImageIO.read(new File(""));
				break;
				
			case 3 :
				img = ImageIO.read(new File(""));
				break;
			
			case 4 :
				img = ImageIO.read(new File(""));
				break;
				
			case 5 :
				img = ImageIO.read(new File(""));
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
}
