package svc;

import core.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Operation {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	public static void queryByDefault() throws SQLException {
		try {
			resultSet = JDBCUtils.queryAll();
			JDBCUtils.printResultSetByDefault();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, statement, resultSet);
		}
	}
	
	public static void addByDefault() throws SQLException {
		try {
			Scanner input = new Scanner(System.in);
			String word = null;
			String meaning = null;
			System.out.println("Please input the word: ");
			if (input.hasNext()) {
				word = input.nextLine();
			}
			System.out.println("Please input the meaning: ");
			if (input.hasNext()) {
				meaning = input.nextLine();
			}
			input.close();
			final /*private static */String ADD_BY_DEFAULT = "insert into wordlist(word, meaning) values(?, ?);";
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(ADD_BY_DEFAULT);
			preparedStatement.setString(1, word);
			preparedStatement.setString(2, meaning);
			preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(connection, preparedStatement);
		}
	}
	
	public static void modifyByDefault() throws SQLException {
		try {
			Scanner input = new Scanner(System.in);
			int idValue = 0;
			String fieldName = null;
			String fieldValue = null;
			System.out.println("Please input id of the word you want to modify: ");
			if (input.hasNext()) {
				idValue = input.nextInt();
			}
//			System.out.println("Please input the field you want to modify: ");
//			if (input.hasNext()) {
//				fieldName = input.nextLine();
//			}
			System.out.println("Please input the value of the field you want to modify: ");
			System.out.println("Please input a new meaning of the word: ");
			if (input.hasNext()) {
				fieldValue = input.nextLine();
			}
			input.close();
//			final String MODIFY_BY_DEFAULT = "update wordlist set ?=?, modified_time=current_timestamp where id=?;";
			final String MODIFY_BY_DEFAULT = "update wordlist set meaning=?, modified_time=current_timestamp where id=?;";
			
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(MODIFY_BY_DEFAULT);
//			preparedStatement.setString(1, fieldName);
			preparedStatement.setString(1, fieldValue);
			preparedStatement.setInt(2, idValue);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement);
		}
	}
	
	public static void removeByDefault() throws SQLException {
		try {
			Scanner input = new Scanner(System.in);
			int idValue = 0;
			System.out.println("Please input id of the word you want to delete: ");
			if (input.hasNext()) {
				idValue = input.nextInt();
			}
			input.close();
			final String REMOVE_BY_DEFAULT = "delete from wordlist where id=?;";
			connection = JDBCUtils.getConnection();
			preparedStatement = connection.prepareStatement(REMOVE_BY_DEFAULT);
			preparedStatement.setInt(1, idValue);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement);
		}
	}
}
