import java.util.ArrayList;
import java.util.Collections;

public class Joueur {

    private ArrayList<Carte> paquet;
    private int score;

        // Constructeurs
    public Joueur() {
        this.score = 0;
        this.paquet = new ArrayList<Carte>();
    }

        // Getters
    public ArrayList<Carte> getPaquet() {
        return this.paquet;
    }
    public int getScore() {
        return this.score;
    }
    public int nombreCarte() {
        return this.getPaquet().size();
    }

        // @Overrride toString
    @Override
    public String toString() {
        String s = "Score :" + this.score + "\nPaquet :" + this.paquet.size() ;
        return s;
    }

        // Methodes
    public void afficherPaquet() {
        System.out.println("Paquet :");
        for(int i=0; i<paquet.size(); i++) {
            System.out.print(paquet.get(i));
        }
        System.out.println("\nTaille :" + this.nombreCarte());
    }

    public boolean paquetVide() {
        if(this.getPaquet().size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Carte tirerCarte() {
        Carte carte = this.getPaquet().get(0);
        this.getPaquet().remove(carte);
        return carte;
    }

    public void ajouterCarte(Carte carte) {
        this.getPaquet().add(carte);
    }

    public void gagner() {
        this.score++;
    }

    public void repartitionCarte(ArrayList<Carte> paquetCarte, Joueur adversaire) {
        for(int i=0; i<paquetCarte.size(); i++) {
            if(i%2 == 0) {
                this.paquet.add(paquetCarte.get(i));
            } else {
                adversaire.paquet.add(paquetCarte.get(i));
            }
        }
    }

    public boolean verifEgalite(Joueur adversaire) {
        if(!this.paquetVide() && !adversaire.paquetVide()) {
            Carte carteJoueur = this.tirerCarte();
            Carte carteAdversaire = adversaire.tirerCarte();
            int taillePaquet = this.nombreCarte();
            String resultat = carteJoueur.comparateur(carteAdversaire);

            if(resultat == "Votre carte est moins forte que la carte de l'adversaire") {
                // System.out.println(resultat);
                adversaire.ajouterCarte(carteAdversaire);
                adversaire.ajouterCarte(carteJoueur);
                return true;
            } else if (resultat == "Votre carte est plus forte que la carte de l'adversaire") {
                // System.out.println(resultat);
                this.ajouterCarte(carteJoueur);
                this.ajouterCarte(carteAdversaire);
                return true;
            } else {
                // System.out.println(resultat);
                if(this.verifEgalite(adversaire)) {
                    if(taillePaquet < this.nombreCarte()) {
                        this.ajouterCarte(carteJoueur);
                        this.ajouterCarte(carteAdversaire);
                        return true;
                    } else if (taillePaquet > this.nombreCarte()) {
                        adversaire.ajouterCarte(carteAdversaire);
                        adversaire.ajouterCarte(carteJoueur);
                        return true;
                    }
                } else {
                    if(this.nombreCarte() == 0) {
                        adversaire.ajouterCarte(carteAdversaire);
                        adversaire.ajouterCarte(carteJoueur);
                        return true;
                    } else {
                        this.ajouterCarte(carteJoueur);
                        this.ajouterCarte(carteAdversaire);
                    }
                }

            }
        }
        return false;
    }

    public void jouer(Joueur adversaire) {
        while (!this.paquetVide() && !adversaire.paquetVide()) {
            Carte carteJoueur = this.tirerCarte();
            Carte carteAdversaire = adversaire.tirerCarte();
            String resultat = carteJoueur.comparateur(carteAdversaire);

            if(resultat.equals("Votre carte est moins forte que la carte de l'adversaire")) {
                // System.out.println(resultat);
                adversaire.ajouterCarte(carteAdversaire);
                adversaire.ajouterCarte(carteJoueur);
            } else if(resultat.equals("Votre carte est plus forte que la carte de l'adversaire")) {
                // System.out.println(resultat);
                this.ajouterCarte(carteJoueur);
                this.ajouterCarte(carteAdversaire);
            } else {
                // System.out.println(resultat);
                int nbCartes = this.nombreCarte();
                if(this.verifEgalite(adversaire)) {
                    if(nbCartes < this.nombreCarte()) {
                        this.ajouterCarte(carteJoueur);
                        this.ajouterCarte(carteAdversaire);
                    } else if(nbCartes > this.nombreCarte()) {
                        adversaire.ajouterCarte(carteAdversaire);
                        adversaire.ajouterCarte(carteJoueur);
                    }
                } else {
                    if(this.nombreCarte() == 0) {
                        adversaire.ajouterCarte(carteAdversaire);
                        adversaire.ajouterCarte(carteJoueur);
                    } else {
                        this.ajouterCarte(carteJoueur);
                        this.ajouterCarte(carteAdversaire);
                    }
                }
            }
            // System.out.println("Joueur :" + this.nombreCarte() + " Adversaire : " + adversaire.nombreCarte());
        }

        if(this.nombreCarte() == 0) {
            adversaire.gagner();
        } else {
            this.gagner();
        }
    }
}
