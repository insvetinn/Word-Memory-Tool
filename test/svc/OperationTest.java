package svc;

import org.junit.Test;

import java.sql.*;

public class OperationTest {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	@Test
	public void testQueryByDefault() throws SQLException {
		Operation.queryByDefault();
	}
	
	@Test
	public void testAddByDefault() throws SQLException, ClassNotFoundException {
		Operation.addByDefault();
		Operation.queryByDefault();
	}
	
	// TODO: 4/24/22 executeQuery() in modifyBuDefault() failed...
	// 	 # 使用setString()导致字段名也有''而无法识别
	//	 $
	@Test
	public void testModifyByDefault() throws SQLException {
		Operation.modifyByDefault();
		Operation.queryByDefault();
	}
	
	// TODO: 4/24/22 (solved) executeQuery() in removeByDefault() failed...
	// 	 # default_user has no privileges when delete
	// 	 $ grant all on default_user.* to 'default_user'@'localhost' with grant option;
	// 	 $ flush privileges;
	@Test
	public void testRemoveByDefault() throws SQLException {
		Operation.removeByDefault();
		Operation.queryByDefault();
	}
}
