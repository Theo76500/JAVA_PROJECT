package model.checks;

import contract.IModel;

public class CheckCollisions {

	private IModel model;
	
	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public CheckCollisions(IModel model) {
		this.setModel(model);
		}
	
	public void checkCollisionEnemy(int coordXEnemy, int coordYEnemy) {
		String[][] levelTab = this.getModel().getLevelTab();		
			switch(this.getModel().getChoice()){
			case 1:
					if(levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy+1][coordYEnemy].equals("DirtAfterHero") || levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy+1][coordYEnemy].equals("Hero")) {
						this.getModel().setCoordXEnemy(this.getModel().getCoordXEnemy() + 1);
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.getModel().setNbr(1);
						
					}	else {
						this.getModel().setNbr(this.getModel().getRandomFour());
					}		
				break;
			case 2:		
					if(levelTab[coordXEnemy+1][coordYEnemy] != null && levelTab[coordXEnemy-1][coordYEnemy].equals("DirtAfterHero") || levelTab[coordXEnemy-1][coordYEnemy] != null && levelTab[coordXEnemy-1][coordYEnemy].equals("Hero")) {
						this.getModel().setCoordXEnemy(this.getModel().getCoordXEnemy() - 1);
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.getModel().setNbr(2);
						
					} 	else {
						this.getModel().setNbr(this.getModel().getRandomFour());

					}	
				break;
			case 3:			
					if(levelTab[coordXEnemy][coordYEnemy] != null && levelTab[coordXEnemy][coordYEnemy-1].equals("DirtAfterHero") || levelTab[coordXEnemy][coordYEnemy-1] != null && levelTab[coordXEnemy][coordYEnemy-1].equals("Hero")) {
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.getModel().setCoordYEnemy(this.getModel().getCoordYEnemy() - 1);
						this.getModel().setNbr(3);

					}else {
						this.getModel().setNbr(this.getModel().getRandomFour());
					}				
				break;
			case 4:
					if(levelTab[coordXEnemy][coordYEnemy] != null && levelTab[coordXEnemy][coordYEnemy+1].equals("DirtAfterHero") || levelTab[coordXEnemy][coordYEnemy +1] != null && levelTab[coordXEnemy][coordYEnemy+1].equals("Hero")) {
						levelTab[coordXEnemy][coordYEnemy] = "DirtAfterHero";
						this.getModel().setCoordYEnemy(this.getModel().getCoordYEnemy() + 1);
						this.getModel().setNbr(4);
					}else {
						this.getModel().setNbr(this.getModel().getRandomFour());
					}
				break;
			}
	}
	
	public boolean checkCollisionBoulder(int coordX, int coordY) {
		
		String levelTab[][] = this.getModel().getLevelTab();
		
		if(levelTab[coordX][coordY].equals("Boulder")) {
			return false;
		}
		return true;
	}
	
	public boolean checkCollision(int coordX, int coordY) {
		
		String levelTab[][] = this.getModel().getLevelTab();
		
		if(levelTab[coordX][coordY].equals("Boulder") || levelTab[coordX][coordY].equals("BorderBlock")) {
			return false;
		}
		return true;
	}
}
