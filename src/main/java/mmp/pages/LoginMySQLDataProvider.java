package mmp.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

public class LoginMySQLDataProvider {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	@DataProvider(name="mysqlDataProvider")
	public Object[][] readDataBase() throws Exception {
		String[][] dataArray;
		try {
			/* This will load the MySQL driver */
			Class.forName("com.mysql.cj.jdbc.Driver");
			/* Setup the connection with the DB */
			connect = DriverManager.getConnection("jdbc:mysql://localhost/DEMO?user=root&password=myp@ssword");

			/* Statements allow to issue SQL queries to the database */
			statement = connect.createStatement();

			/* Result set get the result of the SQL query */
			resultSet = statement.executeQuery("select * from DEMO.mmplogin");
			/* Get Number of Rows and Columns*/
			resultSet.last(); 
			int rows = resultSet.getRow();
			System.out.println("No.of Rows:" + rows);
			int cols = resultSet.getMetaData().getColumnCount();
			System.out.println("No.of Cols:" + cols);

			/* Declare size of return values of 2D array*/
			dataArray = new String[rows][cols];

			int r = 0;
			/* Read Result Set into Double Dimension array*/
			resultSet.beforeFirst();
			while (resultSet.next()) {
				String username = resultSet.getString("user");
				String userpwd = resultSet.getString("password");

				System.out.println("User: " + username);
				dataArray[r][0]=username; //0, 1, 2, 3, 4, 5
				System.out.println("Password: " + userpwd);
				dataArray[r][1]=userpwd;//0, 1, 2, 3, 4, 5
				r++;
			}

			/* Return Data*/
			return dataArray;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}

	/* Close all DB Objects */    
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}
}

