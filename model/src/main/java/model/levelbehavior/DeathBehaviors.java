package model.levelbehavior;

public class DeathBehaviors {

	private ModelBehaviors modelBehaviors;
	
	public DeathBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
		
	}

	public ModelBehaviors getModelBehaviors() {return modelBehaviors;}
	public void setModelBehaviors(ModelBehaviors modelBehaviors) {this.modelBehaviors = modelBehaviors;}
	
	public void enemyDeath(String[][] levelTab, int i, int j) {
		if(levelTab[j][i] != null && (levelTab[j][i].equals("Boulder") || levelTab[j][i].equals("Diamond")) && levelTab[j][i+1].equals("Enemy")  ) {
			levelTab[j][i] = "DirtAfterHero";
			levelTab[j][i+1] = "Diamond";
			levelTab[j][i+2] = "Diamond";
			levelTab[j][i] = "Diamond";
			levelTab[j+1][i+1] = "Diamond";
			levelTab[j+1][i+2] = "Diamond";
			levelTab[j+1][i] = "Diamond";
			levelTab[j-1][i+1] = "Diamond";
			levelTab[j-1][i+2] = "Diamond";
			levelTab[j-1][i] = "Diamond";
			this.getModelBehaviors().getModel().setCoordXEnemy(-2);
			this.getModelBehaviors().getModel().setCoordYEnemy(-2);
		}
	}
	
	public void heroDeath(String[][] levelTab, int i, int j, int coordX, int coordY) {
		if(levelTab[j][i] != null && (coordX == j) && (coordY == i) && levelTab[j][i].equals("Enemy")){
			this.getModelBehaviors().getModel().setCoordXHero(4);
			this.getModelBehaviors().getModel().setCoordYHero(4);
			this.getModelBehaviors().getModel().GameOver();
		}
	}
}
