package noyauFonction.caze;

import java.util.logging.Logger;

import noyauFonction.pion.ECouleur;

/**
 * une case qui represente la mer
 * 
 * @author yinyiliang
 *
 */
public class CaseMer extends Case {
	
	private final static Logger LOGGER = Logger.getLogger(CaseMer.class.getName());
	
	
	public CaseMer(final int positionX, final int positionY) {
		super(positionX, positionY);
	}

	public ECouleur estAttaque(int puiss) {
		LOGGER.info("tir dans la mer "+ this.toString());
		return ECouleur.blue;
	}
	
	@Override
	public String toString() {
		return "CaseMer("+this.getPosX() +","+this.getPosY()+")";
	}

}
