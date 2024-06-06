package no.joachim.duong.entity.systems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import no.joachim.duong.StaticConstants;
import no.joachim.duong.entity.Entity;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class MovementSysTest {
    ArrayList<Entity> entityList;
    MovementSys movementSys;

    @BeforeEach
    void setUp() {
        Entity entity1 = new Entity(1);
        entity1.addComponent(new PositionComp(20, 20));
        entity1.addComponent(new VelocityComp(5, 0));

        Entity entity2 = new Entity(2);
        entity2.addComponent(new PositionComp(StaticConstants.maximumX - 10, 0));
        entity2.addComponent(new VelocityComp(20, 20));

        Entity entity3 = new Entity(3);
        entity3.addComponent(new PositionComp(0, StaticConstants.maximumY - 10));
        entity3.addComponent(new VelocityComp(20, 20));

        Entity entity4 = new Entity(4);
        entity4.addComponent(new PositionComp(StaticConstants.maximumX - 10, StaticConstants.maximumY - 10));
        entity4.addComponent(new VelocityComp(40, 20));

        entityList = new ArrayList<>();
        entityList.add(entity1);
        entityList.add(entity2);
        entityList.add(entity3);
        entityList.add(entity4);

        movementSys = new MovementSys(entityList);
    }

    @Test
    void testUpdateNormal() {
        movementSys.update(1);
        int actualPositionX = entityList.get(0).getComponent(PositionComp.class).getX();
        int actualPositionY = entityList.get(0).getComponent(PositionComp.class).getY();
        assertEquals(25, actualPositionX);
        assertEquals(20, actualPositionY);
    }

    @Test
    void testUpdateHorizontalOutOfBounds() {
        movementSys.update(1);
        int actualPositionX = entityList.get(1).getComponent(PositionComp.class).getX();
        int actualPositionY = entityList.get(1).getComponent(PositionComp.class).getY();
        assertEquals(StaticConstants.maximumX - 10, actualPositionX);
        assertEquals(20, actualPositionY);

        movementSys.update(1);
        int actualPositionX2 = entityList.get(1).getComponent(PositionComp.class).getX();
        int actualPositionY2 = entityList.get(1).getComponent(PositionComp.class).getY();
        assertEquals(StaticConstants.maximumX - 30, actualPositionX2);
        assertEquals(40, actualPositionY2);
    }

    @Test
    void testUpdateVerticalOutOfBounds() {
        movementSys.update(1);
        int actualPositionX = entityList.get(2).getComponent(PositionComp.class).getX();
        int actualPositionY = entityList.get(2).getComponent(PositionComp.class).getY();
        assertEquals(20, actualPositionX);
        assertEquals(StaticConstants.maximumY - 10, actualPositionY);

        movementSys.update(1);
        int actualPositionX2 = entityList.get(2).getComponent(PositionComp.class).getX();
        int actualPositionY2 = entityList.get(2).getComponent(PositionComp.class).getY();
        assertEquals(40, actualPositionX2);
        assertEquals(StaticConstants.maximumY - 30, actualPositionY2);
    }

    @Test
    void testUpdateBothOutOfBounds() {
        movementSys.update(1);
        int actualPositionX = entityList.get(3).getComponent(PositionComp.class).getX();
        int actualPositionY = entityList.get(3).getComponent(PositionComp.class).getY();
        assertEquals(StaticConstants.maximumX - 30, actualPositionX);
        assertEquals(StaticConstants.maximumY - 10, actualPositionY);

        movementSys.update(1);
        int actualPositionX2 = entityList.get(3).getComponent(PositionComp.class).getX();
        int actualPositionY2 = entityList.get(3).getComponent(PositionComp.class).getY();
        assertEquals(StaticConstants.maximumX - 70, actualPositionX2);
        assertEquals(StaticConstants.maximumY - 30, actualPositionY2);
    }
}