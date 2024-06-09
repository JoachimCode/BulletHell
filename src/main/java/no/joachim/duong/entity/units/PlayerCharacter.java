package no.joachim.duong.entity.units;

import no.joachim.duong.FxApplication;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;

public class PlayerCharacter extends Shooter {
    public PlayerCharacter(int entityId) {
        super(entityId);
    }
    public PlayerCharacter(int entityId, int width, int height, int type) {
        super(entityId, width, height, type);
        setMovementSpeed(4);
        setMaxCooldown(15);
        setCooldown(getMaxCooldown());

    }
    @Override
    public Entity createBullet(int direction) {
        PositionComp playerPosition = getComponent(PositionComp.class);
        NormalBullet normalBullet = new NormalBullet(FxApplication.nextId.getAndIncrement());
        switch(direction) {
            case(1):
                normalBullet.addComponent(new PositionComp(playerPosition.getX() + getWidth(), playerPosition.getY() + 40));
                normalBullet.addComponent(new VelocityComp(10, 0));
                return normalBullet;
            case(2):
                normalBullet.addComponent(new PositionComp(playerPosition.getX() + 20, playerPosition.getY() + getHeight()));
                normalBullet.addComponent(new VelocityComp(0, 10));
                return normalBullet;
            case(3):
                normalBullet.addComponent(new PositionComp(playerPosition.getX(), playerPosition.getY() + 40));
                normalBullet.addComponent(new VelocityComp(-10, 0));
                return normalBullet;
            case(4):
                normalBullet.addComponent(new PositionComp(playerPosition.getX() + 20, playerPosition.getY()));
                normalBullet.addComponent(new VelocityComp(0, -10));
                return normalBullet;
            default:
                return null;
        }
    }
}
