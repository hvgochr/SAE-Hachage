import java.math.BigInteger;

public class ListeBigI {

	private Maillon tete;

	/**
	 * Constructeur ListeBigI
	 * Action: Construit une liste chaînée de Maillons vide.
	 */
	public ListeBigI() {
		this.tete = null;
	}

	/**
	 * Constructeur ListeBigI /!\ OBSOLETE : NE PLUS UTILISER
	 * Action: Construit une liste chaînée de Maillons dont la tête est le Maillon
	 * passé en paramètre.
	 * 
	 * @param m
	 */
	public ListeBigI(Maillon m) { 
		this.tete = m;
	}

	/**
	 * Constructeur ListeBigI
	 * Action: Construit une liste chaînée de Maillons à un seul élément dont la
	 * valeur de la tête est le BigInteger passé en paramètre.
	 * 
	 * @param x
	 */
	public ListeBigI(BigInteger x) {
		this.tete = new Maillon(x);
	}

	/**
	 * Constructeur ListeBigI
	 * Action: Construit une liste dont les Maillons auront pour valeur les
	 * BigInteger du tableau passé en paramètre.
	 */
	public ListeBigI(BigInteger[] tabListe) {
		this();
		if (tabListe.length > 0) {
			this.tete = new Maillon(tabListe[0]);
			Maillon curThis = this.tete;
			for (int i = 1; i < tabListe.length; i++) {
				curThis.setSuiv(new Maillon(tabListe[i]));
				curThis = curThis.getSuiv();
			}
		}
	}

	/**
	 * Constructeur ListeBigI
	 * Action: Construit une liste par recopie profonde de la liste passée en
	 * paramètre.
	 *
	 * @param l
	 */
	public ListeBigI(ListeBigI l) { // constructeur par recopie profonde
		this();
		if (!l.estVide()) {
			this.tete = new Maillon(l.tete.getVal());
			Maillon curThis = this.tete;
			Maillon curL = l.tete.getSuiv();
			while (curL != null) {
				curThis.setSuiv(new Maillon(curL.getVal())); // creation et accrochage du maillon suivant
				curThis = curThis.getSuiv();
				curL = curL.getSuiv();
			}
		}
	}

	/**
	 * Méthode estVide
	 * Action: retourne vrai si et seulement si la liste est vide, donc la tête de
	 * liste est vide.
	 * 
	 * @return un booléen res
	 */
	public boolean estVide() {
		return (this.tete == null);
	}

	// public int valTete () {
	// return this.tete.getVal();
	// }

	/**
	 * Méthode ajoutTete
	 * Action: Ajoute un Maillon tete a this.
	 * 
	 * @param x
	 */
	public void ajoutTete(BigInteger x) {
		Maillon m = new Maillon(x);
		m.setSuiv(this.tete);
		this.tete = m;
	}

	/**
	 * Méthode ajoutListe
	 * Action: Ajoute un liste passée en paramètre.
	 * 
	 * @param l
	 */
	public void ajoutListe(ListeBigI l) {
		Maillon cur = l.tete;
		while (cur != null) {
			ajoutTete(cur.getVal());
			cur = cur.getSuiv();
		}
	}

	/**
	 * Méthode supprTete
	 * Action: Retire la tête de this et retourne sa valeur.
	 * 
	 * @return un BigInteger
	 */
	public BigInteger supprTete() {
		// pré this non vide
		BigInteger res = tete.getVal();
		tete = tete.getSuiv();
		return res;
	}

	/**
	 * Méthode contient
	 * Action: retourne vrai si la valeur d'un Maillon correspond au BigInteger
	 * passé en paramètre.
	 * 
	 * @param x
	 * @return un booléen
	 */
	public boolean contient(BigInteger x) {
		Maillon courant = this.tete;
		while (courant != null && !(courant.getVal().equals(x))) {
			courant = courant.getSuiv();
		}
		return courant != null;
	}

	/**
	 * Méthode toString
	 * Action: propose un affichage de Liste.
	 * 
	 * @return une chaîne de caractères
	 */
	public String toString() {
		String s = "(";
		Maillon courant = this.tete;
		while (courant != null) {
			s = s + (courant.getVal()) + ((courant.getSuiv() != null) ? ", " : "");
			courant = courant.getSuiv();
		}
		return s + ")";
	}

	/**
	 * Méthode longueur
	 * Action: parcourt la liste this et retourne sa longueur.
	 * 
	 * @return un entier
	 */
	public int longueur() {
		int lg = 0;
		Maillon courant = this.tete;
		while (courant != null) {
			lg++;
			courant = courant.getSuiv();
		}
		return lg;
	}

	/**
	 * Méthode ajoutFin
	 * Action: Ajoute un maillon à la fin de la liste this, dont la valeur est le
	 * BigInteger passé en paramètre.
	 * 
	 * @param n
	 */
	public void ajoutFin(BigInteger n) {
		if (this.estVide()) {
			this.tete = new Maillon(n);
		} else {
			Maillon courant = this.tete;
			while (courant.getSuiv() != null) {
				courant = courant.getSuiv();
			}
			courant.setSuiv(new Maillon(n));
		}
	}

	/**
	 * Action: Supprime le premier élément contenant la valeur passée en paramètre.
	 * 
	 * @param n
	 */
	public void supprOcc(BigInteger n) {
		if (this.estVide()) {
			// rien
		} else if (this.tete.getVal().equals(n))
			this.tete = this.tete.getSuiv();
		else {
			Maillon prev = this.tete;
			Maillon current = prev.getSuiv();
			while (current != null && current.getVal() != n) {
				prev = current;
				current = current.getSuiv();
			}
			if (current != null) {
				prev.setSuiv(current.getSuiv());
			}
		}
	}

} // end class

/**
 * @return this est une sous-liste de @param
 * 
 *         ancienne version obsolete ou incorrecte...
 * 
 *         public boolean sousListe (Liste l) {
 *         boolean prefixe = false;
 *         Maillon curThis = this.tete;
 *         Maillon curL = l.tete;
 *         while (curThis != null && curL != null && ! prefixe) {
 *         prefixe = curThis.estPrefixe(curL);
 *         if (! prefixe) // test pas necessaire car curL non vide mais bon...
 *         curL = curL.getSuiv();
 *         }
 *         return prefixe;
 *         }
 */