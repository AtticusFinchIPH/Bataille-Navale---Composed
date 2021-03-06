package noyauFonction.navires.typeNavire;

import java.util.List;

import noyauFonction.navires.ENavire;
import noyauFonction.navires.attaquesNavire.IAttaque;
import noyauFonction.navires.automateNavire.IEtatNavire;
import noyauFonction.navires.automateNavire.IGestionEtatNavire;
import noyauFonction.caze.CaseNavire;
import noyauFonction.joueur.IJoueur;

/**
 * interface d'une navire
 * 
 * @author yinyiliang
 *
 */
public interface INavire extends IGestionEtatNavire {

	public int getPosX();
	public void setPosX(int posX);
	
	public int getPosY();
	public void setPosY(int posX);
	
	public boolean isOri();
	public void setOri(boolean ori);
	
	public void aLAttaque(IJoueur joueur, IJoueur adverse, int posX,int posY);
	
	public IAttaque getCompoAttaque();
	public void setCompoAttaque(IAttaque att);
	
	public int getPuissanceAttaque();
	public void setPuissanceAttaque(int puissanceAttaque);
	
	public int getNvieCase();
	public void setNvieCase(int nvieCase);
	
	public int getLongueur();
	public void setLongueur(int longueur);
	
	public List<CaseNavire> getLcaseNav();
	public void setLcaseNav(List<CaseNavire> lcaseNav);
	
	public ENavire getEnav();
	
	public String toString();
	
	public void renouvelerEtatNavire();
}
