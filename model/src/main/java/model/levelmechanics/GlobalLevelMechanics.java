package model.levelmechanics;

import contract.IModel;
import model.levelbehavior.ModelBehaviors;

public class GlobalLevelMechanics {

	private IModel model;
	
	private ModelBehaviors modelBehaviors;
	
	private String[][] levelCamera = new String[16][16];

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public GlobalLevelMechanics(IModel model, ModelBehaviors modelBehaviors) {
		this.setModel(model);
		this.setModelBehaviors(modelBehaviors);
		}
	
	public ModelBehaviors getModelBehaviors() {
		return modelBehaviors;
	}

	public void setModelBehaviors(ModelBehaviors modelBehaviors) {
		this.modelBehaviors = modelBehaviors;
	}

	public String[][] levelCamera(String[][] levelTab) {
		
		int offsetMaxX = 20 - 16;
		int offsetMaxY = 20 - 16;
		int offsetMinX = 0;
		int offsetMinY = 0;
		
		int camX = this.getModel().getCoordXHero() - (16 / 2);
		int camY = this.getModel().getCoordYHero() - (16 / 2);
		
		if (camX > offsetMaxX) {
			camX = offsetMaxX;
		}
		else if(camX < offsetMinX) {
			camX = offsetMinX;
		}
		else {
		}
		if(camY > offsetMaxY) {
			camY = offsetMaxY;
		}
		else if (camY < offsetMinY) {
			 camY = offsetMinY;
		}
		
		int i = 0;
		int j = 0;
		
		for(String subTab[] : levelCamera){
		  i = 0;
		  camY = this.getModel().getCoordYHero() - (16 / 2);
		  
			if(camY > offsetMaxY) {
				camY = offsetMaxY;
			}
			else if (camY < offsetMinY) {
				 camY = offsetMinY;
			}
			
		  for (int k = 0; k < subTab.length; k++) {
			levelCamera[j][i] = levelTab[j + camX][i + camY];
			i++;
			}
		  j++;
		}
		return levelCamera;
		}
	
	public void setStartLevel() {
		this.getModel().setCharacterCoords(this.getModel().getCoordXHero(), this.getModel().getCoordYHero());
		this.getModel().setLevelTab(modelBehaviors.levelBehavior(this.getModel().getLevelTab(), this.getModel().getCoordXHero(), this.getModel().getCoordYHero()));
		this.getModel().setLevelCamera(this.getModel().levelCam(this.getModel().getLevelTab()));
	}

	public String[][] getLevelCamera() {
		return levelCamera;
	}

	public void setLevelCamera(String[][] levelCamera) {
		this.levelCamera = levelCamera;
	}
}
