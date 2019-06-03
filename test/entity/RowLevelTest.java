package entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class RowLevelTest {

	@Test
	public void testRowLevelIntStringIntIntStringIntBoolean() {
		RowLevel actual = new RowLevel(1, "", 1, 1, "", 1, true);
		final int expected = 1;
		assertEquals(expected,actual.getBlocksId());
		
		final String expected2 = "";
		assertEquals(expected2, actual.getBlocksType());
		
		final int expected3 = 1;
		assertEquals(expected3, actual.getBlocksX());
		
		final int expected4 = 1;
		assertEquals(expected4, actual.getBlocksY());
		
		final String expected5 = "";
		assertEquals(expected5, actual.getBlocksDirection());
		
		final int expected6 = 1;
		assertEquals(expected6, actual.getLevelNumber());
		
		final boolean expected7 = false;
		assertEquals(expected7, actual.getLevelFinished());
	}

	@Test
	public void testRowLevelIntStringIntIntStringInt() {
		RowLevel actual = new RowLevel(1, "", 1, 1, "", 1);
		final int expected = 1;
		assertEquals(expected,actual.getBlocksId());
		
		final String expected2 = "";
		assertEquals(expected2, actual.getBlocksType());
		
		final int expected3 = 1;
		assertEquals(expected3, actual.getBlocksX());
		
		final int expected4 = 1;
		assertEquals(expected4, actual.getBlocksY());
		
		final String expected5 = "";
		assertEquals(expected5, actual.getBlocksDirection());
		
		final int expected6 = 1;
		assertEquals(expected6, actual.getLevelNumber());
	}

	@Test
	public void testRowLevel() {
		RowLevel actual = new RowLevel();
		final int expected = 0;
		assertEquals(expected,actual.getBlocksId());
		
		final String expected2 = "";
		assertEquals(expected2, actual.getBlocksType());
		
		final int expected3 = 0;
		assertEquals(expected3, actual.getBlocksX());
		
		final int expected4 = 0;
		assertEquals(expected4, actual.getBlocksY());
		
		final String expected5 = "";
		assertEquals(expected5, actual.getBlocksDirection());
		
		final int expected6 = 0;
		assertEquals(expected6, actual.getLevelNumber());
	}

	@Test
	public void testGetBlocksId() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksId(1);
		assertEquals(expected, actual.getBlocksId());
	}

	@Test
	public void testSetBlocksId() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksId(1);
		assertEquals(expected, actual.getBlocksId());
	}

	@Test
	public void testGetBlocksType() {
		RowLevel actual = new RowLevel();
		final String expected = "";
		actual.setBlocksType("");;
		assertEquals(expected, actual.getBlocksType());
	}

	@Test
	public void testSetBlocksType() {
		RowLevel actual = new RowLevel();
		final String expected = "";
		actual.setBlocksType("");;
		assertEquals(expected, actual.getBlocksType());
	}

	@Test
	public void testGetBlocksX() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksX(1);
		assertEquals(expected, actual.getBlocksX());
	}

	@Test
	public void testSetBlocksX() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksX(1);
		assertEquals(expected, actual.getBlocksX());
	}

	@Test
	public void testGetBlocksY() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksY(1);
		assertEquals(expected, actual.getBlocksY());
	}

	@Test
	public void testSetBlocksY() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setBlocksY(1);
		assertEquals(expected, actual.getBlocksY());
	}

	@Test
	public void testGetBlocksDirection() {
		RowLevel actual = new RowLevel();
		final String expected = "";
		actual.setBlocksDirection("");
		assertEquals(expected, actual.getBlocksDirection());
	}

	@Test
	public void testSetBlocksDirection() {
		RowLevel actual = new RowLevel();
		final String expected = "";
		actual.setBlocksDirection("");
		assertEquals(expected, actual.getBlocksDirection());
	}

	@Test
	public void testGetLevelNumber() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setLevelNumber(1);
		assertEquals(expected, actual.getLevelNumber());
	}

	@Test
	public void testSetLevelNumber() {
		RowLevel actual = new RowLevel();
		final int expected = 1;
		actual.setLevelNumber(1);
		assertEquals(expected, actual.getLevelNumber());
	}

	@Test
	public void testGetLevelFinished() {
		RowLevel actual = new RowLevel();
		final boolean expected = true;
		actual.setLevelFinished(true);
		assertEquals(expected, actual.getLevelFinished());
	}

	@Test
	public void testSetLevelFinished() {
		RowLevel actual = new RowLevel();
		final boolean expected = true;
		actual.setLevelFinished(true);
		assertEquals(expected, actual.getLevelFinished());
	}

}
