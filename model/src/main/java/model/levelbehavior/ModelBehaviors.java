package model.levelbehavior;

import java.io.File;

import contract.IModel;

public class ModelBehaviors{

	private IModel model;
	
	private BoulderBehaviors boulderBehaviors = new BoulderBehaviors(this);
	private DiamondBehaviors diamondBehaviors = new DiamondBehaviors(this);
	private DirtBehaviors dirtBehaviors = new DirtBehaviors(this);
	private DeathBehaviors deathBehaviors = new DeathBehaviors(this);
	private GlobalLevelBehaviors globalLevelBehaviors = new GlobalLevelBehaviors(this);
	
	public BoulderBehaviors getBoulderBehaviors() {return boulderBehaviors;}
	public void setBoulderBehaviors(BoulderBehaviors boulderBehaviors) {this.boulderBehaviors = boulderBehaviors;}
	public DiamondBehaviors getDiamondBehaviors() {return diamondBehaviors;}
	public void setDiamondBehaviors(DiamondBehaviors diamondBehaviors) {this.diamondBehaviors = diamondBehaviors;}
	public DirtBehaviors getDirtBehaviors() {return dirtBehaviors;}
	public void setDirtBehaviors(DirtBehaviors dirtBehaviors) {this.dirtBehaviors = dirtBehaviors;}
	public DeathBehaviors getDeathBehaviors() {return deathBehaviors;}
	public void setDeathBehaviors(DeathBehaviors deathBehaviors) {this.deathBehaviors = deathBehaviors;}
	public GlobalLevelBehaviors getGlobalLevelBehaviors() {return globalLevelBehaviors;}
	public void setGlobalLevelBehaviors(GlobalLevelBehaviors globalLevelBehaviors) {this.globalLevelBehaviors = globalLevelBehaviors;}
	
	public IModel getModel() {
		return model;
	}
	public void setModel(IModel model) {
		this.model = model;
	}
	
	public ModelBehaviors(IModel model) {
		this.setModel(model);
		}
	
	public File breakABlockSound = new File("Songs\\breakABlock.wav");
	public File earningADiamond = new File("Songs\\earningADiamond.wav");
	public File somethingIsFalling = new File("Songs\\somethingIsFalling.wav");
	public File readyToLeaveThisPlace = new File("Songs\\readyToLeaveThisPlace.wav");

	public File getBreakABlockSound() {return breakABlockSound;}
	public void setBreakABlockSound(File breakABlockSound) {this.breakABlockSound = breakABlockSound;}
	public File getEarningADiamond() {return earningADiamond;}
	public void setEarningADiamond(File earningADiamond) {this.earningADiamond = earningADiamond;}
	public File getSomethingIsFalling() {return somethingIsFalling;}
	public void setSomethingIsFalling(File somethingIsFalling) {this.somethingIsFalling = somethingIsFalling;}
	public File getReadyToLeaveThisPlace() {return readyToLeaveThisPlace;}
	public void setReadyToLeaveThisPlace(File readyToLeaveThisPlace) {this.readyToLeaveThisPlace = readyToLeaveThisPlace;}
	
	public String[][] levelBehavior(String[][] levelTab, int coordX, int coordY) {
		int i = 0;
		int j = 0;
		 
		for(String subTab[] : levelTab) {
		  i = 0;
		  for (int k = 0; k < subTab.length; k++) {
			  boulderBehaviors.fallingBoulder(levelTab, i, j, coordX, coordY);
			  boulderBehaviors. fallingBoulderMecanic(levelTab, i, j);
			  boulderBehaviors.boulderTestRight(levelTab, i, j, coordX, coordY);
			  boulderBehaviors.boulderTestLeft(levelTab, i, j, coordX, coordY);
			  diamondBehaviors.fallingDiamond(levelTab, i, j, coordX, coordY);
			  diamondBehaviors.diamondEarned(levelTab, i, j, coordX, coordY);
			  dirtBehaviors.dirtReplacement(levelTab, i, j, coordX, coordY);
			  deathBehaviors.enemyDeath(levelTab, i, j);
			  deathBehaviors.heroDeath(levelTab, i, j, coordX, coordY);
			  globalLevelBehaviors.runningOutTime(levelTab, i, j);
			  globalLevelBehaviors.readyToLeave();
			  globalLevelBehaviors.levelComplete(levelTab, i, j, coordX, coordY);
			  i++;
			}
		  j++;
		}
		return levelTab;
	}
}
