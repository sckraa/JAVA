import java.util.Scanner;

public class MainPanel {
    private Scanner scanner;
    private String choice = "1";

    public MainPanel() {
        System.out.println("\t Menu \t");
        System.out.println("0 - Exit");
        System.out.println("1 - Display deck");
        System.out.println("2 - Add Card");
        System.out.println("3 - Delete Card");
        System.out.println("4 - Search Card");
    }

    public MainPanel ( Scanner scanner ) {
        this.scanner = scanner;
    }

    public void start () {
        System.out.println("Hello");
        System.out.println("-----  What you want to do ? -----");

        while ( Integer.parseInt( choice ) != 0 ) {
            new MainPanel();
            userChoice();
        }
    }

    public void userChoice() {
        this.choice = scanner.nextLine();
        int userChoice = Integer.parseInt( this.choice );

        if ( this.choice.equals( "" ) ) {
            this.choice = "0";
            System.out.println("Make a choice");
        }

        if ( userChoice == 0 ) {
            System.out.println( "Good bye!" );
        } else if ( userChoice == 1 ) {
            System.out.println( "Choice = 1" );
        } else if ( userChoice == 2 ) {
            System.out.println( "Choice = 2" );
        } else if ( userChoice == 3 ) {
            System.out.println( "Choice = 3" );
        } else if ( userChoice == 4 ) {
            System.out.println( "Choice = 4" );
        } else if ( userChoice == 5 ) {
            System.out.println( "Choice = 5" );
        } else {
            System.out.println( "Wrong choice number." );
        }
    }
}
