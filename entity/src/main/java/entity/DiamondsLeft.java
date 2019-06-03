package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DiamondsLeft extends Inanimated{

	public static BufferedImage img;
	
	public DiamondsLeft(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "DiamondsLeft";
		this.move = false;
		this.coordX = 0;
		this.coordY = 0;
		DiamondsLeft.img = this.loadImage(1);
	}
	
	public DiamondsLeft() throws IOException {
		this("DiamondsLeft", true, 0, 0);
	}

	@Override
	public BufferedImage loadImage(int levelNumber) {
		
		BufferedImage img = null;
		    
		    try {
		    	img = ImageIO.read(new File("Sprites\\diamondsleft.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		return img;
	}
}
