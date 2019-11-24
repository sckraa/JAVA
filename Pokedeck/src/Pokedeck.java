import java.util.Scanner;

public class Pokedeck {
    public static void main(String[] args) {
        //System.out.println("POKEDECK v1-Terminal");

        //Scanner scanner = new Scanner(System.in);

        //MainPanel menu = new MainPanel(scanner);

        //menu.start();

        System.out.println("----- ------ -----");

        // Creation of a deck
        Deck pokedeck = new Deck();

        //Creation of cards
        Card pika = new EnergyCard( 1, "pika", EnergyType.Lightning, "mini description" );
        Card toto = new EnergyCard( 2, "toto", EnergyType.Fighting, "mini description");

        Card stadium = new TrainerCard( 3, "Stadium", TrainerType.Stadium, "description");

        pokedeck.addCard(pika);
        pokedeck.addCard(toto);
        pokedeck.addCard(stadium);

        pokedeck.showDeck();

    }
}
