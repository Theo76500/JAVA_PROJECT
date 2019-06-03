package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class DirtAfterHeroTest {

	@Test
	public void testLoadImageInt() {
		Dirt actual = new Dirt("Dirt", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, Dirt.getImg());
		
		Dirt actual2 = new Dirt("Dirt", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, Dirt.getImg());
		
		Dirt actual3 = new Dirt("Dirt", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, Dirt.getImg());
		
		Dirt actual4 = new Dirt("Dirt", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, Dirt.getImg());
		
		Dirt actual5 = new Dirt("Dirt", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, Dirt.getImg());
	}


	@Test
	public void testSetStringCode() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final String expected = "Dirt";
		actual.setStringCode("Dirt");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		Dirt actual = new Dirt("Dirt",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\dirtafterhero1.png"));
		assertEquals(expected, Dirt.getImg());
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\dirtafterhero1.png"));
		assertEquals(expected, Dirt.getImg());
	}

	@Test
	public void testDirtStringBooleanIntInt() {
		Dirt actual = new Dirt("Dirt", true, 0, 0);
		final String expected = "Dirt";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testDirt() throws IOException {
		Dirt actual = new Dirt();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "Dirt";
		
		final String expected = "Dirt";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
