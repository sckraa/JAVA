public class Bataille {
    public static void main(String[] args) {

        // Création de deux joueurs
        Joueur joueur = new Joueur();
        Joueur adversaire = new Joueur();


        // Création du paquet
        // Carte carte = new Carte();
        // System.out.println(carte.creationPaquet());

        // Création du paquet de chaque joueur
        joueur.repartirionCarte(Carte.creationPaquet(), adversaire);

        System.out.println(" --- Joueur ---");
        joueur.afficherPaquet();

        System.out.println("\n --- Adversaire ---");
        adversaire.afficherPaquet();

        joueur.jouer(adversaire);

        System.out.println("\n --- Joueur ---");
        joueur.afficherPaquet();

        System.out.println("\n --- Adversaire ---");
        adversaire.afficherPaquet();


        /*
            |- Créer paquet de chaque joueur
            |- Tant que le paquet du joueur ou le paquet de l'adversaire n'est pas vide
            |----- Comparer chaque carte du paquet des joueurs
            |--------- Si la carte du joeur et plus forte que la carte de l'adversaire
            |------------- Ajouter les deux cartes à la fin du paquet du joueur
            |--------- Sinon
            |------------- Ajouet les deux cartes à la fin du paquet de l'adversaire
            |- Si le paquet joueur ou le paquet de l'adversaire est vide
            |----- Ajouter +1 au score du joueur ou adversaire
        */

    }
}