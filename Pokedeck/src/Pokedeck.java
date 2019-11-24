import java.util.Scanner;

public class Pokedeck {
    public static void main(String[] args) {
        //System.out.println("POKEDECK v1-Terminal");

        //Scanner scanner = new Scanner(System.in);

        //MainPanel menu = new MainPanel(scanner);

        //menu.start();

        Card pika = new Card(1,"pika", "electro", "powerful card");
        System.out.println( pika.toString() );
    }
}
