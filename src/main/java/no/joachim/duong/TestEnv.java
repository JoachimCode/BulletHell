package no.joachim.duong;

import java.util.ArrayList;
import no.joachim.duong.entity.Entity;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.entity.systems.MovementSys;
import no.joachim.duong.exceptions.OutOfBoundsHorizontalException;
import no.joachim.duong.exceptions.OutOfBoundsVerticalException;

public class TestEnv {
    public void run() {
        Entity entity1 = new Entity(1);
        entity1.addComponent(new PositionComp(20, 20));
        entity1.addComponent(new VelocityComp(5, 0));
        ArrayList<Entity> entityList = new ArrayList<>();
        entityList.add(entity1);

        MovementSys movementSys = new MovementSys(entityList);
        for(int n = 0; n < 11; n++) {
            movementSys.update(1);
            System.out.println("x-pos is " + entityList.get(0).getComponent(PositionComp.class).getX());
            System.out.println("y-pos is " + entityList.get(0).getComponent(PositionComp.class).getY());
        }
    }
}
