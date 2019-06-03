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
	public void setLevel(Level level);
	void loadLevel(int lvl);
	public String[][] getLevelTab();
	public void setLevelTab(String[][] levelTab);
	public String getDirection();
	public void setDirection(String direction);
	public int getCoordXHero();
	public void setCoordXHero(int coordX);
	public int getCoordYHero();
	public void setCoordYHero(int coordY);
	void setCharacterCoords(int coordX, int coordY);
	boolean checkCollision(int coordX, int coordY);
	public int getDiamond();
	public int getTimeLeft();
	public void setTimeLeft(int timeLeft);
	public boolean getGameOver();
	public boolean getGameWin();
	public int getScore();
    public int getFinalScore();
    public int getFinalTime();
	void Timer();
    public void setScore(int score);
	public boolean isDiamondSprite();
	public void setDiamondSprite(boolean diamondSprite);
	public boolean isHeroleft();
	public void setHeroleft(boolean heroleft);
	public boolean isHeroright();
	public void setHeroright(boolean heroright);
	public boolean isHerodown();
	public void setHerodown(boolean herodown);
	public boolean isHeroup();
	public void setHeroup(boolean heroup);
	public String[][] getLevelCamera();
	public void setLevelCamera(String[][] levelCamera);
	public boolean checkInteraction(int coordX, int coordY);
	public int getCoordXEnemy();
	public void setCoordXEnemy(int coordX);
	public int getCoordYEnemy();
	public void setCoordYEnemy(int coordY);
	public boolean checkCollisionBoulder(int coordX, int coordY);
	public void setBoulderLeft(boolean b);
	public void setBoulderRight(boolean b);
	public void setEnemyCoords(int coordX, int coordY);
	public boolean isExit();
	public void setExit(boolean exit);
	public int getLevelNumber();
	public void setLevelNumber(int levelNumber);
	public boolean isReadyToLeave();
	public void setReadyToLeave(boolean readyToLeave);
	public void playSound(File sound);
	public void setDiamond(int diamond);
	public boolean isBoulderRight();
	public boolean isBoulderLeft();
	public void setFinalTime(int finalTime);
	public String[][] levelCam(String[][] levelTab);
	public void setStartLevel();
	public boolean isEnemySprite();
	public void setEnemySprite(boolean enemySprite);
	public int getChoice();
	public int getNbr();
	public void setNbr(int nbr);
	public int getRandomFour();
	public void GameOver();
	public void GameWin();
}
