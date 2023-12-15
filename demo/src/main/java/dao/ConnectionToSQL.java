package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToSQL {
	static String jdbcUrl = "jdbc:mysql://localhost:3306/qlda";
	static String user = "root";
	static String password = "";

	public static Connection createConnection() {
		Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(jdbcUrl, user, password);
//				System.out.println("doe");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Kết nối đã được thiết lập thành công
		} catch (SQLException e) {
			System.out.println("error" + e);
		}
		return connection;
	}

	public static void main(String[] args) {
		createConnection();
	}
}
