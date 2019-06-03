package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Diamond extends Animated{

	public static BufferedImage img;
	public static BufferedImage img2;
	
	public Diamond(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Diamond";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		Diamond.img = this.loadImage(1);
		Diamond.img2 = this.loadImage(2);
	}
	
	public Diamond() throws IOException {
		this("Diamond", true, 0, 0);
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("Sprites\\diamond.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2 :
				img = ImageIO.read(new File("Sprites\\diamond2.png"));
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
