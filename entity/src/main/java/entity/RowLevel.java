package entity;

/**
 * The Class Level.
 * 
 * @author Valentin Pain
 */
public class RowLevel{

	/** The id. */
	private int blocksId;
	
	/** The type */
	private String blocksType;
	
	/** The X */
	private int blocksX;
	
	/** The Y */
	private int blocksY;
	
	/** The direction */
	private String blocksDirection;
	
	/** The level number */
	private int levelNumber;
	
	/** The level verification*/
	private boolean levelFinished;
	
	
	/**
	 * Instantiates a new level
	 * 
	 * @param blocksId
	 *                 the id
	 *@param blocksType
	 *				   the type
	 *@param blocksX
	 *				   the X
	 *@param blocksY  
	 *                 the Y
	 *@param blocksDirection
	 *                 the direction
	 *@param levelNumber
	 *                 the level number
	 */
	
	public RowLevel(int blocksId, String blocksType, int blocksX, int blocksY, String blocksDirection, int levelNumber, boolean levelFinished) {
		this.blocksId = blocksId;
		this.blocksType = blocksType;
		this.blocksX = blocksX;
		this.blocksY = blocksY;
		this.blocksDirection = blocksDirection;
		this.levelNumber = levelNumber;
		this.levelFinished = false;
	}
	
	public RowLevel(int blocksId, String blocksType, int blocksX, int blocksY, String blocksDirection, int levelNumber) {
		this.blocksId = blocksId;
		this.blocksType = blocksType;
		this.blocksX = blocksX;
		this.blocksY = blocksY;
		this.blocksDirection = blocksDirection;
		this.levelNumber = levelNumber;
		this.levelFinished = false;
	}
	

	/** 
	 * Instantiate a new level
	 */
	
	public RowLevel() {
		this(0, "", 0, 0, "", 0, false);
		
	}
	
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getBlocksId() {
		return blocksId;
	}

	
	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setBlocksId(int blocksId) {
		this.blocksId = blocksId;
	}

	
	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getBlocksType() {
		return blocksType;
	}

	/**
	 * Sets the type.
	 * 
	 * @param blocksType
	 *                  the new type
	 */
	public void setBlocksType(String blocksType) {
		this.blocksType = blocksType;
	}

	/**
	 * Gets the X.
	 * 
	 * @return the X
	 */
	public int getBlocksX() {
		return blocksX;
	}

	/**
	 * Sets the X.
	 *
	 * @param id
	 *          the new X
	 */
	public void setBlocksX(int blocksX) {
		this.blocksX = blocksX;
	}

	/**
	 * Gets the Y.
	 * 
	 * @return the Y
	 */
	public int getBlocksY() {
		return blocksY;
	}

	/**
	 * Sets the Y.
	 *
	 * @param id
	 *          the new Y
	 */
	public void setBlocksY(int blocksY) {
		this.blocksY = blocksY;
	}

	/**
	 * Gets the direction.
	 * 
	 * @return the direction
	 */
	public String getBlocksDirection() {
		return blocksDirection;
	}

	/**
	 * Sets the direction.
	 *
	 * @param id
	 *          the new direction
	 */
	public void setBlocksDirection(String blocksDirection) {
		this.blocksDirection = blocksDirection;
	}

	/**
	 * Gets the level number.
	 * 
	 * @return the level number
	 */
	public int getLevelNumber() {
		return levelNumber;
	}

	/**
	 * Sets the level number.
	 *
	 * @param id
	 *          the new level number
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
	
	/**
	 * Gets the state of the level.
	 * 
	 * @return the state of the level
	 */
	public boolean getLevelFinished() {
		return levelFinished;
	}

	/**
	 * Sets the state of the level.
	 *
	 * @param levelFinished
	 *          the new state of the level
	 */
	public void setLevelFinished(boolean levelFinished) {
		this.levelFinished = levelFinished;
	}
	
}
