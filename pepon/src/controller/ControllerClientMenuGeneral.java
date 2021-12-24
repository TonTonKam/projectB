package controller;

import model.VarStatic;
import vue.PanelClientGeneralMenu;

public class ControllerClientMenuGeneral {

	//on affiche le nom de l'utisateur quand celui-ci ce connect
	public void afficheUser(PanelClientGeneralMenu labelNomClient) {
		if(VarStatic.currentUserStatic != null) {
			
			labelNomClient.setLabelNomClient(VarStatic.currentUserStatic.getNom());
			
		}
	}
}
