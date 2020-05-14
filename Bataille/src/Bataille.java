import java.util.Scanner;

public class Bataille {
    public static void main(String[] args) {

        System.out.println("***********************\n" +
                           "** Bataille de carte **\n" +
                           "***********************\n");

        // Création de deux joueurs
        Joueur joueur = new Joueur();
        Joueur adversaire = new Joueur();

        // Nombre de parties à jouer
        Scanner sc = new Scanner(System.in);
        System.out.print("Saisissez le nombre de parties à jouer (entre 1 et 20): ");
        int nbParties = sc.nextInt();
        while(nbParties<0 || nbParties>20) {
            System.out.print("Saisissez une valeur entre 1 et 20 : ");
            nbParties = sc.nextInt();
        }
        System.out.println("\nVous avez choisi de jouer " + nbParties + " parties.");


        // Création du paquet
        // Carte carte = new Carte();
        // System.out.println(carte.creationPaquet());

        // Création du paquet de chaque joueur
        // joueur.repartitionCarte(Carte.creationPaquet(), adversaire);
        /*
        System.out.println(" --- Joueur ---");
        joueur.afficherPaquet();

        System.out.println("\n --- Adversaire ---");
        adversaire.afficherPaquet();
        */
        for(int i=0; i<nbParties; i++) {
            joueur.repartitionCarte(Carte.creationPaquet(), adversaire);
            joueur.jouer(adversaire);
        }
        /*
        System.out.println("\n --- Joueur ---");
        joueur.afficherPaquet();

        System.out.println("\n --- Adversaire ---");
        adversaire.afficherPaquet();
        */
        System.out.println("\nScore joueur:" + joueur.getScore() + "\nScore adversaire :" + adversaire.getScore());

    }
}