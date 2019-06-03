package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class ExitDoor
 * @author PAIN Valentin
 */
public class ExitDoor extends Inanimated{

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
		ExitDoor.img = img;
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
	public ExitDoor(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "ExitDoor";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		ExitDoor.img = this.loadImage(1);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOEXCEPTION
	 */
	public ExitDoor() throws IOException {
		this("ExitDoor", true, 0, 0);
	}
	
	/**
	 * the method that load the image
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
			    	img = ImageIO.read(new File("Sprites\\exitdoor.png"));
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
