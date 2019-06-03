package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class enemy
 * @author PAIN Valentin, LANGLOIS Theo
 */
public class Enemy extends Animated{

	/**
	 * The image 1
	 */
	private static BufferedImage img;
	/**
	 * The image 2
	 */
	public static BufferedImage img2;
	
	/**
	 * Gets the image
	 * @return img
	 */
	public static BufferedImage getImg() {
		return img;
	}

	/**
	 * Sets the image
	 * @param img
	 * the image
	 */
	public static void setImg(BufferedImage img) {
		Enemy.img = img;
	}
	
	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * The move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * the coordY
	 */
	public Enemy(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Enemy";
		this.move = true;
		this.coordX = 7;
		this.coordY = 14;
		Enemy.img = this.loadImage(1);
		Enemy.img2 = this.loadImage(2);
	}
	
	/**
	 * The method that put enemy
	 */
	public Enemy() {
		this("Enemy", true, 7, 14);
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * the level number
	 * @return null
	 */
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
