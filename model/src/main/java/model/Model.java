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
import entity.GameOver;
import entity.GameWin;
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
	public int finalScore;
	public int finalTime;
	public boolean gameWin = false;
	public boolean gameOver = false;
	private int score = 0;
	private int diamond = 10;
	private boolean timerOn = true;
	private int timeLeft;
	private boolean rocherDroite;
	private boolean rocherGauche;

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
	
	public int getTimeLeft(){
		return timeLeft;
	}
	
	public void setTimeLeft(int timeLeft){
		this.timeLeft = timeLeft;
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
		this.finalScore = finalScore;
	}

	public int getFinalTime(){
		return finalTime;
	}

	public void setFinalTime(int finalTime){
		this.finalTime = finalTime;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
		this.diamond = diamond;
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

				//Falling boulder
			  	if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("DirtAfterHero")) {
			    	
				    //Si la boule est juste au dessus du joueur
				    if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+1)) {}
				    else {
				    	levelTab[j][i] = "DirtAfterHero";
				    	levelTab[j][i+1] = "Boulder";
				    		if(levelTab[j][i] != null && levelTab[j][i+1].equals("Boulder") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+2)) {
						    	this.GameOver();
						    }				    		
				    }    	
			    }
			   
			    //Falling Boulder Mecanic
				   if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("Boulder")) {
					    
				    	//gauche
				    	if(levelTab[j-1][i].equals("DirtAfterHero") && levelTab[j-1][i+1].equals("DirtAfterHero")) {
					    	levelTab[j-1][i] = "Boulder";
					    	levelTab[j][i] = "DirtAfterHero";
				    	}
				    	else {
					    	//droite
					    	if(levelTab[j+1][i].equals("DirtAfterHero") && levelTab[j+1][i+1].equals("DirtAfterHero")) {
					    		levelTab[j+1][i] = "Boulder";
						    	levelTab[j][i] = "DirtAfterHero";
					    	}
				    	}
				    }	
			    			    
			    //Falling diamonds
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && levelTab[j][i+1].equals("DirtAfterHero")) {
			    	//Si le diamond est au dessus de ta tête
			    	if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+1)) {}
			    	else {
			    		levelTab[j][i] = "DirtAfterHero";
			    		levelTab[j][i+1] = "Diamond";
			    	
			    			if(levelTab[j][i] != null && levelTab[j][i+1].equals("Diamond") && (this.getCoordXHero() == j) && (this.getCoordYHero() == i+2)) {
			    					this.GameOver();
			    			}
			    	}
			    }
			    
			    //Dirt replacement by "DirtAfterHero"
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Dirt") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)){
	                levelTab[j][i] = "DirtAfterHero";
	            }
			    
			    //Player earn diamond
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i)) {
	                levelTab[j][i] = "DirtAfterHero";
			    	setDiamond(getDiamond() + 1);
	            }
			    		    
			    
			    //Boulder fall on enemy
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("Enemy")  ) {
			    	levelTab[j][i] = "DirtAfterHero";
			    	levelTab[j][i+1] = "Diamond";
			    	levelTab[j][i+2] = "Diamond";
			    	levelTab[j][i] = "Diamond";
			    	levelTab[j+1][i+1] = "Diamond";
			    	levelTab[j+1][i+2] = "Diamond";
			    	levelTab[j+1][i] = "Diamond";
			    	levelTab[j-1][i+1] = "Diamond";
			    	levelTab[j-1][i+2] = "Diamond";
			    	levelTab[j-1][i] = "Diamond";
			    }
			    
			    //Moving boulder left
				boolean varTestLeft = isBoulderLeft();
				if(varTestLeft == true && levelTab[j][i].equals("Boulder") && levelTab[j+1][i].equals("DirtAfterHero")) {
						levelTab[j+1][i] = "Boulder";
						levelTab[j][i] = "DirtAfterHero";
						System.out.println("left yes");
						setBoulderLeft(false);
				}
				
				//Moving boulder right
				boolean varTestRight = isBoulderRight();
				if(varTestRight == true && levelTab[j][i].equals("Boulder") && levelTab[j-1][i].equals("DirtAfterHero")) {
					levelTab[j-1][i] = "Boulder";
					levelTab[j][i] = "DirtAfterHero";
					System.out.println("right yes");
					setBoulderRight(false);
				}

			    if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("Enemy")){
					this.GameOver();
				}

			    if (levelTab[j][i] != null && getTimeLeft() == 1){
					this.GameOver();
				}

			    if(levelTab[j][i] != null && (this.getCoordXHero() == j) &&  (this.getCoordYHero() == i) && levelTab[j][i].equals("ExitDoor")){
			    	this.GameWin();
			    }

				if(levelTab[j][i] != null && getDiamond() == 0){
					this.GameWin();
				}
					
				if(levelTab[j][i].equals("Enemy")) {
					//gauche
					if(levelTab[j-1][i].equals("DirtAfterHero")) {
						levelTab[j-1][i]="Enemy";
						levelTab[j][i]="DirtAfterHero";
					}
					//droite
					if(levelTab[j+1][i].equals("DirtAfterHero")) {
						levelTab[j+1][i]="Enemy";
						levelTab[j][i]="DirtAfterHero";
					}
					/*
					//haut
					if() {
						
					}
					//bas
					if() {
						
					}
					*/
				}
				
		    i++;
		  }
		  j++;
		}
        System.out.println(Thread.currentThread().getName());

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
	}

	public void Timer(){
		for(timeLeft = 120; timerOn && timeLeft > 0; timeLeft--){

			this.setChanged();
			this.notifyObservers();
			
			try {
				Thread.sleep (1000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void GameOver(){
		GameOver.setGameState(true);
		timerOn = false;
	}
	
	
	public void GameWin(){
		this.setGameWin(true);
		timerOn = false;
		finalScore = getScore() + getTimeLeft();
		finalTime = 0;
	}

	public boolean isBoulderRight() {
		return rocherDroite;
	}

	public void setBoulderRight(boolean rocherDroite) {
		this.rocherDroite = rocherDroite;
	}

	public boolean isBoulderLeft() {
		return rocherGauche;
	}
	
	public void setBoulderLeft(boolean rocherGauche) {
		this.rocherGauche = rocherGauche;
	}

	

	

}
