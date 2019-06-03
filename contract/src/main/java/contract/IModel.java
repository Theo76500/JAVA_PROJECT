package contract;

import java.io.File;
import java.util.Observable;

import entity.Level;

/**
 * The Interface IModel.
 *
 * @author Valentin Pain, Adrien Lalisse, Théo Langlois & Pierre Forques
 */

public interface IModel {

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel();
	

	/**
	 * Sets the level.
	 * 
	 * @param level
	 * The level
	 */
	public void setLevel(Level level);
	
	/**
	 * Load the level.
	 * 
	 * @param level
	 * the level
	 */
	void loadLevel(int lvl);

	/**
	 * Gets the levelTab.
	 * 
	 * @return the levelTab
	 */
	public String[][] getLevelTab();
	
	/**
	 * Sets the levelTab.
	 * 
	 * @param levelTab
	 * The leveltab
	 */
	public void setLevelTab(String[][] levelTab);
	
	/**
	 * Gets the direction
	 * 
	 * @return the direction
	 */
	public String getDirection();
	
	/**
	 * Sets the direction.
	 * 
	 * @param direction
	 * the direction
	 */
	public void setDirection(String direction);
	
	/**
	 * Gets the x coord of the hero.
	 * 
	 * @return coordXHero
	 */
	public int getCoordXHero();

	/**
	 * Sets the x coord of the hero.
	 * 
	 * @param coordX
	 * coordX
	 */
	public void setCoordXHero(int coordX);
	
	/**
	 * Gets the y coord of the hero.
	 * 
	 * @return coordYHero
	 */
	public int getCoordYHero();
	
	/**
	 * Sets the y coord of the hero.
	 * 
	 * @param coordY
	 * coordY
	 */
	public void setCoordYHero(int coordY);
	
	/**
	 * Sets the coords of the hero.
	 * 
	 * @param coordX
	 * coordX
	 * @param coordY
	 * coordY
	 */
	void setCharacterCoords(int coordX, int coordY);
	
	/**
	 * Check a collision.
	 * 
	 * @param coordX
	 * coordX
	 * @param coordY
	 * coordY
	 * @return charactercoords
	 */
	boolean checkCollision(int coordX, int coordY);
	
	/**
	 * Gets the diamonds.
	 * 
	 * @return diamond
	 */
	public int getDiamond();
	
	/**
	 * Gets the time left.
	 * 
	 * @return timeLeft
	 */
	public int getTimeLeft();
	
	/**
	 * Sets the time left.
	 * 
	 * @param timeLeft
	 * the time left
	 */
	public void setTimeLeft(int timeLeft);
	
	/**
	 * Gets the game over state.
	 * 
	 * @return gameOver
	 */
	public boolean getGameOver();
	
	/**
	 * Gets the game win state.
	 * 
	 * @return gameWin
	 */
	public boolean getGameWin();
	
	/**
	 * Gets the score.
	 * 
	 * @return Score
	 */
	public int getScore();
	
    /**
     * Gets the final score.
     * 
     * @return finalScore
     */
    public int getFinalScore();
    
    /**
     * Gets the final time.
     * 
     * @return finalTime
     */
    public int getFinalTime();
    
	/**
	 * Start the Timer of the level.
	 */
	void Timer();
	
    /**
     * Sets the score.
     * 
     * @param score
     * the score
     */
    public void setScore(int score);
    
	/**
	 * Gets the state of the diamond sprite.
	 * 
	 * @return isDiamondSprite
	 */
	public boolean isDiamondSprite();
	
	/**
	 * Sets the diamondSprite.
	 * 
	 * @param diamondSprite
	 * the diamondsprite
	 */
	public void setDiamondSprite(boolean diamondSprite);
	
	/**
	 * Gets the state of the hero (left) sprite.
	 * 
	 * @return isHeroLeft
	 */
	public boolean isHeroleft();
	
	/**
	 * Sets the hero left sprite.
	 * 
	 * @param heroleft
	 * the heroleft
	 */
	public void setHeroleft(boolean heroleft);
	
	/**
	 * Gets the state of the hero (right) sprite.
	 * 
	 * @return isHeroright
	 */
	public boolean isHeroright();
	
	/**
	 * Sets the state of the hero (right) sprite.
	 * 
	 * @param heroright
	 * the hero right
	 */
	public void setHeroright(boolean heroright);
	
	/**
	 * Gets the state of the hero (down) sprite.
	 * 
	 * @return isHerodown
	 */
	public boolean isHerodown();
	
	/**
	 * Sets the state of the hero (down) sprite.
	 * 
	 * @param herodown
	 * the hero down
	 */
	public void setHerodown(boolean herodown);
	
	/**
	 * Gets the state of the hero (up) sprite.
	 * 
	 * @return isHeroUp
	 */
	public boolean isHeroup();
	
	/**
	 * Sets the state of the hero (up) sprite.
	 * 
	 * @param heroup
	 * the hero up
	 */
	public void setHeroup(boolean heroup);
	
	/**
	 * Gets the level camera tab.
	 * 
	 * @return levelCamera
	 */
	public String[][] getLevelCamera();
	
	/**
	 * Sets the level camera tab.
	 * 
	 * @param levelCamera
	 * the level camera
	 */
	public void setLevelCamera(String[][] levelCamera);
	
	/**
	 * check interaction
	 * 
	 * @param coordX
	 * the coordx
	 * @param coordY
	 * the coordy
	 */
	public boolean checkInteraction(int coordX, int coordY);
	
	/**
	 * Gets the x coord of the Enemy.
	 * 
	 * @return coordXEnemy
	 */
	public int getCoordXEnemy();
	
	/**
	 * Sets the x coord of the Enemy.
	 * 
	 * @param coordX
	 * the coordX
	 */
	public void setCoordXEnemy(int coordX);
	
	/**
	 * Gets the y coord of the Enemy.
	 * 
	 * @return coordYEnemy
	 */
	public int getCoordYEnemy();
	
	/**
	 * Sets the y coord of the Enemy.
	 * 
	 * @param coordY
	 * the coordY
	 */
	public void setCoordYEnemy(int coordY);
	
	/**
	 * check collision boulder
	 * 
	 * @param coordX
	 * the coordX
	 * @param coordY
	 * the coordY
	 * @return
	 */
	public boolean checkCollisionBoulder(int coordX, int coordY);
	
	/**
	 * Sets the (left) state of the boulder.
	 * 
	 * @param boulderLeft
	 * the boulderleft
	 */
	public void setBoulderLeft(boolean b);
	
	/**
	 * Sets the (right) state of the boulder.
	 * 
	 * @param boulderRight
	 * the boulder right
	 */
	public void setBoulderRight(boolean b);
	
	/**
	 * Sets the coords of the Enemy.
	 * 
	 * @param coordX
	 * the coordX
	 * @param coordY
	 * the coordY
	 */
	public void setEnemyCoords(int coordX, int coordY);
	
	/**
	 * Gets the exit state.
	 * 
	 * @return isExit
	 */
	public boolean isExit();
	
	/**
	 * Sets the exit state.
	 * 
	 * @param exit
	 * the exit<
	 */
	public void setExit(boolean exit);
	
	/**
	 * Gets the levelNumber.
	 * 
	 * @return levelNumber
	 */
	public int getLevelNumber();
	
	/**
	 * Sets the levelNumber.
	 * 
	 * @param levelNumber
	 */
	public void setLevelNumber(int levelNumber);
	
	/**
	 * Gets the state of the exit door.
	 * 
	 * @return isReadyToLeave
	 */
	public boolean isReadyToLeave();
	
	/**
	 * Sets the state of the exit door.
	 * 
	 * @param readyToLeave
	 * the ready to leave
	 */
	public void setReadyToLeave(boolean readyToLeave);
	
	/**
	 * play a sound.
	 * 
	 * @param sound
	 * the sound
	 */
	public void playSound(File sound);
	
	/**
	 * Sets the number of diamonds.
	 * 
	 * @param diamond
	 * the diamond
	 */
	public void setDiamond(int diamond);
	
	/**
	 * Gets the (right) state of the boulder.
	 * 
	 * @return isBoulderRight
	 */
	public boolean isBoulderRight();
	
	/**
	 * Gets the (left) state of the boulder.
	 * 
	 * @return isBoulderLeft
	 */
	public boolean isBoulderLeft();
	
	/**
	 * Sets the final time.
	 * 
	 * @param finalTime
	 * the final time
	 */
	public void setFinalTime(int finalTime);
	
	/**
	 * Adjust the camera.
	 * 
	 * @param levelTab
	 * the level tab
	 */
	public String[][] levelCam(String[][] levelTab);
	
	/**
	 * Start the level.
	 */
	public void setStartLevel();
	
	/**
	 * Gets the state of the Enemy sprite.
	 * 
	 * @return isEnemySprite
	 */
	public boolean isEnemySprite();
	
	/**
	 * Sets the EnemySprite.
	 * 
	 * @param enemySprite
	 * the enemy spirte
	 */
	public void setEnemySprite(boolean enemySprite);
	
	/**
	 * Gets the choice.
	 * 
	 * @return choice
	 */
	public int getChoice();
	
	/**
	 * Gets the number.
	 * 
	 * @return nbr
	 */
	public int getNbr();
	
	/**
	 * Sets the number
	 * 
	 * @param nbr
	 * the number
	 */
	public void setNbr(int nbr);
	
	/**
	 * Gets the randomFour.
	 * 
	 * @return randomFour
	 */
	public int getRandomFour();
	
	/**
	 * Game Over.
	 */
	public void GameOver();
	/**
	 * Game win
	 */
	public void GameWin();
}