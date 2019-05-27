package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Hero;
import entity.Level;
import entity.RowLevel;

/**
 * The Class Model.
 *
 * @author PAIN Valentin & LANGLOIS Theo & FORQUES Pierre & LALISSE Adrien
 */
public final class Model extends Observable implements IModel   {

	/** The levels. */
	private Level level;
	
	private Level level1;
	private Level level2;
	private Level level3;
	private Level level4;
	private Level level5;
	
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
			final DAOLevel1 daoHelloWorld = new DAOLevel1(DBConnection.getInstance().getConnection());
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

		    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)) {
		    	levelTab[j][i] = "DirtAfterHero";
		    	setDiamond(getDiamond() + 1);
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
	
	public void SetCharacterCoords(int coord) {
	}


	private int diamond =0;
	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}



	private int timeLeft;

	public void Timer()
	{

		for(timeLeft=120; timeLeft>0; timeLeft--)
		{
			try {
				Thread.sleep (1000);
			}
			catch (InterruptedException e) {
				System.out.print("Erreur");
			}
		}
	}

	public int getTimeLeft()
	{
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft)
	{
		this.timeLeft = timeLeft;
	}
}
