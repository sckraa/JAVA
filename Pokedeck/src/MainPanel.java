import java.io.*;
import java.util.Scanner;

public class MainPanel {

    private Scanner scanner;
    private String choice = "1";
    private Deck deckUser;
    private SecondPanel secondPanel;

    // Builders
    public MainPanel() {
        System.out.println( "\n---------- Menu ----------" );
        System.out.println( "0 - Exit | 1 - Display deck | 2 - Add Card | 3 - Delete Card | 4 - Edit Card | 5 - Search Card" );
    }

    public MainPanel ( Scanner scanner ) {
        this.scanner = scanner;
        this.secondPanel = new SecondPanel( scanner );
        this.deckUser = new Deck();
        createDeck();
    }

    // Methods

    // Launching the programme
    public void start () {
        System.out.println( "-----          Hello         -----" );
        System.out.println( "-----  What you want to do ? -----" );

        while ( Integer.parseInt( this.choice ) != 0 ) {
            new MainPanel();
            userChoice();
        }
    }

    // Ask for a choice
    public void userChoice() {
        this.choice = this.scanner.nextLine();

        if ( this.choice.equals( "" ) ) {
            System.out.println( "\tPlease enter a proposed number from the list\n" );
            new MainPanel();
            userChoice();
        } else {
            int userChoice = Integer.parseInt( this.choice );

            if ( userChoice == 0 ) {
                System.out.println( "\tGood bye!" );
                saveDeck();
            }
            else if ( userChoice == 1 ) {
                if ( this.deckUser.sizeDeck() == 0 ) {
                    System.out.println( "\tYour deck is empty \n");
                } else {
                    this.deckUser.showDeck();
                }
            }
            else if ( userChoice == 2 ) {
                this.secondPanel.addCard( this.deckUser );
            }
            else if ( userChoice == 3 ) {
                this.secondPanel.deleteCard( this.deckUser );
            }
            else if ( userChoice == 4 ) {
                this.secondPanel.editCard( this.deckUser );
            }
            else if ( userChoice == 5 ) {
                this.secondPanel.searchCard( this.deckUser );
            }
            else {
                System.out.println( "\tWrong choice number." );
                System.out.println( "\tPlease enter a proposed number from the list\n" );
            }
        }

    }

    // Create a deck in the file deck.serial
    private void createDeck () {
        this.deckUser = null;
        try {
            FileInputStream fileInputStream = new FileInputStream( "out/production/Pokedeck/deck.serial" );
            ObjectInputStream objectInputStream = new ObjectInputStream( fileInputStream );

            try {
                this.deckUser = (Deck) objectInputStream.readObject();
            } finally {
                try {
                    objectInputStream.close();
                } finally {
                    fileInputStream.close();
                }
            }
        } catch ( IOException | ClassNotFoundException exception ) {
            exception.printStackTrace();
        }
        if ( this.deckUser == null ) {
            this.deckUser = new Deck();
        }
    }

    // Save the deck in the file deck.serial
    private void saveDeck () {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream( "src/deck.serial" );
            ObjectOutputStream objectOutputStream = new ObjectOutputStream( fileOutputStream );

            try {
                objectOutputStream.writeObject( this.deckUser );
                objectOutputStream.flush();
            } finally {
                try {
                    objectOutputStream.close();
                } finally {
                    objectOutputStream.close();
                }
            }
        } catch ( IOException ioeException ) {
            ioeException.printStackTrace();
        }
    }

}
