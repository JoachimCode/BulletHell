package no.joachim.duong.entity.units;

import no.joachim.duong.FxApplication;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;

public class PlayerCharacter extends Entity {
    private int movementSpeed;
    public PlayerCharacter(int entityId) {
        super(entityId);
    }
    public PlayerCharacter(int entityId, int width, int height, int type) {
        super(entityId, width, height, type);
        setMovementSpeed(4);
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
