package controller;

import contract.IMovement;

public class Movement implements IMovement {
	Player player = new Player;

	switch (movePlayer()) {
	case UP:
		player.setY(player.getY() - 1);
		break;

	case DOWN:
		player.setY(player.getY() + 1);
		break;

	case LEFT:
		player.setX(player.getX() - 1);
		break;

	case RIGHT:
		player.setX(player.getX() + 1);
		break;
	}
}}