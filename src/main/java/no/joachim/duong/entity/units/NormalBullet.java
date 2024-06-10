package no.joachim.duong.entity.units;

import no.joachim.duong.FxApplication;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.utility.StaticConstants;

public class NormalBullet extends Entity{
    private int movementSpeed;
    public NormalBullet(int entityId, int direction) {
        super(entityId, 2, 8, StaticConstants.PLAYER_BULLET);
        setSprite("normalBullet.png");
        setDirection(direction);
        setMovementSpeed(4);
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    private void setDirection(int direction) {
        switch(direction) {
            case(1):
                addComponent(new VelocityComp(10, 0));
                break;
            case(2):
                addComponent(new VelocityComp(0, 10));
                break;
            case(3):
                addComponent(new VelocityComp(-10, 0));
                break;
            case(4):
                addComponent(new VelocityComp(0, -10));
                break;
            default:
                break;
        }
    }
}
