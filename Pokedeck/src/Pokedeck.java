import java.util.Scanner;

public class Pokedeck {
    public static void main(String[] args) {
        //System.out.println("POKEDECK v1-Terminal");

        //Scanner scanner = new Scanner(System.in);

        //MainPanel menu = new MainPanel(scanner);

        //menu.start();

        Card pika = new Card(1,"pika", "electro", "powerful card");
        Card toto = new Card(2,"toto", "feu", "powerful card");
        Card titi = new Card(3,"titi", "vent", "powerful card");
/*
        System.out.println( pika.toString() );
        System.out.println( toto.toString() );
        System.out.println( titi.toString() );
*/
        System.out.println("----- ------ -----");

        Deck pokedeck = new Deck();
        pokedeck.addCard(pika);
        pokedeck.addCard(toto);
        pokedeck.addCard(titi);

        pokedeck.showDeck();

        // Delete card
        pokedeck.deleteCard(1);
        pokedeck.showDeck();

    }
}
