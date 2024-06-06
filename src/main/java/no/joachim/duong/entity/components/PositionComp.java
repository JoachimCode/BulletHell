package no.joachim.duong.entity.components;

import no.joachim.duong.StaticConstants;
import no.joachim.duong.exceptions.OutOfBoundsHorizontalException;
import no.joachim.duong.exceptions.OutOfBoundsVerticalException;

/**
 * <p>
 * Represents a components class for postion of the entity.
 * This class contains the data of the x position and y position of the entity and
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
public class PositionComp {
    private int x;
    private int y;

    /**
     * Constructor for Positional component with no predefined coords.
     * This will set the coordinates of the entity to (0,0)
     *
     * @since 0.0.1
     */
    public PositionComp() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor for positional components with predefined coords.
     *
     * @param x the x coordinate to the entity
     * @param y the y coordinate to the entity
     * @since 0.0.1
     */
    public PositionComp(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param x the x position to be set
     * @since 0.0.1
     */
    public void setX(int x) throws OutOfBoundsHorizontalException {
        if(x < StaticConstants.minimumX || x > StaticConstants.maximumX) {
            throw new OutOfBoundsHorizontalException("Entity has come out of bounds in x-axis");
        }
        this.x = x;
    }

    /**
     *
     * @param y the y position to be set
     * @since 0.0.1
     */
    public void setY(int y) throws OutOfBoundsVerticalException {
        if(y < StaticConstants.minimumY || y > StaticConstants.maximumY) {
            throw new OutOfBoundsVerticalException("Entity has come out of bounds in y-axis");
        }
        this.y = y;
    }

    /**
     *
     * @return the x position of the entity
     * @since 0.0.1
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return the y position of the entity
     * @since 0.0.1
     */
    public int getY() {
        return y;
    }
}
