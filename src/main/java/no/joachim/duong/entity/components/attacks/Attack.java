package no.joachim.duong.entity.components.attacks;

import javafx.scene.image.Image;
import no.joachim.duong.entity.units.Entity;

public abstract class Attack {
    private int maxCd;
    private int currCd;
    private boolean active = true;
    public abstract Entity createBullet(int x, int y);

    public int getMaxCd() {
        return maxCd;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setMaxCd(int maxCd) {
        this.maxCd = maxCd;
    }

    public int getCurrCd() {
        return currCd;
    }

    public void setCurrCd(int currCd) {
        this.currCd = currCd;
    }

    public void deceraseCd() {
        if(currCd > 0) {
            currCd--;
        }
    }

    public void resetCd() {
        currCd = maxCd;
    }
}
