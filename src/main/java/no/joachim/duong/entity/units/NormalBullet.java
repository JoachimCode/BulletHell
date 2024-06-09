package no.joachim.duong.entity.units;

import no.joachim.duong.utility.StaticConstants;

public class NormalBullet extends Entity{
    private int movementSpeed;
    public NormalBullet(int entityId) {
        super(entityId, 2, 8, StaticConstants.BULLET);
        setSprite("normalBullet.png");
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }
}
