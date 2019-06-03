package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Boulder extends Animated{

	private static BufferedImage img;
	
	public static BufferedImage getImg() {
		return img;
	}

	public static void setImg(BufferedImage img) {
		Boulder.img = img;
	}
	
	public Boulder(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Boulder";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		Boulder.img = this.loadImage(1);
	}
	
	public Boulder() throws IOException {
		this("Boulder", true, 0, 0);
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("Sprites\\boulder.png"));
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
