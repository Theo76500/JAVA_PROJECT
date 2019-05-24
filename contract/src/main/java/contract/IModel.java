package contract;

import java.util.Observable;


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
