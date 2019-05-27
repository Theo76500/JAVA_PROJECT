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
	
	/**
	 * Gets the first level.
	 *
	 * @return the level1 entity
	 */
	Level getLevel1();
	
	/**
	 * Gets the second level.
	 *
	 * @return the level2 entity
	 */
	Level getLevel2();
	
	/**
	 * Gets the third level.
	 *
	 * @return the level3 entity
	 */
	Level getLevel3();
	
	/**
	 * Gets the fourth level.
	 *
	 * @return the level4 entity
	 */
	Level getLevel4();
	
	/**
	 * Gets the fifth level.
	 *
	 * @return the level5 entity
	 */
	Level getLevel5();

	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */
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
	
	void SetCharacterCoords(int coord);

	public int getDiamond();

	public int getTimeLeft();
}
