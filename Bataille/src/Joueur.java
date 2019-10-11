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
        ArrayList<Carte> paquetPartie = new ArrayList<Carte>();
        int i = this.getPaquet().size();
        int j = adversaire.getPaquet().size();

        System.out.println("\n" + i + " " + j);

        while (i!=0 && j!=0) {
            paquetPartie.add(this.getPaquet().get(0));
            paquetPartie.add(adversaire.getPaquet().get(0));

            this.getPaquet().remove(this.getPaquet().get(0));
            adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

            String resultat1 = paquetPartie.get(0).comparateur(paquetPartie.get(1));
            if(resultat1 == "Votre carte est moins forte que la carte de l'adversaire") {
                adversaire.getPaquet().add(paquetPartie.get(0));
                adversaire.getPaquet().add(paquetPartie.get(1));
                paquetPartie.clear();
            } else if(resultat1 == "Votre carte est plus forte que la carte de l'adversaire") {
                this.getPaquet().add(paquetPartie.get(1));
                this.getPaquet().add(paquetPartie.get(0));
                paquetPartie.clear();
            } else {
                paquetPartie.add(this.getPaquet().get(0));
                this.getPaquet().remove(this.getPaquet().get(0));
                paquetPartie.add(adversaire.getPaquet().get(0));
                adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                paquetPartie.add(this.getPaquet().get(0));
                this.getPaquet().remove(this.getPaquet().get(0));
                paquetPartie.add(adversaire.getPaquet().get(0));
                adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                String resultat2 = paquetPartie.get(4).comparateur(paquetPartie.get(5));
                if(resultat2 == "Votre carte est moins forte que la carte de l'adversaire"){
                    for(int n=0; n<6; n++) {
                        adversaire.getPaquet().add(paquetPartie.get(n));
                    }
                    paquetPartie.clear();
                } else if(resultat2 == "Votre carte est plus forte que la carte de l'adversaire") {
                    for(int m=0; m<6; m++) {
                        this.getPaquet().add(paquetPartie.get(m));
                    }
                    paquetPartie.clear();
                } else {
                    paquetPartie.add(this.getPaquet().get(0));
                    this.getPaquet().remove(this.getPaquet().get(0));
                    paquetPartie.add(adversaire.getPaquet().get(0));
                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                    paquetPartie.add(this.getPaquet().get(0));
                    this.getPaquet().remove(this.getPaquet().get(0));
                    paquetPartie.add(adversaire.getPaquet().get(0));
                    adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                    String resultat3 = paquetPartie.get(8).comparateur(paquetPartie.get(9));
                    if(resultat3 == "Votre carte est moins forte que la carte de l'adversaire"){
                        for(int k=0; k<10; k++) {
                            adversaire.getPaquet().add(paquetPartie.get(k));
                        }
                        paquetPartie.clear();
                    } else if(resultat3 == "Votre carte est plus forte que la carte de l'adversaire") {
                        for(int l=0; l<10; l++) {
                            this.getPaquet().add(paquetPartie.get(l));
                        }
                        paquetPartie.clear();
                    } else {
                        paquetPartie.add(this.getPaquet().get(0));
                        this.getPaquet().remove(this.getPaquet().get(0));
                        paquetPartie.add(adversaire.getPaquet().get(0));
                        adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                        paquetPartie.add(this.getPaquet().get(0));
                        this.getPaquet().remove(this.getPaquet().get(0));
                        paquetPartie.add(adversaire.getPaquet().get(0));
                        adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                        String resultat4 = paquetPartie.get(12).comparateur(paquetPartie.get(13));
                        if(resultat4 == "Votre carte est moins forte que la carte de l'adversaire"){
                            for(int c=0; c<14; c++) {
                                adversaire.getPaquet().add(paquetPartie.get(c));
                            }
                            paquetPartie.clear();
                        } else if(resultat4 == "Votre carte est plus forte que la carte de l'adversaire") {
                            for(int v=0; v<14; v++) {
                                this.getPaquet().add(paquetPartie.get(v));
                            }
                            paquetPartie.clear();
                        } else {
                            paquetPartie.add(this.getPaquet().get(0));
                            this.getPaquet().remove(this.getPaquet().get(0));
                            paquetPartie.add(adversaire.getPaquet().get(0));
                            adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                            paquetPartie.add(this.getPaquet().get(0));
                            this.getPaquet().remove(this.getPaquet().get(0));
                            paquetPartie.add(adversaire.getPaquet().get(0));
                            adversaire.getPaquet().remove(adversaire.getPaquet().get(0));

                            String resultat5 = paquetPartie.get(16).comparateur(paquetPartie.get(17));
                            if(resultat5 == "Votre carte est moins forte que la carte de l'adversaire"){
                                for(int w=0; w<18; w++) {
                                    adversaire.getPaquet().add(paquetPartie.get(w));
                                }
                                paquetPartie.clear();
                            } else if(resultat5 == "Votre carte est plus forte que la carte de l'adversaire") {
                                for(int x=0; x<18; x++) {
                                    this.getPaquet().add(paquetPartie.get(x));
                                }
                                paquetPartie.clear();
                            }
                        }
                    }
                }
            }

            i = this.getPaquet().size();
            j = adversaire.getPaquet().size();
            System.out.println(i + " " + j);
        }

    }
}
