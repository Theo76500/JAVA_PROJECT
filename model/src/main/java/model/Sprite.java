package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.ISprite;

/**
 * A sprite for the element in the level
 * @author LANGLOIS Theo
 *
 */

public class Sprite implements ISprite {

	/** The image of the sprite */
	protected Image image;
	
	public Sprite (String image)
	{
		try  {
			this.image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(image));
		
		} catch (IOException e) {
			System.err.println("ERROR : Impossible to load the image " + image);
			e.printStackTrace();
		}
	}
	
	public Sprite (Image image) 
	{
		this.image = image;
	}
	
	public Image getImage()
	{
		return image;
	}
	
}

