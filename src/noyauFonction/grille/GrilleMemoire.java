package noyauFonction.grille;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import noyauFonction.caze.ICase;
import noyauFonction.pion.ECouleur;
import noyauFonction.pion.Pion;

/**
 * Grille qui stocke la “mémoire�? des tirs déjà effectués
 * 
 * @author yinyiliang
 *
 */
public class GrilleMemoire extends Grille implements IGrilleM {

	private final static Logger LOGGER = Logger.getLogger(GrilleMemoire.class.getName());

	private List<Pion> lpion;

	public GrilleMemoire() {
		super();
		lpion = new ArrayList<Pion>();
	}

	public void addPion(int posX, int posY, ECouleur tir) {
		if(tir == ECouleur.red) {
			Pion pion = new Pion(posX, posY, ECouleur.red);
			lpion.add(pion);
			LOGGER.info("ajouter un pion "+pion.toString());
		} else if (tir == ECouleur.orange) {
			Pion pion = new Pion(posX, posY, ECouleur.orange);
			lpion.add(pion);
			LOGGER.info("ajouter un pion "+pion.toString());
		} else {
			Pion pion = new Pion(posX, posY, ECouleur.blue);
			lpion.add(pion);
			LOGGER.info("ajouter un pion "+pion.toString());
		}
	}

	public void addPion(ICase caze, ECouleur tir) {
		addPion(caze.getPosX(),caze.getPosY(),tir);
	}

	public List<Pion> getLpion() {
		return lpion;
	}

}
