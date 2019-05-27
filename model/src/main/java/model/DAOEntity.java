
package model;

import java.sql.Connection;
import java.sql.SQLException;

import entity.Level;
import entity.RowLevel;




/**
 * The Class DAOEntity.
 *
 * @author PAIN Valentin
 *
 * @param <E>
 *          the element type
 */
abstract class DAOEntity<E extends RowLevel> {

	/** The connection. */
	private final Connection connection;

	/**
	 * Instantiates a new DAO entity.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOEntity(final Connection connection) throws SQLException {
		this.connection = connection;
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	protected Connection getConnection() {
		return this.connection;
	}

	/**
	 * Creates the.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public abstract boolean create(E level);

	/**
	 * Delete.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public abstract boolean delete(E level);

	/**
	 * Update.
	 *
	 * @param entity
	 *          the entity
	 * @return true, if successful
	 */
	public abstract boolean update(E level);

	/**
	 * Find.
	 *
	 * @param id
	 *          the id
	 * @return the e
	 */
	//public abstract E find(int id);

	/**
	 * Find.
	 *
	 * @param code
	 *          the code
	 * @return the e
	 */
	public abstract Level find();

}
