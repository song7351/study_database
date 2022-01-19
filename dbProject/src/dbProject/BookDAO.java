package dbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class BookDAO {

	Scanner stdin = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost/book";
	String id = "root";
	String pw = "비밀번호";

	public BookDAO() {
		// 생성자 메서드
		// 
	}

	// book테이블에 데이터 저장
	//(BookDTO bookDTO)
	public void insertBook() {
		// 도서번호, 도서제목, 저자, 발행연도, 가격, 출판사 입력
		System.out.print("입력 데이터 : ");
		String no = stdin.next();
		String title = stdin.next();
		String author = stdin.next();
		int year = stdin.nextInt();
		int price = stdin.nextInt();
		String publisher = stdin.next();

		// 1.빌드패스(이미 설정함.)
		try {
			// 2.드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3. db연결
			conn = DriverManager.getConnection(url, id, pw);

			// 4. preparedStatement객체 생성
			String sql = "insert into book values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4-1. ? 채워주기
//			pstmt.setString(1, bookDTO.getNo());
//			pstmt.setString(2, bookDTO.getTitle());
//			pstmt.setString(3, bookDTO.getAuthor());
//			pstmt.setInt(4, bookDTO.getYear());
//			pstmt.setInt(5, bookDTO.getPrice());
//			pstmt.setString(6, bookDTO.getPublisher());
			pstmt.setString(1, no);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setInt(4, year);
			pstmt.setInt(5, price);
			pstmt.setString(6, publisher);

			// 5. 실행
			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("레코드가 추가 되었습니다.");
			} else {
				System.out.println("레코드가 추가 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	// book테이블에 있는 모든 데이터 출력
	public void selectBook() {
		try {
			// 2.드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3.db연결
			conn = DriverManager.getConnection(url, id, pw);

			// 4.쿼리문
			String sql = "select* from book";
			pstmt = conn.prepareStatement(sql);

			// 5. pstmt을 실행한다.
			rs = pstmt.executeQuery();

			// 6. 출력
			while (rs.next()) {
				String no = rs.getString(1);
				String title = rs.getString(2);
				String author = rs.getString(3);
				int year = rs.getInt(4);
				int price = rs.getInt(5);
				String publisher = rs.getString(6);
				System.out.printf("%s\t%s \t%s\t%d\t%d\t%s\n", no, title, author, year, price, publisher);
//				System.out.printf("%s\t%s ", no, title);
//				System.out.printf("\t%s\t%d\t%d\t%s\n",author, year, price, publisher);
			}
		} catch (Exception e) {
			System.out.println("DB연결 에러 발생....");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new BookDAO().insertBook();
		new BookDAO().selectBook();
	}

}
