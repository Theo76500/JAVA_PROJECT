package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author PAIN Valentin, LANGLOIS Theo
 */
public class Diamond extends Animated{

	/**
	 * The image 1
	 */
	public static BufferedImage img;
	
	/**
	 * The image 2
	 */
	public static BufferedImage img2;
	
	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * The boolean move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 */
	public Diamond(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Diamond";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		Diamond.img = this.loadImage(1);
		Diamond.img2 = this.loadImage(2);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOExceptiopn
	 */
	public Diamond() throws IOException {
		this("Diamond", true, 0, 0);
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
