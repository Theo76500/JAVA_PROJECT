package model;

import contract.ControllerOrder;

public class Player {
	private ControllerOrder controllerOrder;
	private int x;
	private int y;
	
	public Player () {
		super();
		controllerOrder = ControllerOrder.CHARACTER_DOWN;
		x = y = 1;
	}
	
	public ControllerOrder getControllerOrder() {
		return controllerOrder;
	}
	
	public void setControllerOrder(ControllerOrder controllerOrder) {
		this.controllerOrder = controllerOrder;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
