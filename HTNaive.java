import java.math.BigInteger;

public class HTNaive {

    private static ListeBigI[] t;
    private long totalTimeH;
    private long totalTimeContient;

    /**
     * Constructeur HTNaive
     * Action: Construit une table de listes HTNaive, de longueur m.
     * 
     * @param m
     */
    public HTNaive(int m) {
        this.t = new ListeBigI[m];
        this.totalTimeContient = 0;
        this.totalTimeH = 0;
        for (int i = 0; i < m; i++) {
            this.t[i] = new ListeBigI();
        }
    }

    /**
     * Constructeur HTNaive
     * Action: Construit une table de listes HTNaive, de longueur m, et contenant
     * les BigInteger de l.
     * 
     * @param l
     * @param m
     */
    public HTNaive(ListeBigI l, int m) {
        this(m);
        this.ajoutListe(l);
    }

    /**
     * Action: Construit une table de listes HTNaive, de longueur m.
     * 
     * @param l
     * @param f
     */
    public HTNaive(ListeBigI l, double f) {
        this(l, (int) (f * HTNaive.HTNaiveTemp(l).getCardinal()));
    }

    private static HTNaive HTNaiveTemp(ListeBigI l) {
        HTNaive temp = new HTNaive(l, 1000);
        return temp;
    }

    /**
     * Accesseur en lecture de la tête de liste de l'entier i de la liste.
     * 
     * @param i
     * @return
     */
    public ListeBigI getListe(int i) {
        return this.t[i];
    }

    /**
     * Méthode getElements
     * Action: retourne la liste de tous les éléments de this.
     * 
     * @return une ListeBigI
     */
    public ListeBigI getElements() {
        ListeBigI liste = new ListeBigI();
        for (int i = 0; i < this.t.length; i++) {
            liste.ajoutListe(this.t[i]);
        }
        return liste;
    }

    /**
     * Accesseur en lecture de l'attribut TotalTimeH.
     * 
     * @return un long
     */
    public long getTotalTimeH() {
        return this.totalTimeH;
    }

    /**
     * Accesseur en lecture de l'attribut TotalTimeContient.
     * 
     * @return un long
     */
    public long getTotalTimeContient() {
        return this.totalTimeContient;
    }

        /**
     * Méthode getNBListes
     * Action: Retourne la longueur de la table de listes.
     * 
     * @return un entier
     */
    public int getNbListes() {
        return this.t.length;
    }

    /**
     * Méthode getCardinal
     * Action: Retourne la somme de la longueur de chaque liste de la table.
     * 
     * @return un entier
     */
    public int getCardinal() {
        return this.getElements().longueur();
    }

    /**
     * Méthode h
     * Action: Calcule le reste de la division euclidienne entre u et la longueur du
     * tableau.
     * 
     * @param u
     * @return un entier
     */
    public int h(BigInteger u) {
        long debut = System.currentTimeMillis();
        int res = u.mod(BigInteger.valueOf(this.t.length)).intValue();
        long fin = System.currentTimeMillis();
        this.totalTimeH = this.totalTimeH + (fin - debut);
        return res;
    }

    /**
     * Méthode contient
     * Action: Parcourt les têtes de listes de la table et retourne vrai si le
     * BigInteger passé en paramètre est une tête de liste.
     * 
     * @param u
     * @return un booléen res
     */
    public boolean contient(BigInteger u) {
        long debut = System.currentTimeMillis();
        boolean res = false;
        if (this.t[this.h(u)].contient(u) == true) {
            res = true;
        }
        long fin = System.currentTimeMillis();
        this.totalTimeContient = this.totalTimeContient + (fin - debut);
        return res;
    }

    /**
     * Méthode ajout
     * Action: Retourne vrai si le BigInteger passé en paramètre est présent.
     * 
     * @param u
     * @return un booléen res
     */
    public boolean ajout(BigInteger u) {
        boolean res = false;
        if (this.contient(u) == false) {
            this.t[this.h(u)].ajoutTete(u);
            res = true;
        }
        return res;
    }

    /**
     * Méthode ajout liste
     * Action: ajoute la liste passée en paramètre.
     * 
     * @param L
     */
    public void ajoutListe(ListeBigI L) {
        ListeBigI liste = new ListeBigI(L);
        while (liste.estVide() == false) {
            this.ajout(liste.supprTete());
        }
    }

    /**
     * Méthode toString
     * Action: Propose un affichage propre des éléments de this.
     * 
     * @return une chaîne de caractères
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < this.t.length; i++) {
            res += "t[" + i + "] : " + this.t[i].toString() + "\n";
        }
        return res;
    }

    /**
     * Méthode getMaxSize
     * Action: Retourne la longueur de la liste la plus longue de la table.
     * 
     * @return un entier
     */
    public int getMaxSize() {
        int res = 0;
        for (int i = 0; i < this.t.length; i++) {
            if (res < this.t[i].longueur()) {
                res = this.t[i].longueur();
            }
        }
        return res;
    }

    /**
     * Méthode toStringV2
     * Action: Propose un affichage des éléments de this ou chaque élément d'une
     * liste est représenté par une étoile.
     * 
     * @return une chaîne de caractères.
     */
    public String toStringV2() {
        String res = "";
        for (int i = 0; i < this.t.length; i++) {
            if (this.t[i].estVide() == false) {
                res = res + "t[" + i + "] : ";
                for (int j = 0; j < this.t[i].longueur(); j++) {
                    res = res + "*";
                }
                res = res + "\n";
            }
        }
        return res;
    }

}
