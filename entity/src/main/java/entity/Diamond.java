package entity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Diamond extends Animated{

	public static BufferedImage img;
	public static BufferedImage img2;
	
	public static BufferedImage getImg() {
		return img;
	}
	public static void setImg(BufferedImage img) { Diamond.img = img; }

	public static BufferedImage getImg2() {return img2;}
	public static void setImg2(BufferedImage img2) {Diamond.img2 = img2;}
	public Diamond(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Diamond";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public Diamond(String stringCode, boolean move, int coordX, int coordY, BufferedImage img, BufferedImage img2) {
		this.stringCode = "Diamond";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		Diamond.img = this.loadImage(1);
		Diamond.img2 = this.loadImage(2);
	}
	
	public Diamond() throws IOException {
		this("Diamond", true, 0, 0, ImageIO.read(new File("main\\Sprites\\diamond.png")), ImageIO.read(new File("main\\Sprites\\diamond2.png")));
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
				try {
			    	img = ImageIO.read(new File("main\\Sprites\\diamond.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2 :
				img = ImageIO.read(new File("main\\Sprites\\diamond2.png"));
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
	
	@Override
	public BufferedImage loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		
		try {
			BufferedImage img = null;
			
			switch(levelNumber) {
			case 1 :
			    img = ImageIO.read(new File(fileName));
				break;
			
			case 2 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 3 :
				img = ImageIO.read(new File(fileName));
				break;
			
			case 4 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 5 :
				img = ImageIO.read(new File(fileName));
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
	
	@Override
	public BufferedImage loadImage(String direction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setStringCode(String stringCode) {
		this.stringCode = stringCode;
	}

	public int getCoordX() {
		return coordX;
	}

	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	public boolean getMove() {
		
		return this.move;
	}
	
	public void setMove(boolean move) {
		
		this.move = move;
	}

}
