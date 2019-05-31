package contract;

import entity.Level;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

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
	
	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	String[][] levelBehavior(String[][] levelTab, int coordX, int coordY);
	
	void setCharacterCoords(int coordX, int coordY);
	
	boolean checkCollision(int coordX, int coordY);
	
	public int getDiamond();

	public int getTimeLeft();

	public boolean getGameOver();

	public boolean getGameWin();

	public int getScore();

    public int getFinalScore();

    public int getFinalTime();
    
    public String[][] levelCamera(String[][] levelTab);

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
	
	public String[][] getLevelCamera();

	public void setLevelCamera(String[][] levelCamera);
	
	public void setStartLevel();
	
	public boolean checkInteraction(int coordX, int coordY);
	
	public int getCoordXEnemy();
	public void setCoordXEnemy(int coordX);
	
	public int getCoordYEnemy();
	
	public void setCoordYEnemy(int coordY);
	
	public boolean checkCollisionBoulder(int coordX, int coordY);

	public void setBoulderLeft(boolean b);

	public void setBoulderRight(boolean b);
}
