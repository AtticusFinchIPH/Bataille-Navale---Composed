package application.grilles.grillememoire;

import application.caze.PresentationCaze;
import application.caze.ViewCaze;
import javafx.scene.layout.GridPane;

public class ViewGrilleMemoire extends GridPane implements IViewGrilleMemoire{
	
	private PresGrilleMemoire presGrilleMemoire;

	private ViewCaze[][] viewCaze;
	private PresentationCaze[][] presCaze;
	private static int numberOfCaze = 10;
	
	public ViewGrilleMemoire(final PresGrilleMemoire presGM) {
		this.presGrilleMemoire = presGM;
		
		viewCaze = new ViewCaze[numberOfCaze][numberOfCaze];
		presCaze = new PresentationCaze[numberOfCaze][numberOfCaze];
		for(int i = 0; i<numberOfCaze; i ++) {
			for(int j = 0; j<numberOfCaze; j++) {
				presCaze[i][j] = new PresentationCaze(i, j);
				viewCaze[i][j] = new ViewCaze(presCaze[i][j]);
				presCaze[i][j].setView(viewCaze[i][j]);
				add(viewCaze[i][j], i, j);
				
				presCaze[i][j].setPresGrille(this.presGrilleMemoire);
			}
		}
	}
	
	@Override
	public void drawAttaqueEmpty(int posX, int posY) {
		viewCaze[posX][posY].drawAttaqueEmpty(viewCaze[posX][posY].getGraphicsContext2D());
		
	}
	
	@Override
	public void drawBrokenShip(int posX, int posY) {
		viewCaze[posX][posY].drawBrokenShip(viewCaze[posX][posY].getGraphicsContext2D());
		
	}
	
	@Override
	public void drawDestroyedShip(int posX, int posY) {
		viewCaze[posX][posY].drawDestroyedShip(viewCaze[posX][posY].getGraphicsContext2D());
		
	}
}
