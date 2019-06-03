package entity;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class BorderBlockTest {


	@Test
	public void testLoadImageInt() {
		BorderBlock actual = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1);
		assertEquals(expected, BorderBlock.getImg());
		
		BorderBlock actual2 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2);
		assertEquals(expected2, BorderBlock.getImg());
		
		BorderBlock actual3 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3);
		assertEquals(expected3, BorderBlock.getImg());
		
		BorderBlock actual4 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4);
		assertEquals(expected4, BorderBlock.getImg());
		
		BorderBlock actual5 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5);
		assertEquals(expected5, BorderBlock.getImg());
	}

	@Test
	public void testLoadImageIntString() {
		String i = "Sprites\\BorderBlock.png";
		String i2 = "Sprites\\BorderBlock2.png";
		String i3 = "";
		String i4 = "";
		String i5 = "";
		
		BorderBlock actual = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected = actual.loadImage(1, i);
		assertEquals(expected, BorderBlock.getImg());
		
		BorderBlock actual2 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected2 = actual2.loadImage(2, i2);
		assertEquals(expected2, BorderBlock.getImg());
		
		BorderBlock actual3 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected3 = actual3.loadImage(3, i3);
		assertEquals(expected3, BorderBlock.getImg());
		
		BorderBlock actual4 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected4 = actual4.loadImage(4, i4);
		assertEquals(expected4, BorderBlock.getImg());
		
		BorderBlock actual5 = new BorderBlock("BorderBlock", true, 0, 0);
		final BufferedImage expected5 = actual5.loadImage(5, i5);
		assertEquals(expected5, BorderBlock.getImg());
	}

	@Test
	public void testSetStringCode() throws IOException {
		BorderBlock actual = new BorderBlock();
		final String expected = "BorderBlock";
		actual.setStringCode("BorderBlock");
		assertEquals(expected, actual.stringCode);	
	}

	@Test
	public void testGetCoordX() throws IOException {
		BorderBlock actual = new BorderBlock();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testSetCoordX() throws IOException {
		BorderBlock actual = new BorderBlock();
		final int expected = 1;
		actual.setCoordX(1);
		assertEquals(expected, actual.getCoordX());	
	}

	@Test
	public void testGetCoordY() throws IOException {
		BorderBlock actual = new BorderBlock();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testSetCoordY() throws IOException {
		BorderBlock actual = new BorderBlock();
		final int expected = 1;
		actual.setCoordY(1);
		assertEquals(expected, actual.getCoordY());
	}

	@Test
	public void testGetMove() throws IOException {
		BorderBlock actual = new BorderBlock();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testSetMove() throws IOException {
		BorderBlock actual = new BorderBlock();
		final boolean expected = true;
		actual.setMove(true);
		assertEquals(expected, actual.getMove());
	}

	@Test
	public void testGetImg3() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock3.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testSetImg3() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock3.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}	

	@Test
	public void testGetImg4() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock4.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testSetImg4() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock4.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testGetImg5() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock4.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testSetImg5() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock4.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testGetImg2() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock2.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testSetImg2() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock2.png"));
		assertEquals(expected, BorderBlock.getImg2());
	}

	@Test
	public void testGetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock1.png"));
		assertEquals(expected, BorderBlock.getImg());
	}

	@Test
	public void testSetImg() throws IOException {
		final BufferedImage expected = ImageIO.read(new File("Sprites\\borderblock1.png"));
		assertEquals(expected, BorderBlock.getImg());
	}

	@Test
	public void testBorderBlockStringBooleanIntInt() {
		BorderBlock actual = new BorderBlock("BorderBlock", true, 0, 0);
		final String expected = "BorderBlock";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 =0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 =0;
		assertEquals(expected4, actual.coordY);
	}

	@Test
	public void testBorderBlock() throws IOException {
		BorderBlock actual = new BorderBlock();
		actual.coordX = 0;
		actual.coordY = 0;
		actual.move = true;
		actual.stringCode = "BorderBlock";
		
		final String expected = "BorderBlock";
		assertEquals(expected,actual.stringCode);
		
		final boolean expected2 = true;
		assertEquals(expected2, actual.move);
		
		final int expected3 = 0;
		assertEquals(expected3, actual.coordX);
		
		final int expected4 = 0;
		assertEquals(expected4, actual.coordY);
	}

}
