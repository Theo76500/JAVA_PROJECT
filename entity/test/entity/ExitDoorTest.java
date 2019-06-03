package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class ExitDoorTest {

	@Test
	public void testLoadImageInt() {
		ExitDoor actual = new ExitDoor("ExitDoor", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, ExitDoor.getImg());
		
		ExitDoor actual2 = new ExitDoor("ExitDoor", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, ExitDoor.getImg());
		
		ExitDoor actual3 = new ExitDoor("ExitDoor", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, ExitDoor.getImg());
		
		ExitDoor actual4 = new ExitDoor("ExitDoor", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, ExitDoor.getImg());
		
		ExitDoor actual5 = new ExitDoor("ExitDoor", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, ExitDoor.getImg());
	}


	@Test
	public void testSetStringCode() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final String expected = "ExitDoor";
		actual.setStringCode("ExitDoor");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		ExitDoor actual = new ExitDoor("ExitDoor",true, 0, 0);
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\ExitDoor1.png"));
		assertEquals(expected, ExitDoor.getImg());
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\ExitDoor1.png"));
		assertEquals(expected, ExitDoor.getImg());
	}

	@Test
	public void testExitDoorStringBooleanIntInt() {
		ExitDoor actual = new ExitDoor("ExitDoor", true, 0, 0);
		final String expected = "ExitDoor";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testExitDoor() throws IOException {
		ExitDoor actual = new ExitDoor();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "ExitDoor";
		
		final String expected = "ExitDoor";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
