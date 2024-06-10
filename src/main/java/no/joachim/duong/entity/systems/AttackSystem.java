package no.joachim.duong.entity.systems;

import java.util.List;
import no.joachim.duong.entity.components.PositionComp;
import no.joachim.duong.entity.components.VelocityComp;
import no.joachim.duong.entity.components.attacks.Attack;
import no.joachim.duong.entity.units.Entity;

public class AttackSystem {
    private List<Entity> entityList;
    public AttackSystem(List<Entity> entityList) {
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
    public void shoot(int deltaTime) {
        for(Entity entity : entityList) {
            Attack attack = entity.getComponent(Attack.class);

            if(attack != null) {
                Entity bullet = attack.createBullet();

            }
        }
    }
}
