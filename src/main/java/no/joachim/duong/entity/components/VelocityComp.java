package no.joachim.duong.entity.components;

import java.util.Vector;

/**
 * <p>
 * Represents a components class for velocity of the entity.
 * This class contains the data of the horizontal velocity and vertical velocity of the entity and
 * setters/getters for these.
 * </p>
 * <p>
 * <strong>Note:</strong> No notes
 * </p>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Joachim Duong
 */
public class VelocityComp {
    private int vx;
    private int vy;

    /**
     * Constructor for the velocity component with no predefine velocity.
     * Sets both the vx and vy to zero as default.
     *
     * @since 0.0.1
     */
    public VelocityComp() {
        vx = 0;
        vy = 0;
    }

    /**
     * Constructor for the velocity component with predefined velocities.
     *
     * @param vx the horizontal velocity
     * @param vy the vertical velocity
     */
    public VelocityComp(int vx, int vy) {
        setVx(vx);
        setVy(vy);
    }

    /**
     *
     * @param vx the horizontal velocity
     */
    public void setVx(int vx) {
        this.vx = vx;
    }

    /**
     *
     * @param vy the vertical velocity
     */
    public void setVy(int vy) {
        this.vy = vy;
    }

    /**
     *
     * @return the horizontal velocity
     */
    public int getVx() {
        return vx;
    }

    /**
     *
     * @return the vertical velocity
     */
    public int getVy() {
        return vy;
    }

}
