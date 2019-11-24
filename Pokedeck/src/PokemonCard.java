public class PokemonCard extends Card {
    private Integer hpPokemon;
    private PokemonStage pokemonStage;
    private EnergyType energyType;

    // Builder
    public PokemonCard( Integer id, String name, Integer hpPokemon, PokemonStage pokemonStage, EnergyType energyType, String description) {
        super( id, name, String.valueOf( energyType ), description);
        this.hpPokemon = hpPokemon;
        this.energyType = energyType;
        this.pokemonStage = pokemonStage;
    }

    // Getter
    public Integer getHpPokemon() {
        return this.hpPokemon;
    }
    public PokemonStage getPokemonStage() {
        return this.pokemonStage;
    }
    public EnergyType getEnergyType() {
        return this.energyType;
    }

    // Methods
    public String toString() {
        return "[ Card ID: " + this.getId() + " | Card Name : " + this.getName() + " | HP : " + this.getHpPokemon() + " | Stage : " + this.getPokemonStage() + " | Card Type : " + this.getType() + " | Card Description : " + this.getDescription() + " ]";
    }
}
