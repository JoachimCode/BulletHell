package no.joachim.duong.entity.units;

public class PlayerCharacter extends Entity {
    private int movementSpeed;
    public PlayerCharacter(int entityId) {
        super(entityId);
    }
    public PlayerCharacter(int entityId, int width, int height) {
        super(entityId, width, height);
        movementSpeed = 4;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
