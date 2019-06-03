package entity;

import java.util.ArrayList;

/**
 * The lvel class
 * @author PAIN Valentin
 */
public class Level {

	/**
	 * The level
	 */
	private static ArrayList<RowLevel> level = new ArrayList<RowLevel>();
	
	/**
	 * Gets the level
	 * @return level
	 */
	public static ArrayList<RowLevel> getLevel() {
		return Level.level;
	}

	/**
	 * Sets the level
	 * @param level
	 * the level
	 */
	public static void setLevel(ArrayList<RowLevel> level) {
		Level.level = level;
	}
	
}
