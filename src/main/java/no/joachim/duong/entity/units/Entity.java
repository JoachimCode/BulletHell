package no.joachim.duong.entity.units;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import no.joachim.duong.utility.ImageLoader;

/**
 * <p>
 * Represents a entity. The entity is abstract and only contains a id and
 * a map of different components, depending of what kind of entity it is.
 * </p>
 * <p>
 * <strong>Note:</strong> No notes
 * </p>
 *
 * @version 0.0.1
 * @since 0.0.1
 * @author Joachim Duong
 */
public abstract class Entity {
    private int id;
    private int height;
    private int width;
    private Image sprite;
    /**
     * Map over the components. The key value is the component class and the
     * value is its instance.
     */
    private Map<Class<?>, Object> components = new HashMap<>();

    /**
     * Constructor for the entity.
     *
     * @param id the entity ID for identifying different entities.
     * @since 0.0.1
     */
    protected Entity(int id) {
        this.id = id;
    }

    /**
     * Constructor for the entity with predefined width and height
     *
     * @param id to the entity
     * @param width of the entity
     * @param height of the entity
     * @since 0.0.1
     */
    protected Entity(int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    /**
     * Adds a component object to the component map
     *
     * @param component the component object
     * @since 0.0.1
     */
    public <T> void addComponent(T component) {
        components.put(component.getClass(), component);
    }

    /**
     * Gets a component map with a component class.
     * It casts the object retrieved as the class in the argument,
     * for safe handling.
     *
     * @param componentClass Class of the component to be returned
     * @return the component object
     * @since 0.0.1
     */
    public <T> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }

    /**
     *
     * @return the entities id
     * @since 0.0.1
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the height of the entity
     * @since 0.0.1
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return the width of the entity
     * @since 0.0.1
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width to the entity
     *
     * @param width of the entity
     * @throws IllegalArgumentException if the width set is negative
     * @since 0.0.1
     */
    public void setWidth(int width) {
        if(width < 0) {
            throw new IllegalArgumentException("Width has to be positive");
        }
        else {
            this.width = width;
        }
    }

    /**
     * Sets the height of the entity
     *
     * @param height of the entity
     * @throws IllegalArgumentException if the height set is negative
     * @since 0.0.1
     */
    public void setHeight(int height) {
        if(height < 0) {
            throw new IllegalArgumentException("Height has to be positive");
        }
        else {
            this.height = height;
        }
    }

    public void setSprite(String imageName) {
        ImageLoader imageLoader = new ImageLoader();
        sprite = imageLoader.loadImageFromResources(imageName);
        if(sprite == null) {
            throw new IllegalArgumentException("No sprite named that");
        }
    }

    public Image getSprite() {
        return sprite;
    }
}
