package no.joachim.duong.entity.units;

import no.joachim.duong.FxApplication;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;

public abstract class Shooter extends Entity{
    private int cooldown;
    private int maxCooldown;
    private int movementSpeed;
    public Shooter(int entityId) {
        super(entityId);
    }
    public Shooter(int entityId, int width, int height, int type) {
        super(entityId, width, height, type);
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public abstract Entity createBullet(int direction);
    public void decreaseCooldown() {
        if(cooldown > 0) {
            cooldown--;
        }
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCooldown() {
        return cooldown;
    }
    public int getMaxCooldown() {
        return  maxCooldown;
    }
    public void setMaxCooldown(int maxCooldown) {
        this.maxCooldown = maxCooldown;
    }
}
