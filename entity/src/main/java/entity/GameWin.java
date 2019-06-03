package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

	public class GameWin extends Inanimated{

		public static BufferedImage img;
		public static boolean gameState;
		
		public GameWin(String stringCode, boolean move, int coordX, int coordY) {
			this.stringCode = "GameWin";
			this.move = false;
			this.coordX = 0;
			this.coordY = 0;
			GameWin.img = this.loadImage(1);
			GameWin.gameState = false;
		}
		
		public GameWin() throws IOException {
			this("GameWin", true, 0, 0);
		}

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
