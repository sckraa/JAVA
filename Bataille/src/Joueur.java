import java.util.ArrayList;
import java.util.Collections;

public class Joueur {

    private ArrayList<Carte> paquet;
    private int score;

    public Joueur() {
        this.score = 0;
        this.paquet = new ArrayList<Carte>();
    }

    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }

    public int getScore() {
        return this.score;
    }

    public void afficherPaquet() {
        System.out.println("Paquet :");
        for(int i=0; i<paquet.size(); i++) {
            System.out.print(paquet.get(i));
        }
    }

    @Override
    public String toString() {
        String s = "Score :" + this.score + "\nPaquet :" + this.paquet.size() ;
        return s;
    }

    public void repartirionCarte(ArrayList<Carte> paquetCarte, Joueur adversaire) {
        for(int i=0; i<paquetCarte.size(); i++) {
            if(i%2 == 0) {
                this.paquet.add(paquetCarte.get(i));
            } else {
                adversaire.paquet.add(paquetCarte.get(i));
            }
        }
    }

    public void jouer(Joueur adversaire) {
        int i = this.getPaquet().size();
        int j = adversaire.getPaquet().size();
        System.out.println("\n" + i + " " + j);

        while (i!=0 && j!=0) {
            String resultat = this.getPaquet().get(0).comparateur(adversaire.getPaquet().get(0));
            if (resultat == "Votre carte est moins forte que la carte de l'adversaire") {
                System.out.println("\n" + resultat);
                adversaire.getPaquet().add(this.getPaquet().get(0));
                this.getPaquet().remove(this.getPaquet().get(0));
            } else if (resultat == "Votre carte est plus forte que la carte de l'adversaire") {
                System.out.println("\n" + resultat);
                this.getPaquet().add(adversaire.getPaquet().get(0));
                adversaire.getPaquet().remove(adversaire.getPaquet().get(0));
            } else {
                System.out.println("\n" + resultat);

                String message = this.getPaquet().get(1).comparateur(adversaire.getPaquet().get(1));
                if (message == "Votre carte est moins forte que la carte de l'adversaire" ) {
                    adversaire.getPaquet().add(this.getPaquet().get(1));
                    adversaire.getPaquet().add(this.getPaquet().get(0));

                    this.getPaquet().remove(this.getPaquet().get(0));
                    this.getPaquet().remove(this.getPaquet().get(0));

                    adversaire.getPaquet().add(adversaire.getPaquet().get(1));
                    adversaire.getPaquet().add(adversaire.getPaquet().get(0));

                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));
                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));
                    Collections.shuffle(adversaire.getPaquet());

                } else if (message == "Votre carte est plus forte que la carte de l'adversaire") {
                    this.getPaquet().add(adversaire.getPaquet().get(1));
                    this.getPaquet().add(adversaire.getPaquet().get(0));

                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));
                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                    this.getPaquet().add(this.getPaquet().get(1));
                    this.getPaquet().add(this.getPaquet().get(0));

                    this.getPaquet().remove(this.getPaquet().get(0));
                    this.getPaquet().remove(this.getPaquet().get(0));
                    Collections.shuffle(this.getPaquet());
                }
            }

            i = this.getPaquet().size();
            j = adversaire.getPaquet().size();
            System.out.println(i + " " + j);
        }

    }
}
