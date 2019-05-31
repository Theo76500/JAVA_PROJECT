package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Hero extends Animated{

	public static ArrayList<BufferedImage> heroSprites = new ArrayList<BufferedImage>();
	
	public Hero(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Hero";
		this.move = true;
		this.coordX = 7;
		this.coordY = 7;
	}
	
	public Hero(String stringCode, boolean move, int coordX, int coordY, BufferedImage heroNothing, BufferedImage heroRight, BufferedImage heroleft, BufferedImage herodown, BufferedImage heroup) {
		this.stringCode = "Hero";
		this.move = true;
		this.coordX = 7;
		this.coordY = 7;
		Hero.heroSprites.add(this.loadImage(1));
		Hero.heroSprites.add(this.loadImage(2));
		Hero.heroSprites.add(this.loadImage(3));
		Hero.heroSprites.add(this.loadImage(4));
		Hero.heroSprites.add(this.loadImage(5));
	}
	
	public Hero() {
		this("Hero", true, 7, 7);
	}
	
	@Override
	public BufferedImage loadImage(int levelNumber) {
		BufferedImage img = null;
		
		switch(levelNumber) {
		case 1 :
			try {
		    	img = ImageIO.read(new File("Sprites\\hero.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
		case 2 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroright1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 3 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroleft1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
		case 4 :
			try {
		    	img = ImageIO.read(new File("Sprites\\herodown1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
			
		case 5 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroup1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		/*case 6 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroright2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 7 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroleft2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 8 :
			try {
		    	img = ImageIO.read(new File("Sprites\\herodown2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		case 9 :
			try {
		    	img = ImageIO.read(new File("Sprites\\heroup1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		
		default :
			break;
}
		return img;
		
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
				img= ImageIO.read(new File(fileName));
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
			
			case 6 :
				img = ImageIO.read(new File(fileName));
				break;
			
			case 7 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 8 :
				img = ImageIO.read(new File(fileName));
				break;
			
			case 9 :
				img = ImageIO.read(new File(fileName));
				break;
				
			case 10 :
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
