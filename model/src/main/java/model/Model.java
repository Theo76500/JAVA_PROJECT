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
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	
	public File levelFinished = new File("Songs\\levelFinished.wav");
	public File iLost = new File("Songs\\iLost.wav");
	
	ModelBehaviors modelBehaviors = new ModelBehaviors(this);
	GlobalLevelMechanics globalLevelMechanics = new GlobalLevelMechanics(this, this.getModelBehaviors());
	CheckCollisions checkCollisions = new CheckCollisions(this);
	
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
	private int timeLeft;
	private boolean rocherDroite;
	private boolean rocherGauche;
	private int levelNumber = 1;
	private boolean readyToLeave = false;
	private int nbr = 0;
	/** The levels. */
	private Level level;
	
	/** The character */
	private Hero hero = new Hero();
	
	private String[][] levelCamera = new String[16][16];
	
	/** The Enemy */
	private Enemy enemy = new Enemy();
	
	public int getLevelNumber() {return levelNumber;}
	public void setLevelNumber(int levelNumber) {this.levelNumber = levelNumber;}
	public boolean isReadyToLeave() {return readyToLeave;}
	public void setReadyToLeave(boolean readyToLeave) {this.readyToLeave = readyToLeave;}
	public boolean isBoulderRight() {return rocherDroite;}
	public void setBoulderRight(boolean rocherDroite) {this.rocherDroite = rocherDroite;}
	public boolean isBoulderLeft() {return rocherGauche;}
	public void setBoulderLeft(boolean rocherGauche) {this.rocherGauche = rocherGauche;}
	public int getCoordXEnemy() {return enemy.getCoordX();}
	public void setCoordXEnemy(int coordX) {this.enemy.setCoordX(coordX);}
	public int getCoordYEnemy() {return enemy.getCoordY();}
	public void setCoordYEnemy(int coordY) {this.enemy.setCoordY(coordY);}
	public String getDirection() {return direction;}
	public void setDirection(String direction) {this.direction = direction;}
	public String[][] getLevelCamera() {return levelCamera;}
	public void setLevelCamera(String[][] levelCamera) {this.levelCamera = levelCamera;}
	public String[][] getLevelTab() {return levelTab;}
	public void setLevelTab(String[][] levelTab) {this.levelTab = levelTab;}
	public Level getLevel() {return level;}
	public int getCoordXHero() {return hero.getCoordX();}
	public void setCoordXHero(int coordX) {this.hero.setCoordX(coordX);}
	public int getCoordYHero() {return hero.getCoordY();}
	public void setCoordYHero(int coordY) {this.hero.setCoordY(coordY);}
	public int getTimeLeft(){return timeLeft;}
	public void setTimeLeft(int timeLeft){this.timeLeft = timeLeft;}
	public boolean getGameWin() {return gameWin;}
	public void setGameWin(boolean gameWin) {this.gameWin= gameWin;}
	public int getFinalScore(){return finalScore;}
	public void setFinalScore(int finalScore){Model.finalScore = finalScore;}
	public int getFinalTime(){return finalTime;}
	public void setFinalTime(int finalTime){Model.finalTime = finalTime;}
	public int getScore() {return score;}
	public void setScore(int score) {Model.score = score;}
	public boolean getGameOver() {return gameOver;}
	public void setGameOver(boolean gameOver) {this.gameOver = gameOver;}
	public int getDiamond() {return diamond;}
	public void setDiamond(int diamond) {Model.diamond = diamond;}
	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	public boolean isEnemySprite() {return enemySprite;}
	public void setEnemySprite(boolean enemySprite) {this.enemySprite = enemySprite;}
	public boolean isRocherDroite() {return rocherDroite;}
	public void setRocherDroite(boolean rocherDroite) {this.rocherDroite = rocherDroite;}
	public boolean isRocherGauche() {return rocherGauche;}
	public void setRocherGauche(boolean rocherGauche) {this.rocherGauche = rocherGauche;}
	public Enemy getEnemy() {return enemy;}
	public void setEnemy(Enemy enemy) {this.enemy = enemy;}
	public Hero getHero() {return hero;}
	public boolean isExit() {return exit;}
	public void setExit(boolean exit) {this.exit = exit;}
	public boolean isHeroleft() {return heroleft;}
	public void setHeroleft(boolean heroleft) {this.heroleft = heroleft;}
	public boolean isHeroright() {return heroright;}
	public void setHeroright(boolean heroright) {this.heroright = heroright;}
	public boolean isHerodown() {return herodown;}
	public void setHerodown(boolean herodown) {this.herodown = herodown;}
	public boolean isHeroup() {return heroup;}
	public void setHeroup(boolean heroup) {this.heroup = heroup;}
	public boolean isDiamondSprite() {return diamondSprite;}
	public void setDiamondSprite(boolean diamondSprite) {this.diamondSprite = diamondSprite;}
	public void setHero(Hero hero) {this.hero = hero;}
	public GlobalLevelMechanics getGlobalLevelMechanics() {return globalLevelMechanics;}
	public void setGlobalLevelMechanics(GlobalLevelMechanics globalLevelMechanics) {this.globalLevelMechanics = globalLevelMechanics;}
	public void setNbr(int nbr) {this.nbr=nbr;}
	public void setEnemyCoords(int coordX, int coordY) {this.levelTab[coordX][coordY] = "Enemy";}
	public CheckCollisions getCheckCollisions() {return checkCollisions;}
	public void setCheckCollisions(CheckCollisions checkCollisions) {this.checkCollisions = checkCollisions;}
	
	public int getRandomFour() {
		Random move = new Random();
		int randomNumber = move.nextInt(4 - 1 + 1) + 1;
		return randomNumber;
		}
	
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
	
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
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
	
	public String[][] levelCam(String[][] levelTab) {
		String[][] CameraTab = this.getGlobalLevelMechanics().levelCamera(levelTab);
		return CameraTab;
	}
	
	public void setStartLevel() {
		this.getGlobalLevelMechanics().setStartLevel();
	}
	
	public boolean checkCollisionBoulder(int coordX, int coordY) {
		boolean check = this.getCheckCollisions().checkCollisionBoulder(coordX, coordY);
		return check;
	}
	@Override
	public boolean checkCollision(int coordX, int coordY) {
		boolean check = this.getCheckCollisions().checkCollision(coordX, coordY);
		return check;
	}
	
	public void GameOver(){
		GameOver.gameState = true;
		this.setTimeLeft(360);
		this.setFinalTime(0);
		this.playSound(iLost);
	}
	
	public void GameWin(){
		GameWin.gameState = true;
		this.setScore(this.getScore() + this.getTimeLeft() / 3);
		this.setTimeLeft(this.getTimeLeft() / 3);
		this.playSound(levelFinished);
	}
}