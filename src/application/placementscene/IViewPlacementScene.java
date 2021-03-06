package application.placementscene;

import application.controller.IView;

public interface IViewPlacementScene extends IView{
	public void notifyDrawInitAllShips();
	
	public void notifyDrawOcean(int posX, int posY);
	public void notifyDrawTorpilleurShip(int posX, int posY);
	public void notifyDrawSousMarinShip(int posX, int posY);
	public void notifyDrawContreTorpilleurShip(int posX, int posY);
	public void notifyDrawPorteAvionShip(int posX, int posY);
	public void notifyDrawCroisseurShip(int posX, int posY);
	
	public void notifyStopAutoPlace();
}
