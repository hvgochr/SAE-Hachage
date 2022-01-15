import java.math.BigInteger;

public class Maillon {

    private BigInteger valeur;
    private Maillon suivant;

    /**
     * Constructeur Maillon
     * Action: construit un maillon vide.
     */
    public Maillon() {
        suivant = null;
    }

    /**
     * Constructeur Maillon
     * Action: construit un maillon dont la valeur sera un BigInteger passé en
     * paramètre.
     * 
     * @param valeur
     */
    public Maillon(BigInteger valeur) {
        this.valeur = valeur;
        this.suivant = null;
    }

    /**
     * Accesseur en lecture de l'attribut valeur.
     * 
     * @return this.valeur
     */
    public BigInteger getVal() {
        return this.valeur;
    }

    /**
     * Définition de l'attribut this.valeur avec un BigInteger passé en paramètre.
     * 
     * @param v
     */
    public void setVal(BigInteger v) {
        this.valeur = v;
    }

    /**
     * Accesseur en lecture de l'attribut suivant.
     * 
     * @return this.suivant
     */
    public Maillon getSuiv() {
        return this.suivant;
    }

    /**
     * Définition de l'attribut this.suivant avec un Maillon passé en paramètre.
     * 
     * @param m
     */
    public void setSuiv(Maillon m) {
        this.suivant = m;
    }

    /**
     * Méthode toString
     * Action: retourne un affichage de la valeur du maillon this.
     * 
     * @return un chaîne de caractères.
     */
    public String toString() {
        return String.valueOf(this.valeur);
    }

}
