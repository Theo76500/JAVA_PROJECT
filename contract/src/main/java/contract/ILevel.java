package contract;

import java.util.ArrayList;
/**
 * The Interface ILevel
 *
 * @author LANGLOIS Theo
 */
public interface ILevel extends IValuable {

    /**
     * add the entity
     * @param entity
     * add the entity for level
     */
    void addEntity(IEntity entity);

    /**
     * A method to remove the entity
     * @param entity
     * Remove the entity of level
     */
    void removeEntity(IEntity entity);

    /**
     * A getter to get the number
     * @return
     * the number of the level
     */
    int getNumber();

    /**
     * A setter for number
     * @param number
     * Set the number of the level
     */
    void setNumber(int number);

    /**
     * Getter for the dimention of level
     * @return
     * A getter to get the dimention
     */
    ISize getSize();

    /**
     * A setter for dimention
     * @param dimention
     * set the dimention of the level
     */
    void setDimention(ISize size);

    /**
     * getter for the hero
     * @return
     * get the level of the hero
     */
    IHero getHero();

    /**
     * A setter for hero
     * @param hero
     * Set the level for hero
     */
    void setHero(IHero hero);

    /**
     * A getter for element
     * @return
     * get the element of the level
     */
    IElement[][] getElements();

    /**
     * A setter for element
     * @param elements
     * Set the elements of the level
     */
    void setElements(IElement[][] elements);

    /**
     * A getter for element
     * @param x
     * Localisation x
     *@param y
     * Localisation y
     * get the elements of the level
     */
    IElement getElement(int x, int y);

    /**
     * A setter for element
     * @param element
     * Set the element of the level
     * @param x
     * Location of the element of level
     * @param y
     * Location of the element of level
     */
    void setElement(int x, int y, IElement element);

    /**
     * A getter for Entities
     * @return
     * get the entitites of the level
     */
    ArrayList<IEntity> getEntities();

  

    /**
     * A method to destroy the element
     * @param element
     * Destroy the element of the level
     */
    void destroyElement(IElement element);

    /**
     * A getter if the level is finished
     * @return
     * If the level is finished
     */
    boolean isFinished();

    /**
     * A setter if the level is finished
     * @param finished
     * If level is finished
     */
    void setFinished(boolean finished);

    /**
     * getter the id of the chosen level
     * @return
     * get id the level
     */
    int getId();
}
