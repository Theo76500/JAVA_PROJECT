package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * the class GameWin
 * @author LANGLOIS Theo
 */
	public class GameWin extends Inanimated{

		/**
		 * The image
		 */
		public static BufferedImage img;
		/**
		 * The GameState
		 */
		public static boolean gameState;
		
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
		 * @param gameState
		 * The Gamestate
		 */
		public GameWin(String stringCode, boolean move, int coordX, int coordY) {
			this.stringCode = "GameWin";
			this.move = false;
			this.coordX = 0;
			this.coordY = 0;
			GameWin.img = this.loadImage(1);
			GameWin.gameState = false;
		}
		
		/**
		 * 
		 * @throws IOException
		 * IOException
		 */
		public GameWin() throws IOException {
			this("GameWin", true, 0, 0);
		}

		/**
		 * @param levelNumber
		 * the level
		 */
		@Override
		public BufferedImage loadImage(int levelNumber) {
			
			BufferedImage img = null;
			    
			    try {
			    	img = ImageIO.read(new File("Sprites\\gamewin.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
			return img;
		}

}
