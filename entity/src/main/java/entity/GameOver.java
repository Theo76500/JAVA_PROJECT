package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class GameOver
 * @author LANGLOIS Theo
 */
public class GameOver extends Inanimated{

	/**
	 * The image
	 */
	public static BufferedImage img;
	/**
	 * The gameState
	 */
	public static boolean gameState;
	
	/**
	 * The method that put the sprite
	 * @param stringCode
	 * The string code
	 * @param move
	 * the move
	 * @param coordX
	 * the coordX
	 * @param coordY
	 * The coordY
	 * @param gameState
	 * The gameState
	 */
	public GameOver(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "GameOver";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		GameOver.img = this.loadImage(1);
		GameOver.gameState = false;
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public GameOver() throws IOException {
		this("GameOver", true, 0, 0);
	}

	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level Number
	 * @return null
	 */
	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("Sprites\\gameover.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}

}
