package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.h2.Driver;

public class Database {

	private Connection conn;

	private Statement statement;

	private ResultSet resultSet;

	public void createDbConnection() throws SQLException {

		conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		statement = conn.createStatement();

	}

	public void releaseDbConnection() throws SQLException {

		conn.close();
	}

	protected List<Map<String, Object>> getQueryResults(String query) throws SQLException {

		List<Map<String, Object>> listOfRows = new ArrayList<Map<String, Object>>();

		resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			ResultSetMetaData metaData = resultSet.getMetaData();

			HashMap<String, Object> valuePair = new HashMap<String, Object>();

			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String key = metaData.getColumnName(i);
				Object value = resultSet.getObject(i);

				valuePair.put(key, value);
			}

			listOfRows.add(valuePair);

		}

		return listOfRows;

	}

	protected Map<String, Object> getQueryResult(String query) throws SQLException {

		resultSet = statement.executeQuery(query);
		HashMap<String, Object> valuePair = new HashMap<String, Object>();

		while (resultSet.next()) {
			ResultSetMetaData metaData = resultSet.getMetaData();

			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String key = metaData.getColumnName(i);
				Object value = resultSet.getObject(i);

				valuePair.put(key, value.toString()); // if not converted to string then it will pass the data in the
														// original data type
			}
		}
		return valuePair;
	}

}
