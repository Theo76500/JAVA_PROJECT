package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IElement;
import contract.IEntity;
import contract.IHero;
import contract.ILevel;
import contract.IModel;

/**
* Class ViewPanel
*@author LANGLOIS Theo
*/

public class ViewPanel extends JPanel implements Observer {
	
	private IModel model;
	
	Font font;

	private int y;
	private int x;
	
	ViewPanel()
	{
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		ILevel level = this.model.getLevel();
		for (int y = 0; y < level.getSize().getHeight(); y++);
		{
			for (int x = 0; x < level.getSize().getWidth(); x++);
			{
				IElement element = level.getElement(x, y);
				if (element == null)
					{
						continue;
					}
				
				g.drawImage(model.getElement(x,y).getImage(), x*32, y*32, this);
			}
		}
		
		for(IEntity element : model.getLevel().getEntities())
		{
			g.drawImage(element.getImage(), element.getLocation().getX()*32, element.getLocation().getY()*32, null);
		}
		
		if (this.model.getLevel().getHero().isAlive())
		{
			IHero element = level.getHero();
			g.drawImage(element.getImage(), element.getLocation().getX() * 32, element.getLocation().getY() * 32, null);
		}
		
		font = new Font ("START", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.WHITE);
		
		g.drawString("PRESS R TO RETRY", 525, 415);
		
		if(!this.model.getLevel().getHero().isAlive())
		{
			g.drawString("GAME OVER", 525, 415);
		}
		
		if(this.model.getLevel().isFinished())
		{
			if(this.model.getLevelsId().get(this.model.getLevelsId().size()-1) == this.model.getLevel().getId()) {
				g.setColor(Color.YELLOW);
				g.drawString("Congratulations", this.getWidth()/2-90, this.getHeight()/2-64);
				g.drawString("You finished this level !", this.getWidth()/2-125, this.getHeight()/2-16);
			} else
				g.drawString("Loading next map ...", this.getWidth()/2-100, 414);
		}
		
		g.setColor(Color.YELLOW);
		
		g.drawString("Score : "+ model.getLevel().getHero().getScore().toString(), 20, 415);
	}
	
	public void update(Observable observable, Object o)
	{
		this.model = (IModel) observable;
		this.repaint();
	}
	
	
	
	
}