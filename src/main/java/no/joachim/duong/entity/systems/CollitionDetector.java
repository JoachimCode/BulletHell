package no.joachim.duong.entity.systems;

import java.util.ArrayList;
import no.joachim.duong.utility.StaticConstants;
import no.joachim.duong.entity.units.Entity;
import no.joachim.duong.entity.components.PositionComp;

/**
 * <p>
 * Represents a the system that detect collisions between entities and the boundaries of
 * the map.
 * </p>
 * <p>
 * <strong>Note:</strong> No notes
 * </p>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Joachim Duong
 */
public class CollitionDetector {
    private ArrayList<Entity> entityList;
    public CollitionDetector(ArrayList<Entity> entityList) {
        this.entityList = entityList;
    }

    /**
     * Loops through all entities and compares their positions. Only compares the entities if
     * they have a different entityID. This can happen if the algorithm is checking the same object
     * or multiple elements are part of the same entity.
     *
     * @return a ArrayList of all the collisions that have occurred.
     * @since 0.0.1
     */
    public ArrayList<Entity[]> getCollisions() {
        ArrayList<Entity[]> collidedEntities = new ArrayList<>();
        for(int i = 0; i < entityList.size(); i++) {
            for(int j = 0; j <entityList.size(); j++) {
                Entity entityI = entityList.get(i);
                Entity entityJ = entityList.get(j);
                if(!checkIfSameId(entityI, entityJ) ) {
                    Entity[] collidedPair = {entityI, entityJ};
                    collidedEntities.add(collidedPair);
                }
            }
        }
        return collidedEntities;
    }

    /**
     * Detects if two entities have collided. It checks if their rectangles have overlapped with
     * each-other
     *
     * @param i the first entity
     * @param j the second entity
     * @return true if they have collided, false if otherwise
     * @since 0.0.1
     */
    private boolean detectCollision(Entity i, Entity j) {
        int iStartX = i.getComponent(PositionComp.class).getX();
        int iEndX = iStartX + i.getWidth();
        int iStartY = i.getComponent(PositionComp.class).getY();
        int iEndY = iStartY - i.getHeight();

        int jStartX = j.getComponent(PositionComp.class).getX();
        int jEndX = jStartX + j.getWidth();
        int jStartY = j.getComponent(PositionComp.class).getY();
        int jEndY = jStartY -j.getHeight();

        boolean xOverlap = iStartX < jEndX && iEndX > jStartX;
        boolean yOverlap = iStartY < jEndY && iEndY > jStartY;

        return xOverlap && yOverlap;
    }

    /**
     * Checks if two entities have the same id and is therefor the same object.
     *
     * @param i the first entity
     * @param j the second entity
     * @return true if they are the same entity, false otherwise
     * @since 0.0.1
     */
    public boolean checkIfSameId(Entity i, Entity j) {
        return i.getId() == j.getId();
    }

    public boolean isCollidedWithWall(Entity entity) {
        int startX = entity.getComponent(PositionComp.class).getX();
        int endX = startX + entity.getWidth();
        int startY = entity.getComponent(PositionComp.class).getY();
        int endY = startY - entity.getHeight();


        boolean xOverlap = startX < StaticConstants.minimumX && endX > StaticConstants.maximumX;
        boolean yOverlap = startY < StaticConstants.minimumY && endY > StaticConstants.maximumY;

        return xOverlap && yOverlap;
    }
}
