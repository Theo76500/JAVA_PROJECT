package contract;

import java.util.Observable;
import java.util.logging.Level;


/**
 * The Interface IModel.
 *
 * @author LANGLOIS Theo
 */
public interface IModel {

	boolean loadLevel(int id);
	Level getLevel();
	
	boolean saveLevel();
	void flush();
	

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
