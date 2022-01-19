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
	String pw = "��й�ȣ";

	public BookDAO() {
		// ������ �޼���
		// 
	}

	// book���̺� ������ ����
	//(BookDTO bookDTO)
	public void insertBook() {
		// ������ȣ, ��������, ����, ���࿬��, ����, ���ǻ� �Է�
		System.out.print("�Է� ������ : ");
		String no = stdin.next();
		String title = stdin.next();
		String author = stdin.next();
		int year = stdin.nextInt();
		int price = stdin.nextInt();
		String publisher = stdin.next();

		// 1.�����н�(�̹� ������.)
		try {
			// 2.����̺� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3. db����
			conn = DriverManager.getConnection(url, id, pw);

			// 4. preparedStatement��ü ����
			String sql = "insert into book values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			// 4-1. ? ä���ֱ�
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

			// 5. ����
			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("���ڵ尡 �߰� �Ǿ����ϴ�.");
			} else {
				System.out.println("���ڵ尡 �߰� �����߽��ϴ�.");
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

	// book���̺� �ִ� ��� ������ ���
	public void selectBook() {
		try {
			// 2.����̺� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 3.db����
			conn = DriverManager.getConnection(url, id, pw);

			// 4.������
			String sql = "select* from book";
			pstmt = conn.prepareStatement(sql);

			// 5. pstmt�� �����Ѵ�.
			rs = pstmt.executeQuery();

			// 6. ���
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
			System.out.println("DB���� ���� �߻�....");
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
