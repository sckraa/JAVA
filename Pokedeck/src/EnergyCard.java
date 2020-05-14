public class EnergyCard extends Card {

    private static final long serialVersionUID = 4L;
    private EnergyType energyType;

    public EnergyCard ( Integer id, String name, String type, String description, EnergyType energyType ) {
        super ( id, "[X]", type, description );
        this.energyType = energyType;
    }

    // Getter
    public EnergyType getEnergyType() {
        return this.energyType;
    }

    public String toString() {
        return "\t[ Card ID: " + this.getId() + " | Card Name : " + this.getName() + " | Card Type : " + this.getType() + " | Energy Type : " + this.getEnergyType() + " | Card Description : " + this.getDescription() + " ]";
    }
}
