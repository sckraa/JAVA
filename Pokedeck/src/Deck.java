import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    // Builders
    public Deck() {
        this.deck = new ArrayList<>();
    }

    // Methods
    public void addCard( Card card ) {
        this.deck.add( card );
    }

    public boolean deleteCard( Integer id ) {
        for ( Card card : deck ) {
            if ( card.getId() == id ) {
                System.out.println( "Card successfully deleted" );
                return deck.remove(card);
            }
        }
        return false;
    }

    public void showDeck() {
        for ( Card card : deck ) {
            System.out.println( card.toString() );
        }
    }

    public boolean idBusy( Integer id ) {
        for ( Card card : deck ) {
            if ( card.getId() == id ) {
                return true;
            }
        }
        return false;
    }
}
