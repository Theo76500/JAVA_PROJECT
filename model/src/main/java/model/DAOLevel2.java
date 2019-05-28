package model;

import entity.Level;
import entity.RowLevel;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * The Class DAOLevel1.
 *
 * @author LANGLOIS Theo
 */
class DAOLevel2 extends DAOEntity<RowLevel> {

	/**
	 * Instantiates a new DAO hello world.
	 *
	 * @param connection
	 *          the connection
	 * @throws SQLException
	 *           the SQL exception
	 */
	public DAOLevel2(final Connection connection) throws SQLException {
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


	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(int)
	 */
	/*@Override
	public HelloWorld find(final int id) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call helloworldById(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(id, resultSet.getString("code"), resultSet.getString("message"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/

	/*
	 * (non-Javadoc)
	 *
	 * @see model.DAOEntity#find(java.lang.String)
	 */
	/*@Override
	public HelloWorld find(final String code) {
		HelloWorld helloWorld = new HelloWorld();

		try {
			final String sql = "{call helloworldByCode(?)}";
			final CallableStatement call = this.getConnection().prepareCall(sql);
			call.setString(1, code);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			if (resultSet.first()) {
				helloWorld = new HelloWorld(resultSet.getInt("id"), code, resultSet.getString("message"));
			}
			return helloWorld;
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	@Override
	public Level find() {
		int blocksId = 1;
		RowLevel rowLevel = new RowLevel();
		Level level = new Level();

		try {
			final String sql = "{call level2ById(?)}";
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
