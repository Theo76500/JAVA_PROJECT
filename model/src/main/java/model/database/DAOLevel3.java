package model.database;

import entity.Level;
import entity.RowLevel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The Class DAOLevel3.
 *
 * @author LANGLOIS Theo
 */
public class DAOLevel3 extends DAOEntity<RowLevel> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOLevel3(final Connection connection) throws SQLException {
		super(connection);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#create(model.Entity)
	 */
	@Override
	public boolean create(final RowLevel level) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#delete(model.Entity)
	 */
	@Override
	public boolean delete(final RowLevel level) {
		// Not implemented
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#update(model.Entity)
	 */
	@Override
	public boolean update(final RowLevel level) {
		// Not implemented
		return false;
	}
	
	@Override
	public Level find() {
		int blocksId = 1;
		RowLevel rowLevel = new RowLevel();
		Level level = new Level();

		try {
			final String sql = "{call level3ById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, blocksId);
			call.execute();
			ResultSet resultSet = call.getResultSet();
			
				if (blocksId == 1 && resultSet.first()) {
						rowLevel = new RowLevel(blocksId, resultSet.getString("blocksType"), resultSet.getInt("blocksX"), resultSet.getInt("blocksY"), resultSet.getString("blocksDirection"), resultSet.getInt("levelNumber"));
						
						Level.getLevel().add(rowLevel);
						blocksId++;
				}
				
				call.setInt(1, blocksId);
				call.execute();
				resultSet = call.getResultSet();
				
				while(resultSet.next() && blocksId < 422) {
					rowLevel = new RowLevel(blocksId, resultSet.getString("blocksType"), resultSet.getInt("blocksX"), resultSet.getInt("blocksY"), resultSet.getString("blocksDirection"), resultSet.getInt("levelNumber"));
					Level.getLevel().add(rowLevel);
					blocksId++;
					call.setInt(1, blocksId);
					call.execute();
					resultSet.close();
					resultSet = call.getResultSet();
				}
			
			return level;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
