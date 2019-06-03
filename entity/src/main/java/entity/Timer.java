package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Timer Class
 * @author LANGLOIS Theo
 */
public class Timer extends Inanimated{

	/**
	 * The image
	 */
	public static BufferedImage img;
	/**
	 * The timer state
	 */
	public static boolean timerOn;
	
	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * the move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 * @param timerOn
	 * The timer state
	 */
	public Timer(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		Timer.img = this.loadImage(1);
		Timer.timerOn = true;
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public Timer() throws IOException {
		this("Timer", true, 0, 0);
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
		    	img = ImageIO.read(new File("Sprites\\timer.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}

	/**
	 * Stes the string code
	 * @param stringCode
	 * The string code
	 */
	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}

	/**
	 * Gets the coordX
	 * @return coordX
	 */
	public int getCoordX() {
		return coordX;
	}

	/**
	 * Sets the CoordX
	 * @param coordX
	 * The coordX
	 */
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	/**
	 * Gets the coordY
	 * @return coordY
	 */

	public int getCoordY() {
		return coordY;
	}

	/**
	 * Sets the coordY
	 * @param coordY
	 * The coordY
	 */
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}
	
}
