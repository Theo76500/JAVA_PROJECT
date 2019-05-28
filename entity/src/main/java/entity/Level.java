package entity;

import java.util.ArrayList;

public class Level {

	private static ArrayList<RowLevel> level = new ArrayList<RowLevel>();
	

	public static ArrayList<RowLevel> getLevel() {
		return Level.level;
	}

	public static void setLevel(ArrayList<RowLevel> level) {
		Level.level = level;
	}
	
}
