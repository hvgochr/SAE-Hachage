import java.math.BigInteger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionnaire {

    private HTNaive list;

    /**
     * Constructeur Dictionnaire
     * Action: Crée une table de listes de taille m.
     * 
     * @param m
     */
    public Dictionnaire(int m) {
        this.list = new HTNaive(m);
    }

    /**
     * Constructeur Dictionnaire
     * Action: Crée une table de listes de taille m, contenant une liste du fichier
     * en paramètre.
     * 
     * @param filename
     * @param m
     */
    public Dictionnaire(String filename, int m) {
        this.list = new HTNaive(Dictionnaire.calculeListeInt(filename), m);
    }

    /**
     * Constructeur Dictionnaire
     * Action: Crée une table de listes de taille f, contenant une liste du fichier
     * en paramètre.
     * 
     * @param filename
     * @param f
     */
    public Dictionnaire(String filename, double f) {
        this.list = new HTNaive(Dictionnaire.calculeListeInt(filename), f);
    }

    /**
     * Méthode stringToBigInteger
     * Action: Effectue la conversion d'une chaîne de caractères en entiers selon la
     * norme américaine ASCII.
     * 
     * @param s
     * @return un BigInteger
     */
    private static BigInteger stringToBigInteger(String s) {
        BigInteger res = new BigInteger("0");
        BigInteger coef = new BigInteger("1");
        for (int i = s.length() - 1; 0 <= i; i--) {
            res = res.add(BigInteger.valueOf((int) s.charAt(i)).multiply(coef));
            coef = coef.multiply(BigInteger.valueOf(256));
        }
        return res;
    }

    /**
     * Méthode ajout
     * Action: Ajoute un mot a this.
     * 
     * @param s
     * @return un booléen res
     */
    public boolean ajout(String s) {
        boolean res = false;
        BigInteger sToBigI = Dictionnaire.stringToBigInteger(s);
        if (this.list.ajout(sToBigI) == true) {
            res = true;
        }
        return res;
    }

    /**
     * Méthode contient
     * Action: Retourne vrai si this contient la chaîne de caractères passée en
     * paramètre.
     * 
     * @param s
     * @return un booléen
     */
    public boolean contient(String s) {
        boolean res = false;
        if (this.list.contient(stringToBigInteger(s))) {
            res = true;
        }
        return res;
    }

    /**
     * Accesseur en lecture du cardinal de this.
     * 
     * @return en entier
     */
    public int getCardinal() {
        return this.list.getCardinal();
    }

    /**
     * Accesseur en lecture de la liste la plus longue de this.
     * 
     * @return en entier
     */
    public int getMaxSize() {
        return this.list.getMaxSize();
    }

    /**
     * Accesseur en lecture du nombre de listes de this.
     * 
     * @return en entier
     */
    public int getNbListes() {
        return this.list.getNbListes();
    }

    /**
     * Accesseur en lecture du temps total de calcul de la fonction h.
     * 
     * @return en entier
     */
    public long getTotalTimeH() {
        return this.list.getTotalTimeH();
    }

    /**
     * Accesseur en lecture du temps total Contient de this.
     * 
     * @return en entier
     */
    public long getTotalTimeContient() {
        return this.list.getTotalTimeContient();
    }

    /**
     * Accesseur en lecture de la méthode toString de this.
     * 
     * @return une chaîne de caractères
     */
    public String toString() {
        return this.list.toString();
    }

    /**
     * Accesseur en lecture de la méthode toStringV2 de this.
     * 
     * @return une chaîne de caractères
     */
    public String toStringV2() {
        return this.list.toStringV2();
    }

    /**
     * Méthode lectureMotsTexte
     * Action: Retourne le nombre de mots du texte passé en paramètre.
     * 
     * @return un entier nbMots
     */
    public int lectureMotsTexte(String filename) {
        File f = new File(filename);
        ListeBigI res = new ListeBigI();
        Scanner sc;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println(("Problème d’accès au fichier " + e.getMessage()));
            return 0;
        }
        sc.useDelimiter(" |\\n|,|;|:|\\.|!|\\?|-");
        int nbmots = 0;
        while (sc.hasNext()) {
            String mot = sc.next();
            nbmots++;
        }
        return nbmots;
    }

    /**
     * Méthode calculeListeInt
     * Action: Retourne une liste de tous les entiers correspondant aux mots du
     * fichier passé en paramètre.
     * 
     * @param fileName
     * @return une Liste de BigInteger
     */
    public static ListeBigI calculeListeInt(String fileName) {
        File f = new File(fileName);
        ListeBigI res = new ListeBigI();
        Scanner sc;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println(("Problème d’accès au fichier " + e.getMessage()));
            return null;
        }
        sc.useDelimiter(" |\\n|,|;|:|\\.|!|\\?|-");
        String mot;
        while (sc.hasNext()) {
            mot = sc.next();
            res.ajoutTete(Dictionnaire.stringToBigInteger(mot));
        }
        sc.close();
        return res;
    }

}
