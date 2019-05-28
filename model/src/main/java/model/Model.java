package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.BorderBlock;
import entity.Boulder;
import entity.Diamond;
import entity.Dirt;
import entity.DirtAfterHero;
import entity.Enemy;
import entity.Entity;
import entity.ExitDoor;
import entity.Hero;
import entity.Level;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private String[][] levelTab = new String[20][20];
	private String direction;
	
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	/** The levels. */
	private Level level;
	
	/** The character */
	private Hero hero = new Hero();


	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.level = new Level();
	}
	
	public String[][] getLevelTab() {
		return levelTab;
	}

	public void setLevelTab(String[][] levelTab) {
		this.levelTab = levelTab;
	}

	/**
     * Gets the first level.
     *
     * @return the first level.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}


	/**
     * Sets the first level.
     *
     * @param level1
     *            the new first level.
     */

	
	public int getCoordXHero() {
		return hero.getCoordX();
	}
	
	public void setCoordXHero(int coordX) {
		this.hero.setCoordX(coordX);
	}
	
	public int getCoordYHero() {
		return hero.getCoordY();
	}
	
	public void setCoordYHero(int coordY) {
		this.hero.setCoordY(coordY);
	}
	

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel() {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setLevel(daoHelloWorld.find());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public String[][] levelBehavior(String[][] levelTab) {
		
		int i = 0;
		int j = 0;
		 
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  for(String str : subTab)
		  {     
		    if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("DirtAfterHero")) {
		    	
		    	levelTab[j][i] = "DirtAfterHero";
		    	levelTab[j][i+1] = "Boulder";
		    }
		    
		    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && levelTab[j][i+1].equals("DirtAfterHero")) {
		    	
		    	levelTab[j][i] = "DirtAfterHero";
		    	levelTab[j][i+1] = "Diamond";
		    }
		    
		    if(levelTab[j][i] != null && levelTab[j][i].equals("Dirt") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)){
                levelTab[j][i] = "DirtAfterHero";
            }
		    
		    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)) {
                levelTab[j][i] = "DirtAfterHero";
            }
		     
		    i++;
		  }
		  j++;
		}
		
		return levelTab;
	}
	
	public void setCharacterCoords(int coordX, int coordY) {
		
		this.setCoordXHero(coordX);
		this.setCoordYHero(coordY);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean checkCollision(int coordX, int coordY) {
		
		String levelTab[][] = this.getLevelTab();
		
		if(levelTab[coordX][coordY].equals("Boulder") || levelTab[coordX][coordY].equals("BorderBlock")) {
			
			return false;
		}
			
			return true;
		
	}
	
	public void avoidLatency() {
		
		try {
			Entity borderBlock = new BorderBlock();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity boulder = new Boulder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity diamond = new Diamond();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity dirt = new Dirt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity dirtafterhero = new DirtAfterHero();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity enemy = new Enemy();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity exitdoor = new ExitDoor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
