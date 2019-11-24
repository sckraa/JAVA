public abstract class Card {
    private Integer id;
    private String name;
    private String type;
    private String description;

    // Builders
    public Card() {
        this.id = null;
        this.name = "undefined";
        this.type = "undefined";
        this.description = "undefined";
    }

    public Card( Integer cardId, String cardName, String cardType, String cardDescription ) {
        this.id = cardId;
        this.name = cardName;
        this.type = cardType;
        this.description = cardDescription;
    }

    // Getters
    public Integer getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.type;
    }
    public String getDescription() {
        return this.description;
    }

    // Setters
    public void setDescription ( String description ) {
        this.description = description;
    }

    // toString()
    public abstract String toString();
}
