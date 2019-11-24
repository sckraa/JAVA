public class TrainerCard  extends Card {
    private TrainerType trainerType;

    public TrainerCard ( Integer id, String name, TrainerType trainerType, String description ) {
        super ( id, name, String.valueOf( trainerType ), description );
        this.trainerType = trainerType;
    }

    public String toString() {
        return "[ Card ID: " + this.getId() + ", Card Name : " + this.getName() + ", Card Type : " + this.getType() + ", Card Description : " + this.getDescription() + " ]";
    }
}
