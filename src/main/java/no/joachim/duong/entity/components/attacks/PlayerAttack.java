package no.joachim.duong.entity.components.attacks;

import javafx.geometry.Pos;
import no.joachim.duong.FxApplication;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.entity.units.NormalBullet;

public class PlayerAttack extends Attack{
    private int direction = 1;
    @Override
    public Entity createBullet(int x, int y) {
        NormalBullet normalBullet = new NormalBullet(FxApplication.nextId.getAndIncrement(), direction);

    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPosition() {
        switch (case)
    }
}
