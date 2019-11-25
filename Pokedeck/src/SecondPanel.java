import java.util.Scanner;

public class SecondPanel {
    private Scanner scanner;
    private Integer id;
    private String choice;
    private String description;

    // Builder
    public SecondPanel() {
        this.scanner = null;
        this.id = null;
        this.choice = "";
    }

    public SecondPanel( Scanner scanner ) {
        this.scanner = scanner;
    }

    // Methods
    public void addCard( Deck deckUser ) {
        System.out.println("Choice the type of card what you want to add : ");
        System.out.println("1 - Energy \t 2 - Trainer \t 3 - Pokemon");
        this.choice = scanner.nextLine();
        int choiceMenu = Integer.parseInt( choice );
        Card card = createCard( deckUser, choiceMenu );
        deckUser.addCard( card );
    }

    public Card createCard ( Deck deckUser, int idMenu ) {
        int i = 1;
        int cardId;

        // Create Energy Card
        if ( idMenu == 1 ) {
            EnergyType energyType;

            System.out.println("You have chosen to create an Energy card");
            // Renaming of the ID
            System.out.println("Please choice the ID of the card :");
            do {
                this.choice = scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idBusy( cardId ) ) {
                    System.out.println("Please enter a new ID, the id you have chosen is busy.");
                }
            } while ( deckUser.idBusy( cardId ) );

            // Renaming the energy type
            System.out.println("Please choice the energy type : ");
            for ( EnergyType energy : EnergyType.values() ) {
                System.out.println( i + ". " + energy );
                i++;
            }

            this.choice = scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            energyType = EnergyType.values()[this.id];

            // Renaming the description of the card
            System.out.println("Please enter the description of the card : ");
            this.description = scanner.nextLine();

            // Successful addition
            System.out.println("Card successfully added !");

            return new EnergyCard( cardId, "X", energyType, this.description );
        }
        // Create Trainer Card
        else if ( idMenu == 2 ) {
            TrainerType trainerType;
            String itemName;

            System.out.println("You have chosen to create a Trainer card");

            // Renaming of the ID
            System.out.println("Please choice the ID of the card :");
            do {
                this.choice = this.scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idBusy( cardId ) ) {
                    System.out.println("Please enter a new ID, the id you have chosen is busy.");
                }
            } while ( deckUser.idBusy( cardId ) );

            // Renaming of the name
            System.out.println("Please choice the name of the card : ");
            itemName = this.scanner.nextLine();

            // Renaming the trainer type
            System.out.println("Please choice the trainer type : ");
            for ( TrainerType trainer : TrainerType.values() ) {
                System.out.println( i + ". " + trainer );
                i++;
            }

            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            trainerType = TrainerType.values()[this.id];

            // Renaming the description of the card
            System.out.println("Please enter the description of the card : ");
            this.description = scanner.nextLine();

            return new TrainerCard( cardId, itemName, trainerType, this.description );
        }
        // Create Pokemon Card
        else if ( idMenu == 3 ) {
            String pokemonName;
            Integer hp;
            PokemonStage stagePokemon;
            EnergyType energyType;

            System.out.println("You have chosen to create a Pokemon card");

            // Renaming of the ID
            System.out.println("Please choice the ID of the card :");
            do {
                this.choice = this.scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idBusy( cardId ) ) {
                    System.out.println("Please enter a new ID, the id you have chosen is busy.");
                }
            } while ( deckUser.idBusy( cardId ) );

            // Renaming of the name
            System.out.println("Please choice the name of the card : ");
            pokemonName = this.scanner.nextLine();

            // Pokemon life information
            System.out.println( "Please choice the life of pokemon : " );
            this.choice = this.scanner.nextLine();
            hp = Integer.parseInt( this.choice );

            // Pokemon stage information
            System.out.println( "Please choice the stage of pokemon : " );
            for (PokemonStage stage : PokemonStage.values() ) {
                System.out.println( i + ". " + stage );
                i++;
            }
            i=1;

            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            stagePokemon = PokemonStage.values()[this.id];

            // Renaming the energy type
            System.out.println("Please choice the energy type : ");
            for ( EnergyType energy : EnergyType.values() ) {
                System.out.println( i + ". " + energy );
                i++;
            }

            this.choice = scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            energyType = EnergyType.values()[this.id];

            // Renaming the description of the card
            System.out.println("Please enter the description of the card : ");
            this.description = scanner.nextLine();

            return new PokemonCard( cardId, pokemonName, hp, stagePokemon, energyType, this.description );
        }

        return null;
    }

}
