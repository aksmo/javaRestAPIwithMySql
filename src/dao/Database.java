package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
	public Connection getConnection() throws Exception
	{
		try
		{
			String connectionURL = "jdbc:mysql://db:3306/mysql";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "pass");
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}

}
