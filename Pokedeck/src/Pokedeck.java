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
        Card pika = new PokemonCard( 1, "Pikachu", 100, PokemonStage.Basic, EnergyType.Lightning, "best pokemon");

        Card lightning = new EnergyCard( 2, "pika", EnergyType.Lightning, "mini description" );
        Card fighting = new EnergyCard( 3, "toto", EnergyType.Fighting, "mini description");

        Card stadium = new TrainerCard( 4, "Stadium", TrainerType.Stadium, "description");

        pokedeck.addCard(pika);
        pokedeck.addCard(lightning);
        pokedeck.addCard(fighting);
        pokedeck.addCard(stadium);

        pokedeck.showDeck();

    }
}
