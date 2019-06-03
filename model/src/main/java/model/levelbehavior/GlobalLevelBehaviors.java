package model.levelbehavior;

public class GlobalLevelBehaviors {

	private ModelBehaviors modelBehaviors;
	
	public GlobalLevelBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
	}

	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	
	public void runningOutTime(String[][] levelTab, int i, int j) {
		if (levelTab[j][i] != null && this.getModelBehaviors().getModel().getTimeLeft() == 1){
			this.getModelBehaviors().getModel().getGameOver();
		}
	}
	
	public void readyToLeave() {
		if(this.getModelBehaviors().getModel().getDiamond() == 0 && !this.getModelBehaviors().getModel().isReadyToLeave()) {
			this.getModelBehaviors().getModel().playSound(this.getModelBehaviors().getReadyToLeaveThisPlace());
			this.getModelBehaviors().getModel().setReadyToLeave(true);
		}
	}
	
	public void levelComplete(String[][] levelTab, int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && levelTab[coordX][coordY].equals("ExitDoor") && this.getModelBehaviors().getModel().getDiamond() == 0) {
			this.getModelBehaviors().getModel().GameWin();
		}
	}
}
