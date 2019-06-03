package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import contract.IModel;
import entity.BorderBlock;
import entity.Boulder;
import entity.Diamond;
import entity.DiamondsLeft;
import entity.Dirt;
import entity.DirtAfterHero;
import entity.Enemy;
import entity.ExitDoor;
import entity.GameOver;
import entity.GameWin;
import entity.Hero;
import entity.Level;
import entity.Score;
import entity.Timer;
import model.checks.CheckCollisions;
import model.database.DAOLevel1;
import model.database.DAOLevel2;
import model.database.DAOLevel3;
import model.database.DAOLevel4;
import model.database.DAOLevel5;
import model.database.DBConnection;
import model.levelbehavior.ModelBehaviors;
import model.levelmechanics.GlobalLevelMechanics;

/**
 * The Class Model.
 *
 * @author PAIN Valentin, FORQUES Pierre, LANGLOIS Theo, LALISSE Adrien
 */
public final class Model extends Observable implements IModel {
	
	/** The level Finished song. */
	public File levelFinished = new File("Songs\\levelFinished.wav");
	
	/** The lose song. */
	public File iLost = new File("Songs\\iLost.wav");
	
	/** The model Behavior. */
	ModelBehaviors modelBehaviors = new ModelBehaviors(this);
	
	/** The global Level Mechanics. */
	GlobalLevelMechanics globalLevelMechanics = new GlobalLevelMechanics(this, this.getModelBehaviors());
	
	/** The check Colisions. */
	CheckCollisions checkCollisions = new CheckCollisions(this);
	
	/** The level Tab. */
	private String[][] levelTab = new String[20][20];
	
	/** The direction. */
	private String direction;
	
	/** The final Score. */
	private static int finalScore;
	
	/** The final Time. */
	private static int finalTime;
	
	/** The game Win. */
	private boolean gameWin = false;
	
	/** The game Over. */
	private boolean gameOver = false;
	
	/** The diamond Sprite. */
	private boolean diamondSprite = false;
	
	/** The enemy Sprite. */
	private boolean enemySprite = false;
	
	/** The hero Left. */
	private boolean heroleft = false;
	
	/** The hero Right. */
	private boolean heroright = false;
	
	/** The hero Down. */
	private boolean herodown = false;
	
	/** The hero Up. */
	private boolean heroup = false;
	
	/** The exit. */
	private boolean exit = false;
	
	/** The score. */
	private static int score = 0;
	
	/** The diamond. */
	private static int diamond = 10;
	
	/** The levels. */
	private int timeLeft;
	
	/** The boulder Right.. */
	private boolean boulderRight;
	
	/** The boulder Left. */
	private boolean boulderLeft;
	
	/** The level Number. */
	private int levelNumber = 1;
	
	/** The ready To Leave. */
	private boolean readyToLeave = false;
	
	/** The nbr. */
	private int nbr = 0;
	
	/** The levels. */
	private Level level;
	
	/** The hero. */
	private Hero hero = new Hero();
	
	/** The level Camera. */
	private String[][] levelCamera = new String[16][16];
	
	/** The Enemy. */
	private Enemy enemy = new Enemy();
	
	/**
	 * Gets the level number.
	 * 
	 * @return levelNumber
	 */
	public int getLevelNumber() {return levelNumber;}
	
	/**
	 * Sets the levelNumber.
	 * 
	 * @param levelNumber
	 */
	public void setLevelNumber(int levelNumber) {this.levelNumber = levelNumber;}
	
	/**
	 * Gets the ready To Leave.
	 * 
	 * @return readyToLeave
	 */
	public boolean isReadyToLeave() {return readyToLeave;}
	
	/**
	 * Sets the ready To Leave
	 * 
	 * @param readyToLeave
	 */
	public void setReadyToLeave(boolean readyToLeave) {this.readyToLeave = readyToLeave;}
	
	/**
	 * Gets the (right) state of the boulder.
	 * 
	 * @return isBoulderRight
	 */
	public boolean isBoulderRight() {return boulderRight;}
	
	/**
	 * Sets the (right) state of the boulder.
	 * 
	 * @param boulderRight
	 */
	public void setBoulderRight(boolean boulderRight) {this.boulderRight = boulderRight;}
	
	/**
	 * Gets the (left) state of the boulder left.
	 * 
	 * @return boulderLeft
	 */
	public boolean isBoulderLeft() {return boulderLeft;}
	
	/**
	 * Sets the (left) state of the boulder.
	 * 
	 * @param boulderLeft
	 */
	public void setBoulderLeft(boolean boulderLeft) {this.boulderLeft = boulderLeft;}
	
	/**
	 * Gets the x coord of the Enemy.
	 * 
	 * @return coordXEnemy
	 */
	public int getCoordXEnemy() {return enemy.getCoordX();}
	
	/**
	 * Sets the x coord of the Enemy.
	 * 
	 * @param coordXEnemy
	 */
	public void setCoordXEnemy(int coordX) {this.enemy.setCoordX(coordX);}
	
	/**
	 * Gets the y coord of the Enemy.
	 * 
	 * @return coordYEnemy
	 */
	public int getCoordYEnemy() {return enemy.getCoordY();}
	
	/**
	 * Sets the y coord of the Enemy.
	 * 
	 * @param coordYEnemy
	 */
	public void setCoordYEnemy(int coordY) {this.enemy.setCoordY(coordY);}
	
	/**
	 * Gets the direction.
	 * 
	 * @return direction
	 */
	public String getDirection() {return direction;}
	
	/**
	 * Sets the direction
	 * 
	 * @param direction
	 */
	public void setDirection(String direction) {this.direction = direction;}
	
	/**
	 * Gets the level Camera.
	 * 
	 * @return levelCamera
	 */
	public String[][] getLevelCamera() {return levelCamera;}
	
	/**
	 * Sets the level Camera.
	 * 
	 * @param levelCamera
	 */
	public void setLevelCamera(String[][] levelCamera) {this.levelCamera = levelCamera;}
	
	/**
	 * Gets the level Tab.
	 * 
	 * @return levelTab
	 */
	public String[][] getLevelTab() {return levelTab;}
	
	/**
	 * Sets the level Tab.
	 * 
	 * @param levelTab
	 */
	public void setLevelTab(String[][] levelTab) {this.levelTab = levelTab;}
	
	/**
	 * Gets the level.
	 * 
	 * @return level
	 */
	public Level getLevel() {return level;}
	
	/**
	 * Gets the x coord of the hero.
	 * 
	 * @return coordXHero
	 */
	public int getCoordXHero() {return hero.getCoordX();}
	
	/**
	 * Sets the x coord of the hero.
	 * 
	 * @param coordXHero
	 */
	public void setCoordXHero(int coordX) {this.hero.setCoordX(coordX);}
	
	/**
	 * Gets the y coord of the hero.
	 * 
	 * @return coordYHero
	 */
	public int getCoordYHero() {return hero.getCoordY();}
	
	/**
	 * Sets the y coord of the hero.
	 * 
	 * @param coordYHero
	 */
	public void setCoordYHero(int coordY) {this.hero.setCoordY(coordY);}
	
	/**
	 * Gets the time Left.
	 * 
	 * @return timeLeft
	 */
	public int getTimeLeft(){return timeLeft;}
	
	/**
	 * Sets the time Left.
	 * 
	 * @param timeLeft
	 */
	public void setTimeLeft(int timeLeft){this.timeLeft = timeLeft;}
	
	/**
	 * Gets the game Win;
	 * 
	 * @return gamemWin
	 */
	public boolean getGameWin() {return gameWin;}
	
	/**
	 * Sets the game Win.
	 * 
	 * @param gameWin
	 */
	public void setGameWin(boolean gameWin) {this.gameWin= gameWin;}
	
	/**
	 * Gets the final Score.
	 * 
	 * @return finalScore
	 */
	public int getFinalScore(){return finalScore;}
	
	/**
	 * Sets the final Score.
	 * 
	 * @param finalScore
	 */
	public void setFinalScore(int finalScore){Model.finalScore = finalScore;}
	
	/**
	 * Gets the finalTime.
	 * 
	 * @return finalTime
	 */
	public int getFinalTime(){return finalTime;}
	
	/**
	 * Sets the final Time.
	 * 
	 * @param finalTime
	 */
	public void setFinalTime(int finalTime){Model.finalTime = finalTime;}
	
	/**
	 * Gets the score.
	 * 
	 * @return score
	 */
	public int getScore() {return score;}
	
	/**
	 * Sets the score.
	 * 
	 * @param score
	 */
	public void setScore(int score) {Model.score = score;}
	
	/**
	 * Gets the game Over.
	 * 
	 * @return gameOver
	 */
	public boolean getGameOver() {return gameOver;}
	
	/**
	 * Sets the game Over.
	 * 
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {this.gameOver = gameOver;}
	
	/**
	 * Gets the diamond.
	 * 
	 * @return diamond
	 */
	public int getDiamond() {return diamond;}
	
	/**
	 * Sets the diamond
	 * 
	 * @param diamond
	 */
	public void setDiamond(int diamond) {Model.diamond = diamond;}
	
	/**
	 * Gets the model Behaviors.
	 * 
	 * @return modelBehaviors
	 */
	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	
	/**
	 * Sets the modelBehaviors.
	 * 
	 * @param modelBehaviors
	 */
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	/**
	 * Gets the state of the Enemy Sprite.
	 * 
	 * @return enemySprite
	 */
	public boolean isEnemySprite() {return enemySprite;}
	
	/**
	 * Sets the Enemy Sprite.
	 * 
	 * @param enemySprite
	 */
	public void setEnemySprite(boolean enemySprite) {this.enemySprite = enemySprite;}
	
	/**
	 * Gets the Enemy.
	 * 
	 * @return enemy
	 */
	public Enemy getEnemy() {return enemy;}
	
	/**
	 * Sets the Enemy.
	 * 
	 * @param enemy
	 */
	public void setEnemy(Enemy enemy) {this.enemy = enemy;}
	
	/**
	 * Gets the hero.
	 * 
	 * @return hero
	 */
	public Hero getHero() {return hero;}
	
	/**
	 * Gets the state of the exit.
	 * 
	 * @return exit
	 */
	public boolean isExit() {return exit;}
	
	/**
	 * Sets the state of the exit.
	 * 
	 * @param exit
	 */
	public void setExit(boolean exit) {this.exit = exit;}
	
	/**
	 * Gets the (left) state of the hero.
	 * 
	 * @return heroLeft
	 */
	public boolean isHeroleft() {return heroleft;}
	
	/**
	 * Sets the (left) state of the hero.
	 * 
	 * @param heroLeft
	 */
	public void setHeroleft(boolean heroleft) {this.heroleft = heroleft;}
	
	/**
	 * Gets the (right) state of the hero.
	 * 
	 * @return heroRight
	 */
	public boolean isHeroright() {return heroright;}
	
	/**
	 * Sets the (right) state of the hero.
	 * 
	 * @param heroRight
	 */
	public void setHeroright(boolean heroright) {this.heroright = heroright;}
	
	/**
	 * Gets the (down) state of the hero.
	 * 
	 * @return heroDown
	 */
	public boolean isHerodown() {return herodown;}
	
	/**
	 * Sets the (down) state of the hero.
	 * 
	 * @param heroDown
	 */
	public void setHerodown(boolean herodown) {this.herodown = herodown;}
	
	/**
	 * Gets the (up) state of the hero.
	 * 
	 * @return heroUp
	 */
	public boolean isHeroup() {return heroup;}
	
	/**
	 * Sets the (up) state of the hero.
	 * 
	 * @param heroUp
	 */
	public void setHeroup(boolean heroup) {this.heroup = heroup;}
	
	/**
	 * Gets the state of the diamond Sprite.
	 * 
	 * @return diamondSprite
	 */
	public boolean isDiamondSprite() {return diamondSprite;}
	
	/**
	 * Sets the state of the diamond Sprite.
	 * 
	 * @param diamondSprite
	 */
	public void setDiamondSprite(boolean diamondSprite) {this.diamondSprite = diamondSprite;}
	
	/**
	 * Sets the hero
	 * 
	 * @param hero
	 */
	public void setHero(Hero hero) {this.hero = hero;}
	
	/**
	 * Gets the global Level Mechanics.
	 * 
	 * @return globalLevelMechanics
	 */
	public GlobalLevelMechanics getGlobalLevelMechanics() {return globalLevelMechanics;}
	
	/**
	 * Sets the globalLevelMechanics.
	 * 
	 * @param globalLevelMechanics
	 */
	public void setGlobalLevelMechanics(GlobalLevelMechanics globalLevelMechanics) {this.globalLevelMechanics = globalLevelMechanics;}
	
	/**
	 * Sets the nbr.
	 * 
	 * @param nbr
	 */
	public void setNbr(int nbr) {this.nbr=nbr;}
	
	/**
	 * Sets the Enemy Coords.
	 * 
	 * @param enemyCoords
	 */
	public void setEnemyCoords(int coordX, int coordY) {this.levelTab[coordX][coordY] = "Enemy";}
	
	/**
	 * Gets the check Collisions.
	 * 
	 * @return checkCollisions
	 */
	public CheckCollisions getCheckCollisions() {return checkCollisions;}
	
	/**
	 * Sets the checkCollisions.
	 * 
	 * @param checkCollision
	 */
	public void setCheckCollisions(CheckCollisions checkCollisions) {this.checkCollisions = checkCollisions;}
	
	/**
	 * Gets the randomFour.
	 * 
	 * @return randomFour
	 */
	public int getRandomFour() {
		Random move = new Random();
		int randomNumber = move.nextInt(4 - 1 + 1) + 1;
		return randomNumber;
		}
	
	/**
	 * Sets the level.
	 * 
	 * @param level
	 */
	public void setLevel(Level level) {
		this.level = level;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.level = new Level();
	}

	/**
	 * Load the level.
	 */
	public void loadLevel(int lvl) {
		this.setDiamond(10);
		this.setTimeLeft(360);
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
	  
	/**
	 * Sets the character Coords..
	 * 
	 * @param coordX
	 * @param coordY
	 */
	public void setCharacterCoords(int coordX, int coordY) {
		this.setLevelTab(modelBehaviors.levelBehavior(this.getLevelTab(), coordX, coordY));
		
		this.levelTab[this.getCoordXHero()][this.getCoordYHero()] = "DirtAfterHero";
		this.setCoordXHero(coordX);
		this.setCoordYHero(coordY);
		this.levelTab[coordX][coordY] = "Hero";
		this.setLevelCamera(this.getGlobalLevelMechanics().levelCamera(this.getLevelTab()));
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * check interaction.
	 */
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

	/**
	 * Avoid latency.
	 * @throws IOException
	 */
	public void avoidLatency() throws IOException {
		new BorderBlock();
		new Boulder();
		new Diamond();
		new Dirt();
		new DirtAfterHero();
		new ExitDoor();
		new GameWin();
		new GameOver();
		new Timer();
		new Score();
		new DiamondsLeft();
	}

	/**
	 * set the time.
	 */
	public void Timer(){
		while(true) {
			if(Timer.timerOn) {
				for(timeLeft = 360; timeLeft > 0; timeLeft--){
					
					if(this.getCoordXEnemy() > 0 && this.getCoordYEnemy() > 0 && !GameOver.gameState) {
						this.getCheckCollisions().checkCollisionEnemy(this.getCoordXEnemy(), this.getCoordYEnemy());
						this.setEnemyCoords(this.getCoordXEnemy(), this.getCoordYEnemy());
					}
					
					this.setLevelTab(modelBehaviors.levelBehavior(this.getLevelTab(), this.getCoordXHero(), this.getCoordYHero()));
					this.setLevelCamera(this.getGlobalLevelMechanics().levelCamera(this.getLevelTab()));
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
	
	/**
     * Gets the nbr.
     *
     * @return nbr
     */
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
	
	/**
	* Play a sound.
	*/
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
	
	/**
	 * Adjust the level camera.
	 */
	public String[][] levelCam(String[][] levelTab) {
		String[][] CameraTab = this.getGlobalLevelMechanics().levelCamera(levelTab);
		return CameraTab;
	}
	
	/**
	 * start the level.
	 */
	public void setStartLevel() {
		this.getGlobalLevelMechanics().setStartLevel();
	}
	
	/**
	 * check collisions with boulder.
	 */
	public boolean checkCollisionBoulder(int coordX, int coordY) {
		boolean check = this.getCheckCollisions().checkCollisionBoulder(coordX, coordY);
		return check;
	}
	
	/**
	 * check collision.
	 */
	@Override
	public boolean checkCollision(int coordX, int coordY) {
		boolean check = this.getCheckCollisions().checkCollision(coordX, coordY);
		return check;
	}
	
	/**
	 * Game Over.
	 */
	public void GameOver(){
		GameOver.gameState = true;
		this.setTimeLeft(360);
		this.setFinalTime(0);
		this.playSound(iLost);
	}
	
	/**
	 * Game Win.
	 */
	public void GameWin(){
		GameWin.gameState = true;
		this.setScore(this.getScore() + this.getTimeLeft() / 3);
		this.setTimeLeft(this.getTimeLeft() / 3);
		this.playSound(levelFinished);
	}
}