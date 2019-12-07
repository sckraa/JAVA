import java.util.Scanner;
import java.util.function.Function;

public class Pokedeck {
    public static void main(String[] args) {

        // Swing Panel
        //Menu swingMenu = new Menu();

        // Terminal
        System.out.println("POKEDECK v1-Terminal");
        //Card carte1 = new TrainerCard(1, "carte1", "Trainer" ,"trainer", TrainerType.Item);
        //Card carte2 = new EnergyCard(2, "carte2", "Energy", "energy", EnergyType.Darkness);
        //Card carte3 = new PokemonCard(3, "carte3", "Pokemon", "pokemon", 90, PokemonStage.Stage2, EnergyType.Lightning);

        //Deck deck = new Deck();

        //deck.addCard(carte1);
        //deck.addCard(carte2);
        //deck.addCard(carte3);

        Scanner scanner = new Scanner(System.in);

        MainPanel menu = new MainPanel( scanner );

        menu.start();

        //deck.showDeck();
    }
}
