package no.joachim.duong.entity.systems;

import java.util.List;
import no.joachim.duong.StaticConstants;
import no.joachim.duong.entity.Entity;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.exceptions.OutOfBoundsHorizontalException;
import no.joachim.duong.exceptions.OutOfBoundsVerticalException;

/**
 * <p>
 * Represents a the system that handles movement of entities.
 * </p>
 * <p>
 * <strong>Note:</strong> No notes
 * </p>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Joachim Duong
 */
public class MovementSys {
    private List<Entity> entityList;
    public MovementSys(List<Entity> entityList) {
        this.entityList = entityList;
    }

    /**
     * Updates the movement of all the entities in the entity list. It updates them both
     * horizontally and vertically based on their velocity and the given delta time. If their
     * position exceeds the boundaries of the map, their velocity is set to its opposite value.
     *
     * @param deltaTime amount of times its velocity will apply.
     * @since 0.0.1
     */
    public void update(int deltaTime)
        {
        for(Entity entity : entityList) {
            PositionComp pos = entity.getComponent(PositionComp.class);
            VelocityComp vel = entity.getComponent(VelocityComp.class);

            if (pos != null && vel != null) {

                try {
                    pos.setX((pos.getX() + vel.getVx()) * deltaTime);
                }
                catch (OutOfBoundsHorizontalException e) {
                    try {
                        pos.setX((StaticConstants.maximumX * 2) - (pos.getX() + (vel.getVx() * deltaTime)));
                        vel.setVx(vel.getVx() * - 1);
                    }
                    catch (OutOfBoundsHorizontalException a) {
                        System.out.println(a.getMessage());
                    }
                }

                try {
                    pos.setY(pos.getY() + vel.getVy() * deltaTime);
                }
                catch (OutOfBoundsVerticalException e) {
                    try {
                        pos.setY((StaticConstants.maximumY * 2) - (pos.getY() + (vel.getVy() * deltaTime)));
                        vel.setVy(vel.getVy() * -1);
                    }
                    catch (OutOfBoundsVerticalException a) {
                        System.out.println(a.getMessage());
                    }
                }

            }
        }
    }
}
