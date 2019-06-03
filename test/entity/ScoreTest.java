package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void testLoadImageInt() {
		Score actual = new Score("Score", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, Score.img);
	}

	@Test
	public void testSetStringCode() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final String expected = "Score";
		actual.setStringCode("Score");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		Score actual = new Score("Score", true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testScoreStringBooleanIntInt() {
		Score actual = new Score("Score", true, 0, 0);
		final String expected = "Score";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = false;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testScoreStringBooleanIntIntBufferedImage() throws IOException {
		String i = "Sprites\\Score.png";
		BufferedImage img = ImageIO.read(new File("Sprites\\score.png"));
		
		Score actual = new Score("Score", true, 0, 0, img);
		final String expected = "Score";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, Score.img);
	}

	@Test
	public void testScore() throws IOException {
		Score actual = new Score();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Score";
		
		final String expected = "Score";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
