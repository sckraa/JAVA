public class EnergyCard extends Card {
    private EnergyType energyType;

    public EnergyCard ( Integer id, String name, EnergyType energyType, String description ) {
        super ( id, name, String.valueOf( energyType ), description );
        this.energyType = energyType;
    }

    public String toString() {
        return "[ Card ID: " + this.getId() + ", Card Name : " + this.getName() + ", Card Type : " + this.getType() + ", Card Description : " + this.getDescription() + " ]";
    }
}
