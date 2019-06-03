package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class Boulder
 * @author PAIN Valentin
 */
public class Boulder extends Animated{

	/**
	 * The image
	 */
	private static BufferedImage img;
	
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
	 * The image
	 */
	public static void setImg(BufferedImage img) {
		Boulder.img = img;
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
	 * The coordY
	 */
	public Boulder(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Boulder";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		Boulder.img = this.loadImage(1);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public Boulder() throws IOException {
		this("Boulder", true, 0, 0);
	}
	
	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return null
	 */
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
