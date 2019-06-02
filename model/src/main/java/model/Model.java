package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import contract.IModel;
import entity.*;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	File breakABlockSound = new File("Songs\\breakABlock.wav");
	File earningADiamond = new File("Songs\\earningADiamond.wav");
	File somethingIsFalling = new File("Songs\\somethingIsFalling.wav");
	File readyToLeaveThisPlace = new File("Songs\\readyToLeaveThisPlace.wav");
	File levelFinished = new File("Songs\\levelFinished.wav");
	File iLost = new File("Songs\\iLost.wav");
	
	private String[][] levelTab = new String[20][20];
	private String direction;
	private static int finalScore;
	private static int finalTime;
	private boolean gameWin = false;
	private boolean gameOver = false;
	private boolean diamondSprite = false;
	private boolean enemySprite = false;
	private boolean heroleft = false;
	private boolean heroright = false;
	private boolean herodown = false;
	private boolean heroup = false;
	private boolean exit = false;
	private static int score = 0;
	private static int diamond = 10;
	private static int timeLeft;
	private boolean rocherDroite;
	private boolean rocherGauche;
	private int levelNumber = 1;
	
	/** The Enemy */
	private Enemy enemy = new Enemy();

	private boolean readyToLeave = false;
	
	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	public boolean isReadyToLeave() {
		return readyToLeave;
	}

	public void setReadyToLeave(boolean readyToLeave) {
		this.readyToLeave = readyToLeave;
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
	
	public int getCoordXEnemy() {
		return enemy.getCoordX();
	}
	
	public void setCoordXEnemy(int coordX) {
		this.enemy.setCoordX(coordX);
	}
	
	public int getCoordYEnemy() {
		return enemy.getCoordY();
	}
	
	public void setCoordYEnemy(int coordY) {
		this.enemy.setCoordY(coordY);
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
			  		playSound(somethingIsFalling);
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
					    	playSound(somethingIsFalling);
				    	}
				    	else {
					    	//droite
					    	if(levelTab[j+1][i].equals("DirtAfterHero") && levelTab[j+1][i+1].equals("DirtAfterHero")) {
					    		levelTab[j+1][i] = "Boulder";
						    	levelTab[j][i] = "DirtAfterHero";
						    	playSound(somethingIsFalling);
					    	}
				    	}
				    }	
			    			    
			    //Falling diamonds
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && levelTab[j][i+1].equals("DirtAfterHero")) {
			    	playSound(somethingIsFalling);
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
	                playSound(breakABlockSound);
	            }
			    
			    //Player earn diamond
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (coordX == j) &&  (coordY == i)) {
	                levelTab[j][i] = "DirtAfterHero";
	                
	                if(this.getDiamond() > 0) {
	                	this.setDiamond(getDiamond() - 1);
	                }
			    	this.setScore(this.getScore()+15);
			    	playSound(earningADiamond);
	            }
			    		    
			    
			    //Boulder falling on enemy
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
			    	this.setCoordXEnemy(-2);
			    	this.setCoordYEnemy(-2);
			    }
			    
			    //Diamond falling on enemy
			    if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && levelTab[j][i+1].equals("Enemy")  ) {
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
			    	this.setCoordXEnemy(-2);
			    	this.setCoordYEnemy(-2);
			    }
			    
			    //Moving boulder right
			    
				boolean varTestRight = isBoulderRight();
				if(levelTab[j][i] != null && varTestRight && levelTab[j][i].equals("Boulder") && levelTab[j+1][i].equals("DirtAfterHero") && (coordX == j-1) && (coordY == i)) {
						levelTab[j+1][i] = "Boulder";
						levelTab[j][i] = "DirtAfterHero";
						setBoulderRight(false);
						setBoulderLeft(false);
				}
				
				//Moving boulder left
				boolean varTestLeft = isBoulderLeft();
				if(levelTab[j][i] != null && varTestLeft && levelTab[j][i].equals("Boulder") && levelTab[j-1][i].equals("DirtAfterHero") && (coordX== j+1) && (coordY == i)) {
					levelTab[j-1][i] = "Boulder";
					levelTab[j][i] = "DirtAfterHero";
					setBoulderLeft(false);
					setBoulderRight(false);
				}
				
			    if(levelTab[j][i] != null && (coordX == j) && (coordY == i) && levelTab[j][i].equals("Enemy")){
					this.setCoordXHero(4);
					this.setCoordYHero(4);
					this.GameOver();
				}

			    if (levelTab[j][i] != null && this.getTimeLeft() == 1){
					this.GameOver();
				}
			    
			    if(this.getDiamond() == 0 && !this.isReadyToLeave()) {
			    	playSound(readyToLeaveThisPlace);
			    	this.setReadyToLeave(true);
			    }
			    
			    if(levelTab[j][i] != null && levelTab[coordX][coordY].equals("ExitDoor") && this.getDiamond() == 0) {
			    	this.GameWin();
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
	else {
	}
	if(camY > offsetMaxY) {
		camY = offsetMaxY;
	}
	else if (camY < offsetMinY) {
		 camY = offsetMinY;
	}
	
	int i = 0;
	int j = 0;
	
	for(String subTab[] : levelCamera){
	  i = 0;
	  camY = this.getCoordYHero() - (16 / 2);
	  
		if(camY > offsetMaxY) {
			camY = offsetMaxY;
		}
		else if (camY < offsetMinY) {
			 camY = offsetMinY;
		}
		
	  for(String str : subTab){
			  levelCamera[j][i] = levelTab[j + camX][i + camY];
		  i++;
	  }
	  j++;
	}
	return levelCamera;
	}
	  
	
	public void setCharacterCoords(int coordX, int coordY) {
		
		this.setLevelTab(this.levelBehavior(this.getLevelTab(), coordX, coordY));
		
		this.levelTab[this.getCoordXHero()][this.getCoordYHero()] = "DirtAfterHero";
		this.setCoordXHero(coordX);
		this.setCoordYHero(coordY);
		this.levelTab[coordX][coordY] = "Hero";
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
				
		if(levelTab[coordX][coordY].equals("Enemy")) {
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
		
		/*try {
			Entity enemy = new Enemy();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
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
		while(true) {
			System.out.println(Timer.timerOn);
			if(Timer.timerOn) {
				for(timeLeft = 360; timeLeft > 0; timeLeft--){
					
					if(this.getCoordXEnemy() > 0 && this.getCoordYEnemy() > 0 && !GameOver.gameState) {
						this.checkCollisionEnemy(this.getCoordXEnemy(), this.getCoordYEnemy());
						this.setEnemyCoords(this.getCoordXEnemy(), this.getCoordYEnemy());
					}
					
					this.setLevelTab(this.levelBehavior(this.getLevelTab(), this.getCoordXHero(), this.getCoordYHero()));
					this.setLevelCamera(this.levelCamera(this.getLevelTab()));
					this.setExit(!this.isExit());
					this.diamondSprite = !this.diamondSprite;
					this.enemySprite = !enemySprite;
					this.heroleft = !this.heroleft;
					this.heroright = !this.heroright;		
					this.herodown = !this.herodown;
					this.heroup = !this.heroup;
					
					try {
						Thread.sleep (333);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					this.setChanged();
					this.notifyObservers();
				}
			}
		}
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
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
		this.setTimeLeft(360);
		this.setFinalTime(0);
		playSound(iLost);
	}
	
	
	public void GameWin(){
		GameWin.gameState = true;
		this.setScore(this.getScore() + this.getTimeLeft() / 3);
		finalTime = this.getTimeLeft() / 3;
		playSound(levelFinished);
	}
	
	public void setStartLevel() {
		this.setCharacterCoords(this.getCoordXHero(), this.getCoordYHero());
		this.setLevelTab(this.levelBehavior(this.getLevelTab(), this.getCoordXHero(), this.getCoordYHero()));
		this.setLevelCamera(this.levelCamera(this.getLevelTab()));
	}
	
	public int getRandomFour() {
		Random move = new Random();
		int randomNumber = move.nextInt(4 - 1 + 1) + 1;
		return randomNumber;
	}
	private int nbr=0;
	
	public int getNbr() {
		return this.nbr;
	}
	public int getChoice() {
		if(getNbr()==1) {
			return 1;
		}

		if(getNbr()==2) {
			return 2;
		}
		if(getNbr()==3) {
			return 3;
		}
		if(getNbr()==4) {
			return 4;
		}
		else {
			return getRandomFour();
		}
	}
	public void setNbr(int nbr) {
		this.nbr=nbr;
	}
	public void checkCollisionEnemy(int coordXEnemy, int coordYEnemy) {
		String[][] levelTab = this.getLevelTab();		
		
			switch(getChoice()){
			case 1:
					if(levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy+1][coordYEnemy].equals("DirtAfterHero") || levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy+1][coordYEnemy].equals("Hero")) {
						this.setCoordXEnemy(this.getCoordXEnemy() + 1);
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						setNbr(1);
						
					}	else {
						setNbr(getRandomFour());
					}		
				break;
			case 2:		
					if(levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy-1][coordYEnemy].equals("DirtAfterHero") || levelTab[coordXEnemy-1][coordYEnemy] != null && levelTab[coordXEnemy-1][coordYEnemy].equals("Hero")) {
						this.setCoordXEnemy(this.getCoordXEnemy() - 1);
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						setNbr(2);
						
					} 	else {
						setNbr(getRandomFour());

					}	
				break;
			case 3:			
					if(levelTab[coordXEnemy][coordYEnemy] != null && levelTab[coordXEnemy][coordYEnemy-1].equals("DirtAfterHero") || levelTab[coordXEnemy][coordYEnemy-1] != null && levelTab[coordXEnemy][coordYEnemy-1].equals("Hero")) {
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.setCoordYEnemy(this.getCoordYEnemy() - 1);
						setNbr(3);

					}else {
						setNbr(getRandomFour());

					}				
				break;
			case 4:
					if(levelTab[coordXEnemy][coordYEnemy] != null && levelTab[coordXEnemy][coordYEnemy+1].equals("DirtAfterHero") || levelTab[coordXEnemy][coordYEnemy +1] != null && levelTab[coordXEnemy][coordYEnemy+1].equals("Hero")) {
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.setCoordYEnemy(this.getCoordYEnemy() + 1);
						setNbr(4);
					}else {
						setNbr(getRandomFour());

					}

				break;
			}
	}
	
	public void setEnemyCoords(int coordX, int coordY) {
		
			this.levelTab[coordX][coordY] = "Enemy";
	}
	
	public void playSound(File sound){
		try {
			
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}