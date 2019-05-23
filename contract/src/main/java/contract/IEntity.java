package contract;

/**
 * @author LAGNLOIS Theo
 * Interface  that represents the entities of the level
 */

public interface IEntity extends IElement {
	/**
	 * get the direction of an entity
	 * @return
     * The direction of the entity
	 */
    Direction getDirection();
    
    /**
     * set the direction of an entity
     * @param direction
     * Direction of the entity
     */
    void setDirection(Direction direction);
    
    /**
     * define where the entity has to move
     * @param x
     * Entity has move to X
     * @param y
     * Entity has move to Y
     */
    void moveTo(int x, int y);
}
