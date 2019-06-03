package view;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import org.junit.Test;

import contract.IModel;
import model.Model;

public class ViewFrameTest {

	@Test
	public void BuildViewFrame(){
		Model model = new Model();
		//IModel modelExp = model;
		IModel iModel = model;
		
		ViewFrame actual = new ViewFrame(iModel);
		actual.buildViewFrame(model);
		
		final IModel expected = iModel;
		assertEquals(expected, actual.getModel());
		
		final String expected2 = "Boulder Dash";
		assertEquals(expected2, actual.getTitle());
		
		final boolean expected3 = false;
		assertEquals(expected3, actual.isResizable());
		
		final Dimension expected4 = new Dimension(700, 750);		
		assertEquals(expected4, actual.getSize());
	}

}
