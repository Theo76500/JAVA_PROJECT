package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;

import contract.*;
import entity.Player;
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
	private Player player;
	
	/**
	 * The IDs of the levels
	 */
	private ArrayList<Integer> levelsId;

	/** Instantiates a new model. */
	public Model() {
		this.player = new Player();
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
