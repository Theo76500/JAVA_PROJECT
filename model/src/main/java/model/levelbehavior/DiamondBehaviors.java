package model.levelbehavior;

public class DiamondBehaviors {

	private ModelBehaviors modelBehaviors;
	
	public DiamondBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
	}

	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	public void fallingDiamond(String levelTab[][], int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && levelTab[j][i+1].equals("DirtAfterHero")) {
			this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getSomethingIsFalling());
			if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (coordX == j) && (coordY == i+1)) {}
			else {
				levelTab[j][i] = "DirtAfterHero";
				levelTab[j][i+1] = "Diamond";
			
					if(levelTab[j][i] != null && levelTab[j][i+1].equals("Diamond") && (coordX == j) && (coordY== i+2)) {
						this.getModelBehaviors().getModel().GameOver();
					}
			}
		}
	}

	public void diamondEarned(String[][] levelTab, int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && levelTab[j][i].equals("Diamond") && (coordX == j) &&  (coordY == i)) {
		    levelTab[j][i] = "DirtAfterHero";
		    
		    if(this.getModelBehaviors().getModel().getDiamond() > 0) {
		    	this.getModelBehaviors().getModel().setDiamond(this.getModelBehaviors().getModel().getDiamond() - 1);
		    }
		    this.getModelBehaviors().getModel().setScore(this.getModelBehaviors().getModel().getScore()+15);
		    this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getEarningADiamond());
		}
	}
}
