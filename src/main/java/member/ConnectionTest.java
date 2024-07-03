package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@192.168.45.73:1521:xe";
		String user="scott";
		String password="tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로딩성공!!");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공!!"+con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
