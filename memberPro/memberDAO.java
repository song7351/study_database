package dao;

import java.util.ArrayList;
import java.util.List;

import dbConn.mysqlConnection;
import dto.memberDTO;

public class memberDAO extends mysqlConnection{
	//1.회원목록
	public List<memberDTO> memberList() {
		System.out.println("memberDAO.memberList() start!");
		//dto객체를 담을 ArrayList객체를 생성한다.
		List<memberDTO> list = new ArrayList<memberDTO>();
		
		try {
		//select
			getConn(); //db연결
			
			String sql = "select num, username, tel, email, birth, gender, writedate "
					+ "from member order by num";
			pstmt = conn.prepareStatement(sql);
			
		//rs(실행)
			rs = pstmt.executeQuery();
			
		//dto,dto,dto
			while(rs.next()) {
				memberDTO dto = new memberDTO();
				dto.setNum(rs.getInt(1));
				dto.setUsername(rs.getString(2));
				dto.setTel(rs.getString(3));
				dto.setEmail(rs.getString(4));
				dto.setBirth(rs.getString(5));
				dto.setGender(rs.getString(6));
				dto.setWritedate(rs.getString(7));
				
				list.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("회원선택 예외발생!!!!");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return list;
	}
	
	
	//2.회원등록
	public int memberInsert(memberDTO dto) {
		System.out.println("memberDAO.memberInsert() start!");
		//결과를 리턴시킬 변수
		int result = 0;
		
		try {
			getConn();
			
			String sql = "insert into member(username, tel, email, birth, gender) values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			//values 값을 세팅
			pstmt.setString(1,dto.getUsername());
			pstmt.setString(2,dto.getTel());
			pstmt.setString(3,dto.getEmail());
			pstmt.setString(4,dto.getBirth());
			pstmt.setString(5,dto.getGender());
			
			//추가된 레코드의 수를 반환.
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원등록예외발생.....");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	
	//3.회원수정
	public int memberUpdate(String que, memberDTO dto) {
		System.out.println("memberDAO.memberUpdate() start!");
		int result = 0;
		try {
			getConn();
			
			String sql = "update member set ";
			if(que.equals("1")) {
				sql += " tel=? ";
			}else if(que.equals("2")) {
				sql += " email=? ";
			}
			sql += " where num=? ";
			
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			
			// ? 값 입력
			if(que.equals("1")) {
				pstmt.setString(1, dto.getTel());
			}else if(que.equals("2")) {
				pstmt.setString(1, dto.getEmail());
			}
			pstmt.setInt(2, dto.getNum());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원수정 예외발생....");
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return result;
	}
	//4.회원삭제
	public int memberDelete(int num) {
		System.out.println("memberDAO.memberDelete() start!");
		int result = 0;
		try {
			getConn();
			
			String sql = "delete from member where num=? ";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("회원삭제 예외발생....");
			e.printStackTrace();
		}finally {
			
		}
		return result;
	}
	
	public void memberList2() {
		System.out.println("memberDAO.memberList2() start!");
		try {
			getConn();
			String sql = "select num, username, tel, email, birth, gender, writedate "
					+ " from member order by num ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("%5d %10s %20s %20s %10s %5s %20s\n",
						rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println("회원선택 예외발생.....");
			e.printStackTrace();
		}finally {
			dbClose();
		}
	}
}
