public class TrainerCard  extends Card {

    private static final long serialVersionUID = 3L;
    private TrainerType trainerType;

    // Builders
    public TrainerCard ( Integer id, String name, String type, String description, TrainerType trainerType ) {
        super ( id, name, type, description );
        this.trainerType = trainerType;
    }

    // Getter
    public TrainerType getTrainerType() {
        return this.trainerType;
    }

    // toString
    public String toString() {
        return "\t[ Card ID: " + this.getId() + " | Card Name : " + this.getName() + " | Card Type : " + this.getType() + " | Trainer Type : " + this.getTrainerType() + " | Card Description : " + this.getDescription() + " ]";
    }
}
