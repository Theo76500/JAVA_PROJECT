package view;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.Test;

import contract.ControllerOrder;

public class ViewTest {

	@Test
	public void testKeyCodeToControllerOrder() {
		final ControllerOrder expected = ControllerOrder.LEFT;
		assertEquals(expected, View.keyCodeToControllerOrder(KeyEvent.VK_LEFT));
		
		final ControllerOrder expected2 = ControllerOrder.RIGHT;
		assertEquals(expected2, View.keyCodeToControllerOrder(KeyEvent.VK_RIGHT));
		
		final ControllerOrder expected3 = ControllerOrder.UP;
		assertEquals(expected3, View.keyCodeToControllerOrder(KeyEvent.VK_UP));
		
		final ControllerOrder expected4 = ControllerOrder.DOWN;
		assertEquals(expected4, View.keyCodeToControllerOrder(KeyEvent.VK_DOWN));
	}

}
