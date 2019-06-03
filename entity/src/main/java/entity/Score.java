package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The class Score
 * @author LANGLOIS Theo
 */
public class Score extends Inanimated{

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
	public Score(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Score";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		Score.img = this.loadImage(1);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public Score() throws IOException {
		this("Score", true, 0, 0);
	}

	/**
	 * The method that load the image
	 * @param levelNumber
	 * The level number
	 * @return
	 */
	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("Sprites\\score.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}

	/**
	 * Sets the string code
	 * @param stringCode
	 * The stirng code
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
	 * Sets the coordX
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

	/**
	 * Gets the move
	 * @return move
	 */
	public boolean getMove() {
		
		return this.move;
	}
	
	/**
	 * Sets the move
	 * @param move
	 * the move
	 */
	public void setMove(boolean move) {
		
		this.move = move;
	}

}
