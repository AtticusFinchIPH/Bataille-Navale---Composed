package noyauFonction.grille;

import java.util.List;

import noyauFonction.caze.ICase;
import noyauFonction.pion.ECouleur;
import noyauFonction.pion.Pion;

/**
 * interface Grille
 * 
 * pattern monteur ou builder
 * 
 * @author yinyiliang
 *
 */
public interface IGrilleM extends IGrille {
	
	public void addPion(ICase caze, ECouleur tir);
	public void addPion(int posX, int posY, ECouleur tir);
	
	public List<Pion> getLpion();
}
