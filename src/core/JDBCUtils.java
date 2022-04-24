package core;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	static {
		try {
//			InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
			FileInputStream inputProperties = new FileInputStream("./src/core/db.properties");
			Properties properties = new Properties();
//			properties.load(inputStream);
			properties.load(inputProperties);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JDBCUtils() {
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void close(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static void close(Connection connection, Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
			statement = null;
		}
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
			resultSet = null;
		}
		if (statement != null) {
			statement.close();
			statement = null;
		}
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static void close(Connection connection, PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
			preparedStatement = null;
		}
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
			resultSet = null;
		}
		if (preparedStatement != null) {
			preparedStatement.close();
			preparedStatement = null;
		}
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	public static ResultSet queryAll() throws SQLException, ClassNotFoundException {
		final /*private static */String QUERY_ALL = "select * from word_list;";
		connection = JDBCUtils.getConnection();
		statement = connection.createStatement();
		resultSet = statement.executeQuery(QUERY_ALL);
		return resultSet;
	}
	
	public static void printResultSetByDefault() throws SQLException {
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String word = resultSet.getString(2);
			String meaning = resultSet.getString(3);
			System.out.println("id: " + id + " | word: " + word + " | meaning: " + meaning);
		}
	}
}
