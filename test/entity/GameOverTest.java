package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GameOverTest {

	@Test
	public void testLoadImageInt() {
		GameOver actual = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, GameOver.img);
		
		GameOver actual2 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, GameOver.img);
		
		GameOver actual3 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, GameOver.img);
		
		GameOver actual4 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, GameOver.img);
		
		GameOver actual5 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, GameOver.img);
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\GameOver.png";
		String i2 = "";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		GameOver actual = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected = actual.loadImage(1, i);
		assertEquals(expected, GameOver.img);
		
		GameOver actual2 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected2 = actual2.loadImage(2, i2);
		assertEquals(expected2, GameOver.img);
		
		GameOver actual3 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected3 = actual3.loadImage(3, i3);
		assertEquals(expected3, GameOver.img);
		
		GameOver actual4 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected4 = actual4.loadImage(4, i4);
		assertEquals(expected4, GameOver.img);
		
		GameOver actual5 = new GameOver("GameOver", true, 0, 0, false);
		final BufferedImage expected5 = actual5.loadImage(5, i5);
		assertEquals(expected5, GameOver.img);
	}

	@Test
	public void testGameOverStringBooleanIntIntBoolean() {
		GameOver actual = new GameOver("GameOver", true, 0, 0, false);
		final String expected = "Game";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = false;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
		
		final boolean expected5 = false;
		assertEquals(expected5, GameOver.gameState);
	}

	@Test
	public void testGameOverStringBooleanIntIntBufferedImageBoolean() throws IOException {
		String i = "Sprites\\enemy.png";
		BufferedImage img = ImageIO.read(new File("Sprites\\enemy.png"));

		
		GameOver actual = new GameOver("GameOver", true, 0, 0, img, false);
		final String expected = "GameOver";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, GameOver.img);
	}

	@Test
	public void testGameOver() throws IOException {
		GameOver actual = new GameOver();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "GameOver";
		
		final String expected = "GameOver";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
