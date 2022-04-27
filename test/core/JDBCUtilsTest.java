package core;

import org.junit.Test;

import java.sql.*;

public class JDBCUtilsTest {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	
	// TODO: 4/24/22 (solved) default_user connection failed...
	// 	 # default_user has no privileges when login at localhost
	// 	 $ update mysql.user set Host = 'localhost' where User = 'default_user';
	// 	 $ flush privileges;
	// 	 # ERROR 1410 (42000): You are not allowed to create a user with GRANT
	// 	 	# root has no privileges on '%'
	// 		# Or grant privilege on '%' but the user has privileges on 'localhost' only
	// 		$ update mysql.user set Host = '%' where User = 'root';
	// 		$ flush privileges;
	// 		$ grant select, insert, update privileges on default_user.* to 'default_user'@'localhost' with grant option;
	// 		$ flush privileges;
	// 		$ [solution_source](https://chowdera.com/2022/02/202202070332346029.html)
	// TODO: 4/24/22 db.properties load in failed when using ClassLoader...
	// 	 # ???
	// 	 $ ???
	@Test
	public void testConnection() throws SQLException {
		try {
			connection = JDBCUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection);
		}
	}
	
	@Test
	public void testQueryByDefault() throws SQLException {
		try {
			resultSet = JDBCUtils.queryAll();
			JDBCUtils.printResultSetByDefault();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, statement, resultSet);
		}
	}
	
	
}
