package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mysqlConnection {
	//멤버변수, 객체생성하는곳.
	
	//1. 드라이브로딩
	//실행할 수 없음 : Class.forName("com.mysql.cj.jdbc.Driver");
	//static{}은 실행문을 기술할 수 있는 영역.
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
			System.out.println("드라이브로딩 예외 발생!!!!");
		}
	}
	
	//필요한 변수들을 멤버영역에서 선언.
	protected Connection conn = null;
	protected PreparedStatement pstmt =null;
	protected ResultSet rs = null;

	//2. 데이터베이스 연결 메소드
	public void getConn() {
		System.out.println("mysqlConnection.getConn() start!");
		String url = "jdbc:mysql://localhost/mydb";
		String id = "root";
		String pw = "vnfmsgksmf117!Q";
		try {
			conn = DriverManager.getConnection(url,id,pw);
		}catch(Exception e) {
			System.out.println("데이터 연결 예외 발생!!!!");
		}
	}
	
	//3. 데이터베이스 종료 메소드
	public void dbClose() {
		System.out.println("mysqlConnection.dbclose() start!");
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(conn != null) {conn.close();}
		}catch(Exception e) {
			System.out.println("데이터 연결 예외 발생!!!!");
		}
	}

}
