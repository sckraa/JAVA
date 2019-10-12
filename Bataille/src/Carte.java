import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Carte {

    // Attributs
    private static String[] valeur = {"2","3","4","5","6","7","8","9","10","V","D","R","A"};
    private static String[] couleur = {"carreau","coeur","pique","trefle"};
    private String val;
    private String form;

    // Constructeur
    public Carte() {
        this.val = "";
        this.form = "";
    }

    public Carte(String val, String form) {
        if(existe(valeur, val) && existe(couleur,form)) {
            this.val = val;
            this.form = form;
        }else {
            this.val = "";
            this.form = "";
        }
    }

    // Getters
    public String getVal() { return this.val; }
    public String getForm() { return this.form; }

    // Setters
    public void setValeur(String valeur) { this.val = valeur; }
    public void setForm(String form) { this.form = form; }

    // Méthodes
    static public boolean existe(String[] valeur, String val) {
        return Arrays.toString(valeur).contains(val);
    }

    public String comparateur(Carte adverse) {
        int a = 15;
        int b = 15;

        for(int i=0; i<valeur.length; i++) {
            if(valeur[i].equals(this.val)) {
                a = i;
            }
        }

        for(int i=0; i<valeur.length; i++) {
            if(valeur[i].equals(adverse.val)) {
                b = i;
            }
        }

        if (a < b) {
            return "Votre carte est moins forte que la carte de l'adversaire";
        } else if(a > b) {
            return "Votre carte est plus forte que la carte de l'adversaire";
        } else {
            return "Egalité";
        }
    }

    @Override
    public String toString() {
        String s = " (" + this.val + "," + this.form + ")";
        return s;
    }

    public static ArrayList<Carte> creationPaquet() {
        // Nombre aléatoire entre 7 et 20
        int randomNum = ThreadLocalRandom.current().nextInt(20, 35 + 1);

        ArrayList<Carte> paquet= new ArrayList<Carte>();
            // Créer le paquet
        for(int i=0; i<valeur.length; i++){
            for(int j=0; j<couleur.length; j++) {
                paquet.add(new Carte(valeur[i], couleur[j]));
            }
        }
            // Mélanger le paquet
        for(int i=0; i<randomNum; i++) {
            Collections.shuffle(paquet);
        }

        return paquet;
    }
}

