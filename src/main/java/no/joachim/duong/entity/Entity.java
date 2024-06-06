package no.joachim.duong.entity;

import java.util.HashMap;
import java.util.Map;

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
public class Entity {
    private int id;
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
    public Entity(int id) {
        this.id = id;
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
     */
    public <T> T getComponent(Class<T> componentClass) {
        return componentClass.cast(components.get(componentClass));
    }

    /**
     *
     * @return the entities id
     */
    public int getId() {
        return id;
    }
}
