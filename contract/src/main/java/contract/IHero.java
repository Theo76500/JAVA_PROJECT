package contract;

/**
 *@author LANGLOIS Theo 
 * Interface Hero
 */


public interface IHero extends IEntity{
	
	/**
     * A getter for the score
     * @return
     * Get the score of the hero
     */
	Integer getScore();
	
	/**
     * A Setter for the score
     * @param score
     * Set the score for hero
     */
	void setScore(Integer score);
	
	/**
     * A getter if the hero is alive
     * @return
     * If the hero is alive
     */
    boolean isAlive();
    
    /**
     * A setter if the hero is alive
     * @param alive
     * Set if the hero is alive
     */
    void setAlive(boolean alive);

	
}
