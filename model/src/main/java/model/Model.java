package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;

import contract.*;
import model.database.DBConnection;

/**
 * The Class Model.
 *
 * @author LANGLOIS Theo
 */
public final class Model extends Observable implements IModel {

	/** The level. */
	private Level level;

	/** The main character. */
	private Hero hero;
	
	/**
	 * The IDs of the levels
	 */
	private ArrayList<Integer> levelsId;

	/** Instantiates a new model. */
	public Model() {
		this.hero = new Hero(1,1);
	}
	

	//public HelloWorld getHelloWorld() {
	//	return this.helloWorld;
	//}


	//private void setHelloWorld(final HelloWorld helloWorld) {
	//	this.helloWorld = helloWorld;
	//	this.setChanged();
	//	this.notifyObservers();
	//}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	
	public boolean loadLevel(Integer Id) {
		return true;
	}
	
	public boolean saveLevel(){
		return true;
	}
	
	public Level getLevel(){
		
	}
	
	public void flush()
	{
		
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
}
