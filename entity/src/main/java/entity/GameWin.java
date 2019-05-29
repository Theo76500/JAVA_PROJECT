package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

	public class GameWin extends Inanimated{

		private static BufferedImage img;
		private static boolean gameState;
		
		public static BufferedImage getImg() {
			return img;
		}

		public static void setImg(BufferedImage img) {
			GameWin.img = img;
		}
		
		public GameWin(String stringCode, boolean move, int coordX, int coordY, boolean gameState) {
			this.stringCode = "";
			this.move = false;
			this.coordX = 0;
			this.coordY = 0;
			GameWin.setGameState(false);
		}
		
		public static boolean isGameState() {
			return gameState;
		}

		public static void setGameState(boolean gameState) {
			GameWin.gameState = gameState;
		}

		public GameWin(String stringCode, boolean move, int coordX, int coordY, BufferedImage img, boolean gameState) {
			this.stringCode = "";
			this.move = false;
			this.coordX = 0;
			this.coordY = 0;
			GameWin.img = this.loadImage(1);
			GameWin.setGameState(false);
		}
		
		public GameWin() throws IOException {
			this("GameWin", true, 0, 0, ImageIO.read(new File("C:\\Users\\Perso Pierre\\Desktop\\Sprites\\gamewin.png")), false);
		}

		@Override
		public BufferedImage loadImage(int levelNumber) {
			
			BufferedImage img = null;
			    
			    try {
			    	img = ImageIO.read(new File("C:\\Users\\Perso Pierre\\Desktop\\Sprites\\gamewin.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			    
			return img;
		}

	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BufferedImage loadImage(String direction) {
		// TODO Auto-generated method stub
		return null;
	}

}
