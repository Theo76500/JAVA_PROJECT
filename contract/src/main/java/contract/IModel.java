package contract;

import java.util.Observable;

import entity.Level;
import entity.RowLevel;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	public Level getLevel();

	public void setLevel(Level level);

	void loadLevel();

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
	
	String[][] levelBehavior(String[][] levelTab);


	public int getDiamond();

	public int getTimeLeft();

	public boolean getGameOver();

	public boolean getGameWin();

	public void setCharacterCoords(int coordX, int coordY);

	public int getScore();

    public int getFinalScore();

    public int getFinalTime();
}
