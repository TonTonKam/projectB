package controller;

import model.VarStatic;
import vue.PanelClientGeneralMenu;

public class ControllerClientMenuGeneral {

	public void afficheUser(PanelClientGeneralMenu labelNomClient) {
		if(VarStatic.currentUserStatic != null) {
			
			labelNomClient.setLabelNomClient(VarStatic.currentUserStatic.getNom());
			
		}
	}
}
