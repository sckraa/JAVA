public class PokemonCard extends Card {

    private static final long serialVersionUID = 2L;
    private Integer hpPokemon;
    private PokemonStage pokemonStage;
    private EnergyType energyType;

    // Builder
    public PokemonCard( Integer id, String name, String type, String description, Integer hpPokemon, PokemonStage pokemonStage, EnergyType energyType ) {
        super( id, name, type, description);
        this.hpPokemon = hpPokemon;
        this.pokemonStage = pokemonStage;
        this.energyType = energyType;
    }

    // Getter
    public Integer getHpPokemon() {
        return this.hpPokemon;
    }
    public PokemonStage getPokemonStage() { return this.pokemonStage; }
    public EnergyType getEnergyType() {
        return this.energyType;
    }

    // Methods
    public String toString() {
        return "\t[ Card ID: " + this.getId() + " | Card Name : " + this.getName() + " | Card Type : " + this.getType() + " | HP : " + this.getHpPokemon() + " | Pokemon Stage : " + this.getPokemonStage() + " | Card Description : " + this.getDescription() + " ]";
    }
}
