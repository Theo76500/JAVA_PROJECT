package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class DiamondTest {

	@Test
	public void testLoadImageInt() {
		Diamond actual = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, Diamond.img);
		
		Diamond actual2 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, Diamond.img2);
		
		Diamond actual3 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, Diamond.img);
		
		Diamond actual4 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, Diamond.img);
		
		Diamond actual5 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, Diamond.img);
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\diamond.png";
		String i2 = "Sprites\\diamond2.png";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		Diamond actual = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1, i);
		assertEquals(expected, Diamond.img);
		
		Diamond actual2 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2, i2);
		assertEquals(expected2, Diamond.img2);
		
		Diamond actual3 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3, i3);
		assertEquals(expected3, Diamond.img);
		
		Diamond actual4 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4, i4);
		assertEquals(expected4, Diamond.img);
		
		Diamond actual5 = new Diamond("Diamond", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5, i5);
		assertEquals(expected5, Diamond.img);
	}

	@Test
	public void testSetStringCode() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final String expected = "Diamond";
		actual.setStringCode("Diamond");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		Diamond actual = new Diamond("Diamond",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg2() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamond2.png"));
		assertEquals(expected, Diamond.img2);
	}

	@Test
	public void testSetImg2() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamond2.png"));
		assertEquals(expected, Diamond.img2);
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamond1.png"));
		assertEquals(expected, Diamond.img);
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamond1.png"));
		assertEquals(expected, Diamond.img);
	}

	@Test
	public void testDiamondStringBooleanIntInt() {
		Diamond actual = new Diamond("Diamond", true, 0, 0);
		final String expected = "Diamond";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testDiamond() throws IOException {
		Diamond actual = new Diamond();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Diamond";
		
		final String expected = "Diamond";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
