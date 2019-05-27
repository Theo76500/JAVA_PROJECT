package contract;

import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;


/**
 * The Interface IModel.
 *
 * @author LANGLOIS Theo
 */
public interface IModel {

	boolean loadLevel(int id);
	ILevel getLevel();
	
	IElement getElement(int x, int y);
	IElement[][] getElements();
	
	boolean saveLevel();
	void flush();
	
	
	

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	boolean loadAllLevels();
	
	boolean loadNextLevel();
	
	ArrayList<Integer> getLevelsId();
}
