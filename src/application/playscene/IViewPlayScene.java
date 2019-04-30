package application.playscene;

import application.controller.IView;

public interface IViewPlayScene extends IView{
	public void notifyDrawInitAllShips();
	
	public void notifyDrawOcean(int posX, int posY);
	public void notifyDrawTorpilleurShip(int posX, int posY);
	public void notifyDrawSousMarinShip(int posX, int posY);
	public void notifyDrawContreTorpilleurShip(int posX, int posY);
	public void notifyDrawPorteAvionShip(int posX, int posY);
	public void notifyDrawCroisseurShip(int posX, int posY);
	
	public void notifyDrawAttaqueEmpty(int posX, int posY);
	public void notifyDrawBrokenShip(int posX, int posY);
	public void notifyDrawDestroyedShip(int posX, int posY);
	
	public void notifyDrawAttaqueEmptyMemoire(int posX, int posY);
	public void notifyDrawBrokenShipMemoire(int posX, int posY);
	public void notifyDrawDestroyedShipMemoire(int posX, int posY);
	
	public void notifySetInfoLabel(String info);
}
