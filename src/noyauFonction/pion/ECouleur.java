package noyauFonction.pion;

/**
 * Couleur d'un pion
 * 
 * @author yinyiliang
 *
 */
public enum ECouleur {
	
	blue(0), orange(1), red(2);

	private int valeurcouleur;

	private ECouleur(int val) {
		valeurcouleur = val;
	}

	/**
	 * Obtient la valeur associée à la couleur.
	 * @return int, la valeur.
	 */
	public int getValeurCouleur() {
		return valeurcouleur;
	}

	/**
	 * Obtient la représentation textuelle d'une couleur.
	 */
}
