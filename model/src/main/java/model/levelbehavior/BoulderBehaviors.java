package model.levelbehavior;

public class BoulderBehaviors {

	private ModelBehaviors modelBehaviors;
	
	public BoulderBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
	}
	
	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	public void fallingBoulder(String[][] levelTab, int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("DirtAfterHero")) {
			this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getSomethingIsFalling());
			
		    if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && (coordX == j) && (coordY == i+1)) {}
		    else {
		    	levelTab[j][i] = "DirtAfterHero";
		    	levelTab[j][i+1] = "Boulder";
		    		if(levelTab[j][i] != null && levelTab[j][i+1].equals("Boulder") && (coordX == j) && (coordY == i+2)) {
		    			this.getModelBehaviors().getModel().GameOver();
				    }				    		
		    }    	
		}
	}
	
	public void fallingBoulderMecanic(String[][] levelTab, int i, int j) {
		 if(levelTab[j][i] != null && levelTab[j][i].equals("Boulder") && levelTab[j][i+1].equals("Boulder")) {
		    	if(levelTab[j-1][i].equals("DirtAfterHero") && levelTab[j-1][i+1].equals("DirtAfterHero")) {
			    	levelTab[j-1][i] = "Boulder";
			    	levelTab[j][i] = "DirtAfterHero";
			    	this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().somethingIsFalling);
		    	}
		    	else {
			    	if(levelTab[j+1][i].equals("DirtAfterHero") && levelTab[j+1][i+1].equals("DirtAfterHero")) {
			    		levelTab[j+1][i] = "Boulder";
				    	levelTab[j][i] = "DirtAfterHero";
				    	this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getSomethingIsFalling());
			    	}
		    	}
		    }	
	}
	
	public void boulderTestRight(String[][] levelTab, int i, int j, int coordX, int coordY) {
		boolean varTestRight = this.getModelBehaviors().getModel().isBoulderRight();
		if(levelTab[j][i] != null && varTestRight && levelTab[j][i].equals("Boulder") && levelTab[j+1][i].equals("DirtAfterHero") && (coordX == j-1) && (coordY == i)) {
				levelTab[j+1][i] = "Boulder";
				levelTab[j][i] = "DirtAfterHero";
				this.getModelBehaviors().getModel().setBoulderRight(false);
				this.getModelBehaviors().getModel().setBoulderLeft(false);
		}
	}
	
	public void boulderTestLeft(String[][] levelTab, int i, int j, int coordX, int coordY) {
		boolean varTestLeft = this.getModelBehaviors().getModel().isBoulderLeft();
		if(levelTab[j][i] != null && varTestLeft && levelTab[j][i].equals("Boulder") && levelTab[j-1][i].equals("DirtAfterHero") && (coordX== j+1) && (coordY == i)) {
			levelTab[j-1][i] = "Boulder";
			levelTab[j][i] = "DirtAfterHero";
			this.getModelBehaviors().getModel().setBoulderLeft(false);
			this.getModelBehaviors().getModel().setBoulderRight(false);
		}
	}
}
