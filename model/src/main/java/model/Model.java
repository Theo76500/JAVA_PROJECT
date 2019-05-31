package model;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.BorderBlock;
import entity.Boulder;
import entity.Diamond;
import entity.DiamondsLeft;
import entity.Dirt;
import entity.DirtAfterHero;
import entity.Enemy;
import entity.Entity;
import entity.ExitDoor;
import entity.GameOver;
import entity.GameWin;
import entity.Hero;
import entity.Level;
import entity.Score;
import entity.Timer;

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
	boolean diamondSprite = false;
	boolean heroleft = false;
	boolean heroright = false;
	boolean herodown = false;
	boolean heroup = false;
	private static int score = 0;
	private static int diamond = 10;
	private static int timeLeft;
	private boolean rocherDroite;
	private boolean rocherGauche;
	
	/** The Enemy */
	private Enemy enemy = new Enemy("Enemy", true, 5, 9);
	
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
	
	public int getCoordXEnemy() {
		return hero.getCoordX();
	}
	
	public void setCoordXEnemy(int coordX) {
		this.hero.setCoordX(coordX);
	}
	
	public int getCoordYEnemy() {
		return hero.getCoordY();
	}
	
	public void setCoordYEnemy(int coordY) {
		this.hero.setCoordY(coordY);
	}
	
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
	
	private String[][] levelCamera = new String[16][16];


	public String[][] getLevelCamera() {
		return levelCamera;
	}

	public void setLevelCamera(String[][] levelCamera) {
		this.levelCamera = levelCamera;
	}

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
	


	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadLevel(int lvl) {
		diamond = 10;
		timeLeft = 120;
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
	
	public String[][] levelBehavior(String[][] levelTab, int coordX, int coordY) {
		
		int i = 0;
		int j = 0;
		 
		for(String subTab[] : levelTab)
		{
		  i = 0;
		  for(String str : subTab)
		  {     

				//Falling boulder
			  	if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("DirtAfterHero")) {
			  		
				    //If the boulder is above the player
				    if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && (coordX == j) && (coordY == i+1)) {}
				    else {
				    	levelTab[j][i] = "DirtAfterHero";
				    	levelTab[j][i+1] = "Boulder";
				    		if(levelTab[j][i] != null && levelTab[j][i+1].equals("Boulder") && (coordX == j) && (coordY == i+2)) {
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
			    	if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (coordX == j) && (coordY == i+1)) {}
			    	else {
			    		levelTab[j][i] = "DirtAfterHero";
			    		levelTab[j][i+1] = "Diamond";
			    	
			    			if(levelTab[j][i] != null && levelTab[j][i+1].equals("Diamond") && (coordX == j) && (coordY== i+2)) {
			    					this.GameOver();
			    			}
			    	}
			    }
			    
			    //Dirt replacement by "DirtAfterHero"
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Dirt") && (coordX == j) &&  (coordY == i)){
	                levelTab[j][i] = "DirtAfterHero";
	            }
			    
			    //Player earn diamond
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (coordX == j) &&  (coordY == i)) {
	                levelTab[j][i] = "DirtAfterHero";
			    	setDiamond(getDiamond() - 1);
	            }
			    		    
			    
			    //Diamond falling on enemy
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
			    
			    //Moving boulder right
			    
				boolean varTestRight = isBoulderRight();
				if(levelTab[j][i] != null && varTestRight && levelTab[j][i].equals("Boulder") && levelTab[j+1][i].equals("DirtAfterHero") && (this.getCoordXHero() == j-1) && (this.getCoordYHero() == i)) {
						levelTab[j+1][i] = "Boulder";
						levelTab[j][i] = "DirtAfterHero";
						System.out.println("right yes");
						setBoulderRight(false);
						setBoulderLeft(false);
				}
				
				//Moving boulder left
				boolean varTestLeft = isBoulderLeft();
				if(levelTab[j][i] != null && varTestLeft && levelTab[j][i].equals("Boulder") && levelTab[j-1][i].equals("DirtAfterHero") && (this.getCoordXHero() == j+1) && (this.getCoordYHero() == i)) {
					levelTab[j-1][i] = "Boulder";
					levelTab[j][i] = "DirtAfterHero";
					System.out.println("left yes");
					setBoulderLeft(false);
					setBoulderRight(false);
				}
				
			    if(levelTab[j][i] != null && (coordX == j) &&  (coordX== i) && levelTab[j][i].equals("Enemy")){
					this.GameOver();
					System.out.println("dead");
				}

			    if (levelTab[j][i] != null && this.getTimeLeft() == 1){
					this.GameOver();
				}

		    i++;
		  }
		  j++;
		}
		
		return levelTab;
	}
	
	public String[][] levelCamera(String[][] levelTab) {
		
	int offsetMaxX = 20 - 16;
	int offsetMaxY = 20 - 16;
	int offsetMinX = 0;
	int offsetMinY = 0;
	
	int camX = this.getCoordXHero() - (16 / 2);
	int camY = this.getCoordYHero() - (16 / 2);
	
	if (camX > offsetMaxX) {
		camX = offsetMaxX;
	}
	else if(camX < offsetMinX) {
		camX = offsetMinX;
	}
	if(camY > offsetMaxY) {
		camY = offsetMaxY;
	}
	else if (camY < offsetMinY) {
		 camY = offsetMinY;
	}
	
	int i = 0;
	int j = 0;
	
	for(String subTab[] : levelCamera)
	{
	  i = 0;
	  camY = this.getCoordYHero() - (16 / 2);
	  
		if(camY > offsetMaxY) {
			camY = offsetMaxY;
		}
		else if (camY < offsetMinY) {
			 camY = offsetMinY;
		}
		
	  for(String str : subTab)
	  {     
		    levelCamera[j][i] = levelTab[j + camX][i + camY];
		  i++;
	  }
	  j++;
	}
	return levelCamera;
	}
	  
	
	public void setCharacterCoords(int coordX, int coordY) {
		
		this.diamondSprite = !this.diamondSprite;
		
		this.setLevelTab(this.levelBehavior(this.getLevelTab(), coordX, coordY));
		
		this.levelTab[this.getCoordXHero()][this.getCoordYHero()] = "DirtAfterHero";
		this.setCoordXHero(coordX);
		this.setCoordYHero(coordY);
		this.levelTab[coordX][coordY] = "Hero";
		//}
		
		//this.setLevelTab(this.levelBehavior(this.getLevelTab()));
		this.setLevelCamera(this.levelCamera(this.getLevelTab()));
		
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
	
	public boolean checkCollisionBoulder(int coordX, int coordY) {
		
		String levelTab[][] = this.getLevelTab();
		
		if(levelTab[coordX][coordY].equals("Boulder")) {
			
			return false;
		}
			
			return true;
		
	}
	
	public boolean checkInteraction(int coordX, int coordY) {
		
		String levelTab[][] = this.getLevelTab();
		
		if(levelTab[coordX][coordY].equals("ExitDoor")){
			if(this.getDiamond() == 0) {
				this.GameWin();
				return false;
			}
			else {
				return false;
			}
		}
				
		if(levelTab[coordX][coordY].equals("Ennemy")) {
			this.GameOver();
			return false;
		}
		
		return true;
	}
	
	public void avoidLatency() throws IOException {
		
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
		
		//final Entity hero = new Hero();
	}

	public void Timer(){
		for(timeLeft = 120; Timer.timerOn && timeLeft > 0; timeLeft--){
			
			
			this.setLevelTab(this.levelBehavior(this.getLevelTab(), this.getCoordXHero(), this.getCoordYHero()));
			this.setLevelCamera(this.levelCamera(this.getLevelTab()));
			
			this.diamondSprite = !this.diamondSprite;
			
			this.heroleft = !this.heroleft;
			this.heroright = !this.heroright;		
			this.herodown = !this.herodown;
			this.heroup = !this.heroup;
			
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

	public boolean isHeroleft() {
		return heroleft;
	}

	public void setHeroleft(boolean heroleft) {
		this.heroleft = heroleft;
	}

	public boolean isHeroright() {
		return heroright;
	}

	public void setHeroright(boolean heroright) {
		this.heroright = heroright;
	}

	public boolean isHerodown() {
		return herodown;
	}

	public void setHerodown(boolean herodown) {
		this.herodown = herodown;
	}

	public boolean isHeroup() {
		return heroup;
	}

	public void setHeroup(boolean heroup) {
		this.heroup = heroup;
	}

	public boolean isDiamondSprite() {
		return diamondSprite;
	}

	public void setDiamondSprite(boolean diamondSprite) {
		this.diamondSprite = diamondSprite;
	}

	public void GameOver(){
		GameOver.gameState = true;
		Timer.timerOn = false;
		timeLeft = 0;
	}
	
	
	public void GameWin(){
		GameWin.gameState = true;
		Timer.timerOn = false;
		finalScore = getScore() + getTimeLeft();
		finalTime = 0;
	}
	
	public void setStartLevel() {
		this.setCharacterCoords(this.getCoordXHero(), this.getCoordYHero());
		this.setLevelTab(this.levelBehavior(this.getLevelTab(), this.getCoordXHero(), this.getCoordYHero()));
		this.setLevelCamera(this.levelCamera(this.getLevelTab()));
	}
}