import java.util.Scanner;

public class SecondPanel {
    private Scanner scanner;
    private Integer id;
    private String choice;

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

    // Adding a card in the deck
    public void addCard( Deck deckUser ) {
        System.out.println( "\tChoice the type of card what you want to add : " );
        System.out.println( "\t1 - Energy \t 2 - Trainer \t 3 - Pokemon" );
        this.choice = scanner.nextLine();
        int choiceMenu = Integer.parseInt( this.choice );
        Card card = createCard( deckUser, choiceMenu );
        deckUser.addCard( card );
    }

    // Creating a card in the deck
    public Card createCard ( Deck deckUser, int idMenu ) {
        int i = 0;
        int cardId;
        String description;

        // Create Energy Card
        if ( idMenu == 1 ) {
            EnergyType energyType;

            System.out.println( "\tYou have chosen to create an Energy card" );
            // Renaming of the ID
            System.out.println( "\tPlease choice the ID of the card :" );
            do {
                this.choice = scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idIsBusy( cardId ) ) {
                    System.out.println( "\tPlease enter a new ID, the id you have chosen is busy." );
                }
            } while ( deckUser.idIsBusy( cardId ) );

            // Renaming the energy type
            System.out.println( "\tPlease choice the energy type : " );
            for ( EnergyType energy : EnergyType.values() ) {
                System.out.println( "\t" + i + ". " + energy );
                i++;
            }
            i=0;

            this.choice = scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            energyType = EnergyType.values()[this.id];

            // Renaming the description of the card
            System.out.println( "\tPlease enter the description of the card : " );
            description = scanner.nextLine();

            // Successful addition
            System.out.println( "\tCard successfully added !" );

            return new EnergyCard( cardId, "X", "Energy", description, energyType) ;
        }
        // Create Trainer Card
        else if ( idMenu == 2 ) {
            TrainerType trainerType;
            String itemName;

            System.out.println( "\tYou have chosen to create a Trainer card" );

            // Renaming of the ID
            System.out.println( "\tPlease choice the ID of the card :" );
            do {
                this.choice = this.scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idIsBusy( cardId ) ) {
                    System.out.println( "\tPlease enter a new ID, the id you have chosen is busy." );
                }
            } while ( deckUser.idIsBusy( cardId ) );

            // Renaming of the name
            System.out.println( "\tPlease choice the name of the card : " );
            itemName = this.scanner.nextLine();

            // Renaming the trainer type
            System.out.println( "\tPlease choice the trainer type : " );
            for ( TrainerType trainer : TrainerType.values() ) {
                System.out.println( "\t" + i + ". " + trainer );
                i++;
            }
            i=0;

            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            trainerType = TrainerType.values()[this.id];

            // Renaming the description of the card
            System.out.println( "\tPlease enter the description of the card : " );
            description = scanner.nextLine();

            // Successful addition
            System.out.println( "\tCard successfully added !" );

            return new TrainerCard( cardId, itemName, "Trainer", description, trainerType );
        }
        // Create Pokemon Card
        else if ( idMenu == 3 ) {
            String pokemonName;
            Integer hp;
            PokemonStage stagePokemon;
            EnergyType energyType;

            System.out.println( "\tYou have chosen to create a Pokemon card" );

            // Renaming of the ID
            System.out.println( "\tPlease choice the ID of the card :" );
            do {
                this.choice = this.scanner.nextLine();
                cardId = Integer.parseInt( this.choice );

                if ( deckUser.idIsBusy( cardId ) ) {
                    System.out.println( "\tPlease enter a new ID, the id you have chosen is busy." );
                }
            } while ( deckUser.idIsBusy( cardId ) );

            // Renaming of the name
            System.out.println( "\tPlease choice the name of the card : " );
            pokemonName = this.scanner.nextLine();

            // Pokemon life information
            System.out.println( "\tPlease choice the life of pokemon : " );
            this.choice = this.scanner.nextLine();
            hp = Integer.parseInt( this.choice );

            // Pokemon stage information
            System.out.println( "\tPlease choice the stage of pokemon : " );
            for (PokemonStage stage : PokemonStage.values() ) {
                System.out.println( "\t" + i + ". " + stage );
                i++;
            }
            i=0;

            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            stagePokemon = PokemonStage.values()[this.id];

            // Renaming the energy type
            System.out.println( "\tPlease choice the energy type : " );
            for ( EnergyType energy : EnergyType.values() ) {
                System.out.println( "\t" + i + ". " + energy );
                i++;
            }
            i=0;

            this.choice = scanner.nextLine();
            this.id = Integer.parseInt( this.choice );
            energyType = EnergyType.values()[this.id];

            // Renaming the description of the card
            System.out.println(	"\tPlease enter the description of the card : " );
            description = scanner.nextLine();

            // Successful addition
            System.out.println( "\tCard successfully added !" );

            return new PokemonCard( cardId, pokemonName, "Pokemon", description, hp, stagePokemon, energyType );
        }

        return null;
    }

    // Deleting a card in the deck
    public void deleteCard( Deck deckUser ) {
        int idCard;

        System.out.println( "\tPlease enter the ID of the card what you want to delete" );
        this.choice = this.scanner.nextLine();
        idCard = Integer.parseInt( this.choice );

        if ( !deckUser.idIsBusy( idCard ) ) {
            System.out.println( "\tThe card with this id does not exist." );
        }
        else if ( deckUser.idIsBusy( idCard ) ) {
            System.out.println( "\tAre you sure you want to delete this card?" );
            System.out.println( "\t" + deckUser.showCardById( idCard ) );

            System.out.println( "\t1 - Yes | 2 - No" );
            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );

            if ( this.id == 1 ) {
                deckUser.deleteCard( idCard );
                System.out.println( "\tThe card has been successfully deleted." );
            } else {
                System.out.println( "\tThe deletion of the card has been cancelled." );
            }
        }
        else {
            System.out.println( "\tDeletion error." );
        }

    }

    // Modifying a card in the deck
    public void editCard( Deck deckUser ) {
        int idCard;
        String newDescription;

        System.out.println( "\tPlease enter the ID of the card you want to modify" );
        this.choice = this.scanner.nextLine();
        idCard = Integer.parseInt( this.choice );

        if ( !deckUser.idIsBusy( idCard ) ) {
            System.out.println( "\tThe card with this id does not exist." );
        }
        else if ( deckUser.idIsBusy( idCard ) ) {
            System.out.println( "\tAre you sure you want to modify the description of this card?" );
            System.out.println( "\t" + deckUser.showCardById( idCard ) );

            System.out.println( "\t1 - Yes | 2 - No" );
            this.choice = this.scanner.nextLine();
            this.id = Integer.parseInt( this.choice );

            if ( this.id == 1 ) {
                System.out.println( "\tEnter your new description." );
                newDescription = this.scanner.nextLine();

                deckUser.changeDescription( idCard, newDescription );
                System.out.println( "\tThe card has been successfully modified." );

            } else {
                System.out.println( "\tThe modification of the card has been cancelled." );
            }
        }
    }

    // Search for a card in the deck
    public void searchCard( Deck deckUser) {
        String typeCard;

        System.out.println( "\tPlease choose the search method." );
        System.out.println( "\t1 - By ID | 2 - By type" );
        this.choice = this.scanner.nextLine();
        this.id = Integer.parseInt( this.choice );

        // Search by ID
        if ( this.id == 1 ) {
            System.out.println( "\tPlease choose the ID of the card you want to search." );
            this.choice = this.scanner.nextLine();
            int idCard = Integer.parseInt( this.choice );

            System.out.println( "\tThis is the card you were looking for :" );
            System.out.println( "\t" + deckUser.showCardById( idCard ) );
        }
        // Search by type
        else if ( this.id == 2 ) {
            System.out.println( "\tChoice the type of card what you want to search : " );
            System.out.println( "\t1 - Energy \t 2 - Trainer \t 3 - Pokemon" );
            this.choice = scanner.nextLine();
            int choiceMenu = Integer.parseInt( this.choice );

            if ( choiceMenu == 1) {
                System.out.println( "\tEnergy cards : " );
                typeCard = "Energy";
            }
            else if ( choiceMenu == 2 ) {
                System.out.println( "\tTrainer cards : " );
                typeCard = "Trainer";
            }
            else {
                System.out.println( "\tPokemon cards : " );
                typeCard = "Pokemon";
            }


            deckUser.showCardByType( typeCard );

        }
        else {
            System.out.println("");
        }
    }
}
