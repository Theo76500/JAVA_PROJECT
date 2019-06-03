package entity;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class EnemyTest {

	@Test
	public void testLoadImageInt() {
		Enemy actual = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, Enemy.getImg());
		
		Enemy actual2 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, Enemy.getImg());
		
		Enemy actual3 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, Enemy.getImg());
		
		Enemy actual4 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, Enemy.getImg());
		
		Enemy actual5 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, Enemy.getImg());
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\enemy.png";
		String i2 = "Sprites\\enemy2.png";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		Enemy actual = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1, i);
		assertEquals(expected, Enemy.getImg());
		
		Enemy actual2 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2, i2);
		assertEquals(expected2, Enemy.getImg());
		
		Enemy actual3 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3, i3);
		assertEquals(expected3, Enemy.getImg());
		
		Enemy actual4 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4, i4);
		assertEquals(expected4, Enemy.getImg());
		
		Enemy actual5 = new Enemy("Enemy", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5, i5);
		assertEquals(expected5, Enemy.getImg());
	}

	@Test
	public void testSetStringCode() {
		Enemy actual = new Enemy();
		final String expected = "Enemy";
		actual.setStringCode("Enemy");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() {
		Enemy actual = new Enemy();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() {
		Enemy actual = new Enemy();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() {
		Enemy actual = new Enemy();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() {
		Enemy actual = new Enemy();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() {
		Enemy actual = new Enemy();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() {
		Enemy actual = new Enemy();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\enemy.png"));
		assertEquals(expected, Enemy.img2);
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\enemy.png"));
		assertEquals(expected, Enemy.img2);
	}

	@Test
	public void testEnemyStringBooleanIntInt() {
		Enemy actual = new Enemy("Enemy", true, 0, 0);
		final String expected = "Enemy";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =7;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =14;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testEnemyStringBooleanIntIntBufferedImageBufferedImage() throws IOException {
		String i = "Sprites\\enemy.png";
		String i2 = "Sprites\\enemy2.png";
		BufferedImage img = ImageIO.read(new File("Sprites\\enemy.png"));
		BufferedImage img2 = ImageIO.read(new File("Sprites\\enemy2.png"));
		
		Enemy actual = new Enemy("Enemy", true, 0, 0, img, img2);
		final String expected = "Enemy";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, Enemy.getImg());
		
		final BufferedImage expected6 = ImageIO.read(new File(i2));
		assertEquals(expected6, Enemy.getImg());
	}

	@Test
	public void testEnemy() {
		Enemy actual = new Enemy();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Enemy";
		
		final String expected = "Enemy";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
