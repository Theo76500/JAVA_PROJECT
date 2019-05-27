package entity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Timer extends Inanimated{

	public Timer(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "Timer";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
	}
	
	public Timer() {
		this("Timer", false, 0, 0);
	}
	
	@Override
	public Image loadImage(int levelNumber) {
		try {
			Image imgSasukeNormal = null;
			
			switch(levelNumber) {
			case 1 :
			    imgSasukeNormal = ImageIO.read(new File(""));
				break;
			
			case 2 :
				imgSasukeNormal = ImageIO.read(new File(""));
				break;
				
			case 3 :
				imgSasukeNormal = ImageIO.read(new File(""));
				break;
			
			case 4 :
				imgSasukeNormal = ImageIO.read(new File(""));
				break;
				
			case 5 :
				imgSasukeNormal = ImageIO.read(new File(""));
				break;
			
			default :
				break;
		}
			return imgSasukeNormal;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public Image loadImage(int levelNumber, String fileName) {
		// TODO Auto-generated method stub
		
		try {
			Image imgSasukeNormal = null;
			
			switch(levelNumber) {
			case 1 :
			    imgSasukeNormal = ImageIO.read(new File(fileName));
				break;
			
			case 2 :
				imgSasukeNormal = ImageIO.read(new File(fileName));
				break;
				
			case 3 :
				imgSasukeNormal = ImageIO.read(new File(fileName));
				break;
			
			case 4 :
				imgSasukeNormal = ImageIO.read(new File(fileName));
				break;
				
			case 5 :
				imgSasukeNormal = ImageIO.read(new File(fileName));
				break;
			
			default :
				break;
		}
			return imgSasukeNormal;
		} catch (IOException e) {
			e.printStackTrace();
		}
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
