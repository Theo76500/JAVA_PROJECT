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

			  if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)) {
				  levelTab[j][i] = "DirtAfterHero";
				  setDiamond(getDiamond() - 1);
				  setScore(getScore() + 15);
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

		    if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("Enemy"))
			{
				GameOver();
			}

		    if (levelTab[j][i] != null && getTimeLeft() == 1)
			{
				GameOver();
			}

			  if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("ExitDoor"))
			  {
				  GameWin();
			  }

			  if(levelTab[j][i] != null && getDiamond()==9)
			  {
			  	GameWin();
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

	private int diamond =10;
	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}


	private boolean timerOn = true;
	private int timeLeft;
	public void Timer()
	{
		for(timeLeft=120; timerOn && timeLeft>0; timeLeft--)
		{

			this.setChanged();
			this.notifyObservers();
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


	public boolean gameOver = false;
	public void GameOver()
	{
		gameOver = true;
		timerOn = false;
	}
	public boolean getGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public int finalScore;
	public int finalTime;
	public boolean gameWin = false;
	public void GameWin()
	{
		gameWin = true;
		timerOn = false;
		finalScore = getScore() + getTimeLeft();
		finalTime = 0;

	}

	public boolean getGameWin() {
		return gameWin;
	}
	public void setGameWin(boolean gameWin) {
		this.gameWin= gameWin;
	}


	public int getFinalScore()
	{
		return finalScore;
	}

	public void setFinalScore(int finalScore)
	{
		this.finalScore = finalScore;
	}

	public int getFinalTime()
	{
		return finalTime;
	}

	public void setFinalTime(int finalTime)
	{
		this.finalTime = finalTime;
	}

	private int score = 0;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

