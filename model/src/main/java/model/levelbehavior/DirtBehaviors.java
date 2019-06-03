package model.levelbehavior;

public class DirtBehaviors {

	private ModelBehaviors modelBehaviors;
	
	public DirtBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
	}

	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	
	public void dirtReplacement(String[][] levelTab, int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && levelTab[j][i].equals("Dirt") && (coordX == j) &&  (coordY == i)){
		    levelTab[j][i] = "DirtAfterHero";
		   this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getBreakABlockSound());
		}
	}
}
