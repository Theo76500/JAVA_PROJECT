package entity;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LevelTest {

	@Test
	public void testGetLevel() {
		ArrayList<RowLevel> level = new ArrayList<RowLevel>();
		Level.setLevel(level);
		final ArrayList<RowLevel> expected = level;
		assertEquals(expected,Level.getLevel());
	}

	@Test
	public void testSetLevel() {
		ArrayList<RowLevel> level = new ArrayList<RowLevel>();
		Level.setLevel(level);
		final ArrayList<RowLevel> expected = level;
		assertEquals(expected,Level.getLevel());
	}

}
