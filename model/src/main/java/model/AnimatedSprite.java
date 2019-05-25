package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Change sprites to make an animation
 * @author LANGLOIS Theo
 *
 */

public class AnimatedSprite extends Sprite implements contract.IAnimatedSprite{

	private Image images[];
	
	
	/**
     * define the the current animation status
     */
    private int step;
    
    public AnimatedSprite(String defaultImage, String[] images) {
    	super(defaultImage);
    	this.images = new Image[images.length];
    	for(int i = 0; i<images.length; i++)
    	{
    		try {
    			this.images[i] = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(images[i]));
    				
    		} catch (IOException e) {
    			System.err.println("ERROR : Can't load " +images[i] );
    			e.printStackTrace();
    		}
    	}
    	this.step = 0;
    }
    
    /**
     * Initiate the next step of the animation
     */
    
    public void nextImage()
    {
    	this.step++;
    	if(this.step >= this.images.length){
    		this.step = 0;
    	}
    }
    
    @Override
    public Image getImage()
    {
    	return this.images[this.step];
    }
}
