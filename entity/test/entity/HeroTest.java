package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class HeroTest {

	@Test
	public void testLoadImageInt() throws IOException {
		BufferedImage img = ImageIO.read(new File("Sprites\\hero.png"));
		BufferedImage img2 = ImageIO.read(new File("Sprites\\heroright1.png"));
		BufferedImage img3 = ImageIO.read(new File("Sprites\\heroleft1.png"));
		BufferedImage img4 = ImageIO.read(new File("Sprites\\herodown1.png"));
		BufferedImage img5 = ImageIO.read(new File("Sprites\\heroup1.png"));
		BufferedImage img6 = ImageIO.read(new File("Sprites\\heroright2.png"));
		BufferedImage img7 = ImageIO.read(new File("Sprites\\heroleft2.png"));
		BufferedImage img8 = ImageIO.read(new File("Sprites\\herodown2.png"));
		BufferedImage img9 = ImageIO.read(new File("Sprites\\heroup1.png"));
		
		Hero actual = new Hero("Hero", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, img);
		
		Hero actual2 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, img2);
		
		Hero actual3 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, img3);
		
		Hero actual4 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, img4);
		
		Hero actual5 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, img5);
		
		Hero actual6 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected6 = actual6.loadImage(6);
		assertEquals(expected6, img6);
		
		Hero actual7 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected7 = actual7.loadImage(7);
		assertEquals(expected7, img7);
		
		Hero actual8 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected8 = actual8.loadImage(8);
		assertEquals(expected8, img8);
		
		Hero actual9 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected9 = actual9.loadImage(9);
		assertEquals(expected9, img9);
	}

	@Test
	public void testLoadImageIntString() throws IOException {
		String i = "Sprites\\hero.png";
		String i2 = "Sprites\\heroright1.png";
		String i3 = "Sprites\\heroleft1.png";
		String i4 = "Sprites\\herodown1.png";
		String i5 = "Sprites\\heroup1.png";
		String i6 = "Sprites\\heroright2.png";
		String i7 = "Sprites\\heroleft2.png";
		String i8 = "Sprites\\herodown2.png";
		String i9 = "Sprites\\heroup1.png";
		
		BufferedImage img = ImageIO.read(new File("Sprites\\hero.png"));
		BufferedImage img2 = ImageIO.read(new File("Sprites\\heroright1.png"));
		BufferedImage img3 = ImageIO.read(new File("Sprites\\heroleft1.png"));
		BufferedImage img4 = ImageIO.read(new File("Sprites\\herodown1.png"));
		BufferedImage img5 = ImageIO.read(new File("Sprites\\heroup1.png"));
		BufferedImage img6 = ImageIO.read(new File("Sprites\\heroright2.png"));
		BufferedImage img7 = ImageIO.read(new File("Sprites\\heroleft2.png"));
		BufferedImage img8 = ImageIO.read(new File("Sprites\\herodown2.png"));
		BufferedImage img9 = ImageIO.read(new File("Sprites\\heroup1.png"));
		
		Hero actual = new Hero("Hero", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, img);
		
		Hero actual2 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, img2);
		
		Hero actual3 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, img3);
		
		Hero actual4 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, img4);
		
		Hero actual5 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, img5);
		
		Hero actual6 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected6 = actual6.loadImage(6);
		assertEquals(expected6, img6);
		
		Hero actual7 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected7 = actual7.loadImage(7);
		assertEquals(expected7, img7);
		
		Hero actual8 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected8 = actual8.loadImage(8);
		assertEquals(expected8, img8);
		
		Hero actual9 = new Hero("Hero", true, 0, 0);
		final BufferedImage expected9 = actual9.loadImage(9);
		assertEquals(expected9, img9);
	}

	@Test
	public void testSetStringCode() {
		Hero actual = new Hero();
		final String expected = "Hero";
		actual.setStringCode("Hero");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() {
		Hero actual = new Hero();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() {
		Hero actual = new Hero();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() {
		Hero actual = new Hero();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() {
		Hero actual = new Hero();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() {
		Hero actual = new Hero();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() {
		Hero actual = new Hero();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testHeroStringBooleanIntInt() {
		Hero actual = new Hero("Hero", true, 0, 0);
		final String expected = "Hero";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =7;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =7;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testHeroStringBooleanIntIntBufferedImageBufferedImageBufferedImageBufferedImageBufferedImageBufferedImageBufferedImageBufferedImageBufferedImage() throws IOException {
		String i = "Sprites\\hero.png";
		String i2 = "Sprites\\heroright1.png";
		String i3 = "Sprites\\heroleft1.png";
		String i4 = "Sprites\\herodown1.png";
		String i5 = "Sprites\\heroup1.png";
		String i6 = "Sprites\\heroright2.png";
		String i7 = "Sprites\\heroleft2.png";
		String i8 = "Sprites\\herodown2.png";
		String i9 = "Sprites\\heroup1.png";
		
		BufferedImage img = ImageIO.read(new File("Sprites\\hero.png"));
		BufferedImage img2 = ImageIO.read(new File("Sprites\\heroright1.png"));
		BufferedImage img3 = ImageIO.read(new File("Sprites\\heroleft1.png"));
		BufferedImage img4 = ImageIO.read(new File("Sprites\\herodown1.png"));
		BufferedImage img5 = ImageIO.read(new File("Sprites\\heroup1.png"));
		BufferedImage img6 = ImageIO.read(new File("Sprites\\heroright2.png"));
		BufferedImage img7 = ImageIO.read(new File("Sprites\\heroleft2.png"));
		BufferedImage img8 = ImageIO.read(new File("Sprites\\herodown2.png"));
		BufferedImage img9 = ImageIO.read(new File("Sprites\\heroup1.png"));
		
		Hero actual = new Hero("Hero", true, 0, 0);
		final String expected = "Hero";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, img);
		
		final BufferedImage expected6 = ImageIO.read(new File(i2));
		assertEquals(expected6, img2);
		
		final BufferedImage expected7 = ImageIO.read(new File(i3));
		assertEquals(expected7, img3);
		
		final BufferedImage expected8 = ImageIO.read(new File(i4));
		assertEquals(expected8, img4);
		
		final BufferedImage expected9 = ImageIO.read(new File(i5));
		assertEquals(expected9, img5);
		
		final BufferedImage expected10 = ImageIO.read(new File(i6));
		assertEquals(expected10, img6);
		
		final BufferedImage expected11 = ImageIO.read(new File(i7));
		assertEquals(expected11, img7);
		
		final BufferedImage expected12 = ImageIO.read(new File(i8));
		assertEquals(expected12, img8);
		
		final BufferedImage expected13 = ImageIO.read(new File(i9));
		assertEquals(expected13, img9);
	}

	@Test
	public void testHero() {
		Hero actual = new Hero();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Hero";
		
		final String expected = "Hero";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
