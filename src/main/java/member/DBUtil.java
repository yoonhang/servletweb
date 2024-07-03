package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DB연동을 위해서 모든 메소드에서 처리할 일들
//모든메소드에서 공통으로 처리하는 부분을 구현
/*
 * 1. 드라이버로딩 
 *    - 한 번 실행
 *    - static블럭으로 처리
 * 2. DB서버연결 
 *    - 메소드마다 항상 서버에 먼저 연결하고 sql문을 실행해야 한다.
 *    - 메소드로 정의하기
 *    - Connection을 리턴하는 메소드를 정의
 *    - static메소드로 정의
 * 3. 자원반납
 *    - 메소드마다 작업이 끝나면 모든 자원을 반납하도록 처리
 *    - 메소드로 정의하기
 *    - ResultSet, Statement, Connection순으로 자원을 반납해야 한다.
 *    - 각각의 자원을 반납하도록 메소드를 따로 만들거나 하나로 만들어서 작업
 *    - static메소드로 정의
 */
public class DBUtil {
	//드라이버로딩
	//=> 클래스가 로딩될 때 한 번 실행된다.
	static {
		System.out.println("스태틱블럭");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//DB서버 접속하기
	public static Connection getConnect() {
		Connection con = null;
		String url="jdbc:oracle:thin:@192.168.45.73:1521:xe";
		String user="scott";
		String password="tiger";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//자원반납
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection con) {
		
	}
	
}









