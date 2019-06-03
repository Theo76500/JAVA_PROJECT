package entity;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class BoulderTest {

	@Test
	public void testLoadImageInt() {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, Boulder.getImg());
		
		Boulder actual2 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, Boulder.getImg());
		
		Boulder actual3 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, Boulder.getImg());
		
		Boulder actual4 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, Boulder.getImg());
		
		Boulder actual5 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, Boulder.getImg());
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\Boulder.png";
		String i2 = "";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1, i);
		assertEquals(expected, Boulder.getImg());
		
		Boulder actual2 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2, i2);
		assertEquals(expected2, Boulder.getImg());
		
		Boulder actual3 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3, i3);
		assertEquals(expected3, Boulder.getImg());
		
		Boulder actual4 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4, i4);
		assertEquals(expected4, Boulder.getImg());
		
		Boulder actual5 = new Boulder("Boulder", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5, i5);
		assertEquals(expected5, Boulder.getImg());
	}

	@Test
	public void testSetStringCode() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final String expected = "Boulder";
		actual.setStringCode("Boulder");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\boulder.png"));
		assertEquals(expected, Boulder.getImg());
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\boulder.png"));
		assertEquals(expected, Boulder.getImg());
	}

	@Test
	public void testBoulderStringBooleanIntInt() {
		Boulder actual = new Boulder("Boulder", true, 0, 0);
		final String expected = "Boulder";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =000;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testBoulderStringBooleanIntIntBufferedImage() throws IOException {
		String i = "Sprites\\boulder.png";
		BufferedImage img = ImageIO.read(new File("Sprites\\boulder.png"));
		
		Boulder actual = new Boulder("Boulder", true, 0, 0, img);
		final String expected = "Boulder";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
		
		final BufferedImage expected5 = ImageIO.read(new File(i));
		assertEquals(expected5, Boulder.getImg());

	}

	@Test
	public void testBoulder() throws IOException {
		Boulder actual = new Boulder();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Boulder";
		
		final String expected = "Boulder";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
