package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GameWinTest {

	@Test
	public void testLoadImageInt() {
		GameWin actual = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, GameWin.img);
		
		GameWin actual2 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, GameWin.img);
		
		GameWin actual3 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, GameWin.img);
		
		GameWin actual4 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, GameWin.img);
		
		GameWin actual5 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, GameWin.img);
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\GameWin.png";
		String i2 = "";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		GameWin actual = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, GameWin.img);
		
		GameWin actual2 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, GameWin.img);
		
		GameWin actual3 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, GameWin.img);
		
		GameWin actual4 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, GameWin.img);
		
		GameWin actual5 = new GameWin("GameWin", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, GameWin.img);
	}

	@Test
	public void testGameWinStringBooleanIntIntBoolean() {
		GameWin actual = new GameWin("GameWin", true, 0, 0);
		final String expected = "GameWin";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = false;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
		
		final boolean expected5 = false;
		assertEquals(expected5, GameWin.gameState);
	}

	@Test
	public void testGameWinStringBooleanIntIntBufferedImageBoolean() throws IOException {
		String i = "Sprites\\enemy.png";
		BufferedImage img = ImageIO.read(new File("Sprites\\enemy.png"));

		
		GameWin actual = new GameWin("GameWin", true, 0, 0);
		final String expected = "GameWin";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, GameWin.img);
	}

	@Test
	public void testGameWin() throws IOException {
		GameWin actual = new GameWin();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "GameWin";
		
		final String expected = "GameWin";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}


}
