package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class DiamondsLeftTest {

	@Test
	public void testLoadImageInt() {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, DiamondsLeft.img);
		
		DiamondsLeft actual2 = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, DiamondsLeft.img);
		
		DiamondsLeft actual3 = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, DiamondsLeft.img);
		
		DiamondsLeft actual4 = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, DiamondsLeft.img);
		
		DiamondsLeft actual5 = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, DiamondsLeft.img);
	}


	@Test
	public void testSetStringCode() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final String expected = "DiamondsLeft";
		actual.setStringCode("DiamondsLeft");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}


	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamondsleft1.png"));
		assertEquals(expected, DiamondsLeft.img);
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\diamondsleft1.png"));
		assertEquals(expected, DiamondsLeft.img);
	}

	@Test
	public void testDiamondsLeftStringBooleanIntInt() {
		DiamondsLeft actual = new DiamondsLeft("DiamondsLeft", true, 0, 0);
		final String expected = "DiamondsLeft";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testDiamondsLeft() throws IOException {
		DiamondsLeft actual = new DiamondsLeft();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "DiamondsLeft";
		
		final String expected = "DiamondsLeft";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
