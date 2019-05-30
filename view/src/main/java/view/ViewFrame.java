package view;

import contract.IController;
import contract.IModel;
import controller.Controller;
import entity.Level;
import entity.RowLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener, ActionListener{

	/** MENU */

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Map");
	private JMenuItem map1 = new JMenuItem("MAP 1");
	private JMenuItem map2 = new JMenuItem("MAP 2");
	private JMenuItem map3 = new JMenuItem("MAP 3");
	private JMenuItem map4 = new JMenuItem("MAP 4");
	private JMenuItem map5 = new JMenuItem("MAP 5");

	/** The model. */
	private IModel model;

	/** The controller. */
	private IController controller;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -697358409737458175L;
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);	
		this.setTitle("Boulder Dash");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setContentPane(new ViewPanel(this));
		this.setSize(700 + this.getInsets().left + this.getInsets().right, 750 + this.getInsets().top + this.getInsets().bottom);
		this.setLocationRelativeTo(null);

		menuBar.add(menu1);

		menu1.add(map1);
		map1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.level = 1;
				model.loadLevel(1);
				printLevel();
			}
		});

		menu1.add(map2);
		map2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.level = 2;
				model.loadLevel(2);
				printLevel();
			}
		});

		menu1.add(map3);
		map3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.level = 3;
				model.loadLevel(3);
				printLevel();
			}
		});

		menu1.add(map4);
		map4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.level = 4;
				model.loadLevel(4);
				printLevel();
			}
		});

		menu1.add(map5);
		map5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controller.level = 5;
				model.loadLevel(5);
				printLevel();
			}
		});

		setJMenuBar(menuBar);
	}






	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	public void printLevel() {
		
		model.getLevel();
		String[][] levelTab = model.getLevelTab();
		
		for(RowLevel entity: Level.getLevel()){
	       	 
	       	 levelTab[entity.getBlocksX()][entity.getBlocksY()] = entity.getBlocksType();
	       	 
	       }
	}


	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
