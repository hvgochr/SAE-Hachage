import java.util.Random;

public class main {

    public static void main(String[] args) {
        Random random = new Random();
        double f = 0.1;
        Dictionnaire d = new Dictionnaire("LeRougeEtLeNoir.txt", f);
        System.out.println("maxSize : " + d.getMaxSize());
        System.out.println("cardinal : " + d.getCardinal());
        System.out.println("nbListes : " + d.getNbListes());
        System.out.println("Temps total du calcul de la fonction h: " + d.getTotalTimeH() + "ms");
        System.out.println("Temps total d'appel à la méthode contient: " + d.getTotalTimeContient() + "ms");
        int nbRecherches = 100000;
        long deb = System.currentTimeMillis();
        for (int i = 0; i < nbRecherches; i++) {
            int tailleMot = random.nextInt(15) + 2;
            char[] mot = new char[tailleMot];
            for (int j = 0; j < mot.length; j++) {
                mot[j] = (char) ('a' + random.nextInt(26));
            }
            String motS = new String(mot);
            d.contient(motS);
        }
        long fin = System.currentTimeMillis();
        System.out.println("temps total : " + (fin - deb) + " ms");
    }
}
