package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Animated{

	private static BufferedImage img;
	public static BufferedImage img2;
	
	public static BufferedImage getImg() {
		return img;
	}

	public static void setImg(BufferedImage img) {
		Enemy.img = img;
	}
	
	public Enemy(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Enemy";
		this.move = true;
		this.coordX = 7;
		this.coordY = 14;
		Enemy.img = this.loadImage(1);
		Enemy.img2 = this.loadImage(2);
	}
	
	public Enemy() {
		this("Enemy", true, 7, 14);
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("Sprites\\enemy.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2 :
				try {
					img = ImageIO.read(new File("Sprites\\enemy2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
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
