package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Hero;
import entity.Level;
import entity.RowLevel;
import entity.Score;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The levels. */
	private Level level;
	
	private Level level1;
	private Level level2;
	private Level level3;
	private Level level4;
	private Level level5;
	private int score=0;
	
	/** The character */
	private Hero hero = new Hero();


	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.level = new Level();
		
		this.level1 = new Level();
		this.level2 = new Level();
		this.level3 = new Level();
		this.level4 = new Level();
		this.level5 = new Level();
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
	
	public Level getLevel1() {
		return this.level1;
	}


	/**
     * Sets the first level.
     *
     * @param level1
     *            the new first level.
     */
	public void setLevel1(final RowLevel level) {
		this.level1 = level1;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/**
     * Gets the second level.
     *
     * @return the second level.
     */
	public Level getLevel2() {
		return this.level2;
	}
	
	
	/**
     * Sets the second level.
     *
     * @param level2
     *            the new second level.
     */
	public void setLevel2(final Level level2) {
		this.level2 = level2;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/**
     * Gets the third level.
     *
     * @return the third level.
     */
	public Level getLevel3() {
		return this.level3;
	}
	
	
	/**
     * Sets the third level.
     *
     * @param level3
     *            the new third level.
     */
	public void setLevel3(final Level level3) {
		this.level3 = level3;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/**
     * Gets the fourth level.
     *
     * @return the fourth level.
     */
	public Level getLevel4() {
		return this.level4;
	}
	
	
	/**
     * Sets the fourth level.
     *
     * @param level4
     *            the new fourth level.
     */
	public void setLevel4(final Level level4) {
		this.level4 = level4;
		this.setChanged();
		this.notifyObservers();
	}
	
	
	/**
     * Gets the fifth level.
     *
     * @return the fifth level.
     */
	public Level getLevel5() {
		return this.level5;
	}
	
	/**
     * Sets the fifth level.
     *
     * @param level5
     *            the new fifth level.
     */
	public void setLevel5(final Level level5) {
		this.level5 = level5;
		this.setChanged();
		this.notifyObservers();
	}
	
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
	
	public void setScore(int score) {
		score = this.score;
	}
	
	public int getScore() {
		return this.score;
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
		
		int i = 0; //X
		int j = 0; //Y
		 
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  for(String str : subTab)
		  {     
			 
			//Interaction rocher qui tombe
		    if(levelTab[i][j] != null && levelTab[i][j].equals("Boulder") && levelTab[i][j-1].equals("DirtAfterHero")) {
		    	
		    	levelTab[i][j] = "DirtAfterHero";
		    	levelTab[i][j-1] = "Boulder";
		    	
		    	//Si il y a un rocher qui tombes sur un joueur
		    	if(levelTab[i][j] != null && levelTab[i][j+1].equals("Boulder") && levelTab[i][j-1].equals("Hero")) {
		    		levelTab[i][j+2] = "Boulder";
		    		System.out.println("T MORT LOL");
		    	}
		    	
		    }
		    
		    //si un joueur passe sur un diamand. 
		    if(levelTab[i][j] != null && levelTab[i][j].equals("Diamond") && levelTab[i][j].equals("Hero")) {
		    	levelTab[i][j]="DirtAfterHero";
		    	setScore(getScore() + 1);
		    }
		    
		    if(levelTab[i][j] != null && levelTab[i][j].equals("BorderBlock") && levelTab[i][j].equals("Hero")) {
		    	//recuperer les dernieres coordonnées et le replacer a ses coo sans actualiser la fenetre
		    }
		    
		    //remplacement de dirt par la terre noire
		    if(levelTab[i][j] != null && levelTab[i][j].equals("Dirt") && levelTab[i][j].equals("Hero")) {
		    	levelTab[i][j]="DirtAfterHero";
		    }
		    
		    i++;
		  }
		  j++;
		}
		
		return levelTab;
	}
}
