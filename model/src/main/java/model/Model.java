package model;

import contract.IModel;
import entity.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	private String[][] levelTab = new String[20][20];
	private String direction;
	private static int finalScore;
	private static int finalTime;
	private boolean gameWin = false;
	private boolean gameOver = false;
	private static int score = 0;
	private static int diamond = 10;
	private static int timeLeft;
	private static boolean diamondSprite;
	private static boolean enemySprite;
	
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
	
	public int getTimeLeft(){
		return timeLeft;
	}
	
	public void setTimeLeft(int timeLeft){
		Model.timeLeft = timeLeft;
	}
	
	public boolean getGameWin() {
		return gameWin;
	}
	
	public void setGameWin(boolean gameWin) {
		this.gameWin= gameWin;
	}

	public int getFinalScore(){
		return finalScore;
	}

	public void setFinalScore(int finalScore){
		Model.finalScore = finalScore;
	}

	public int getFinalTime(){
		return finalTime;
	}

	public void setFinalTime(int finalTime){
		Model.finalTime = finalTime;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		Model.score = score;
	}

	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		Model.diamond = diamond;
	}
	
	public boolean isDiamondSprite() {return diamondSprite;}

	public boolean isEnemySprite() {return enemySprite;}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(int lvl) {
		diamond = 10;
		timeLeft = 360;
		switch (lvl){
			case 1:
				try {
					final DAOLevel1 daoLevel1 = new DAOLevel1(DBConnection.getInstance().getConnection());
					this.setLevel(daoLevel1.find());
				} catch (final SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					final DAOLevel2 daoLevel2 = new DAOLevel2(DBConnection.getInstance().getConnection());
					this.setLevel(daoLevel2.find());
				} catch (final SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					final DAOLevel3 daoLevel3 = new DAOLevel3(DBConnection.getInstance().getConnection());
					this.setLevel(daoLevel3.find());
				} catch (final SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					final DAOLevel4 daoLevel4 = new DAOLevel4(DBConnection.getInstance().getConnection());
					this.setLevel(daoLevel4.find());
				} catch (final SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					final DAOLevel5 daoLevel5 = new DAOLevel5(DBConnection.getInstance().getConnection());
					this.setLevel(daoLevel5.find());
				} catch (final SQLException e) {
					e.printStackTrace();
				}
				break;
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
		 
		for(String[] subTab : levelTab)
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

					  if (this.getDiamond() != 0) {
						  setDiamond(getDiamond() - 1);
						  setScore(getScore() + 15);
					  }

					  else if (getDiamond() == 0)
					  {
						  setScore(getScore() + 30);
					  }
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
			    
			  //Falling boulder
				  if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("DirtAfterHero")) {
					  //If the boulder is above the hero
					  if(levelTab[j][i].equals("Boulder") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+1)) {}
					  else {
						  levelTab[j][i] = "DirtAfterHero";
						  levelTab[j][i+1] = "Boulder";
						  
						  if(levelTab[j][i+1].equals("Boulder") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+2)) {
						  		GameOver();
						  }
					  }
				  }

			    if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("Enemy")){
					this.GameOver();
				}

			    if (levelTab[j][i] != null && getTimeLeft() == 1){
					this.GameOver();
				}

				  if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("ExitDoor") && getDiamond() == 0){
					  this.GameWin();
				  }
		     
		    i++;
		  }
		  j++;
		}
		
		return levelTab;
	}
	
	public String[][] levelCamera(String[][] levelTab) {
		
		int frameMaxX = 16;
		int frameMaxY = 16;
		int frameMaxX2 = frameMaxX - 1;
		int frameMaxY2 = frameMaxY - 1;
		
		String[][] levelTabCamera = new String[frameMaxX][frameMaxY];
	
		if(this.getCoordXHero() + 6 > frameMaxX) {
			
			for(int i = 0; i < frameMaxX; i++) {
				for(int j = 0; j < frameMaxX; j++) {
					
					
					levelTabCamera[j][i] = levelTab[j + 1][i];
					}
				}
			}
		
		else {
			for(int i = 0; i < frameMaxX; i++) {
				for(int j = 0; j < frameMaxX; j++) {
			levelTabCamera[j][i] = levelTab[j][i];
			
		}
			}
		}
		
		/*int i = 0;
		int j = 0;
		
		for(String sousTab[] : levelTabCamera)
		{
		  i = 0;
		  for(String str : sousTab)
		  {     
		    System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " + levelTabCamera[j][i]);
		    i++;
		  }
		  j++;
		}*/
		  return levelTabCamera;
}
			  
			 
			 /*if(i < (this.getCoordYHero() - 6)) {
				 
				 //On enlève une colonne / une ligne en décalant les indices
				 //on en affiche une autre
			 }
			 
			 if(j > (this.getCoordXHero() + 6)) {
				 
				 //On enlève une colonne / une ligne en décalant les indices
				 //on en affiche une autre
			 }
			 
			 if((j < this.getCoordXHero() - 6)) {
				 
				 //On enlève une colonne / une ligne en décalant les indices
				 //on en affiche une autre
			 }
			  
			 else { 
				 levelTabCamera[j][i] = levelTab[j][i];
			  }
			 i++;
		    }
		  j++;
		  }
		
		  return levelTabCamera;
	}*/
	
	  
	
	public void setCharacterCoords(int coordX, int coordY) {
		
		this.setCoordXHero(coordX);
		this.setCoordYHero(coordY);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public boolean checkCollision(int coordX, int coordY) {

		String[][] levelTab = this.getLevelTab();

		return !levelTab[coordX][coordY].equals("Boulder") && !levelTab[coordX][coordY].equals("BorderBlock");

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
		
		try {
			Entity gamewin = new GameWin();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity gameover = new GameOver();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity timer = new Timer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity score = new Score();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Entity diamondsleft = new DiamondsLeft();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Timer(){

			for(timeLeft = 360; Timer.timerOn && timeLeft > 0; timeLeft--){
				diamondSprite = !diamondSprite;
				enemySprite = !enemySprite;
				this.setChanged();
				this.notifyObservers();

				try {
					Thread.sleep (333);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}


	public void GameOver(){
		GameOver.gameState = true;
		Timer.timerOn = false;
		timeLeft = 1;
	}
	
	
	public void GameWin(){
		GameWin.gameState = true;
		Timer.timerOn = false;
		finalScore = getScore() + getTimeLeft();
		finalTime = 0;
	}
	
}
