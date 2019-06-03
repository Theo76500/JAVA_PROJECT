package entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The class BorderBlock
 * @author PAIN Valentin
 */
public class BorderBlock extends Inanimated{

	/**
	 * The image
	 */
	private static BufferedImage img;
	/**
	 * The image 2
	 */
	private static BufferedImage img2;
	/**
	 * The image 3
	 */
	private static BufferedImage img3;
	/**
	 * The image 4 
	 */
	private static BufferedImage img4;
	/**
	 * The image 5
	 */
	private static BufferedImage img5;
	
	
	public void setStringCode(String stringCode) {this.stringCode = stringCode;}
	public int getCoordX() {return coordX;}
	public void setCoordX(int coordX) {this.coordX = coordX;}
	public int getCoordY() {return coordY;}
	public void setCoordY(int coordY) {this.coordY = coordY;}
	public boolean getMove() {return this.move;}
	public void setMove(boolean move) {this.move = move;}
	
	public static BufferedImage getImg3() {return img3;}
	public static void setImg3(BufferedImage img3) {BorderBlock.img3 = img3;}
	public static BufferedImage getImg4() {return img4;}
	public static void setImg4(BufferedImage img4) {BorderBlock.img4 = img4;}
	public static BufferedImage getImg5() {return img5;}
	public static void setImg5(BufferedImage img5) {BorderBlock.img5 = img5;}
	public static BufferedImage getImg2() {return img2;}
	public static void setImg2(BufferedImage img2) {BorderBlock.img2 = img2;}
	/**
	 * Gets the image
	 * @return img
	 */
	public static BufferedImage getImg() {return img;}
	
	/**
	 * Sets the image
	 * @param img
	 * The image
	 */
	public static void setImg(BufferedImage img) {BorderBlock.img = img;}
	
	/**
	 * The method that put the prite
	 * @param stringCode
	 * The string code
	 * @param move
	 * The boolean move
	 * @param coordX
	 * The coordX
	 * @param coordY
	 * The coordY
	 */
	public BorderBlock(String stringCode, boolean move, int coordX, int coordY) {
		this.stringCode = "BorderBlock";
		this.move = true;
		this.coordX = 0;
		this.coordY = 0;
		BorderBlock.img = this.loadImage(1);
		BorderBlock.img2 = this.loadImage(2);
		BorderBlock.img3 = this.loadImage(3);
		BorderBlock.img4 = this.loadImage(4);
		BorderBlock.img5 = this.loadImage(4);
	}
	
	/**
	 *
	 * @throws IOException
	 * IOException
	 */
	public BorderBlock() throws IOException {
		this("BorderBlock", true, 0, 0);
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
		
		switch(levelNumber) {
		case 1 :
		    
		    try {
		    	img = ImageIO.read(new File("Sprites\\borderblock1.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		
		case 2 :
			 try {
				 img = ImageIO.read(new File("Sprites\\borderblock2.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
			
		case 3 :
			 try {
				 img = ImageIO.read(new File("Sprites\\borderblock3.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
		
		case 4 :
			 try {
				 img = ImageIO.read(new File("Sprites\\borderblock4.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			break;
		
		default :
			break;
		}
		return img;
	}
}
