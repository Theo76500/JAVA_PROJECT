package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class DiamondLeft
 * @author PAIN Valentin
 */
public class DiamondsLeft extends Inanimated{

	/**
	 * The image
	 */
	public static BufferedImage img;
	
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
	public DiamondsLeft(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "DiamondsLeft";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		DiamondsLeft.img = this.loadImage(1);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public DiamondsLeft() throws IOException {
		this("DiamondsLeft", true, 0, 0);
	}

	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return null
	 */
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
}
