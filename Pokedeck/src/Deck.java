import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable {

    private static final long serialVersionUID = 99L;
    private ArrayList<Card> deck;

    // Builders
    public Deck() {
        this.deck = new ArrayList<>();
    }

    // Getter
    public Integer sizeDeck() {
        return  this.deck.size();
    }

    // Methods
    public boolean idIsBusy( int id ) {
        for ( Card card : this.deck ) {
            if ( card.getId() == id ) {
                return true;
            }
        }
        return false;
    }

    public void addCard( Card card ) {
        this.deck.add( card );
    }

    public boolean deleteCard( int id ) {
        for ( Card card : this.deck ) {
            if ( card.getId() == id ) {
                return this.deck.remove( card );
            }
        }
        return false;
    }

    public void showDeck() {
        System.out.println( "Pokedeck :" );
        for ( Card card : this.deck ) {
            System.out.println( "\t" + card.toString() );
        }
    }

    public String showCardById( int id ) {
        for ( Card card : this.deck ) {
            if ( card.getId() == id ) {
                return card.toString();
            }
        }
        return "\tThe card with id = " + id + " does not exist";
    }

    public void showCardByType( String type ) {
        for ( Card card : this.deck ) {
            if ( card.getType().equals( type ) ) {
                System.out.println( card.toString() );
            }
        }
    }

    public void changeDescription( int id, String description ) {
        for ( Card card : this.deck ) {
            if ( card.getId() == id ) {
                card.setDescription( description );
            }
        }
    }
}
