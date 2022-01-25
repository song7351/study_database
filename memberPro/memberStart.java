import java.util.List;
import java.util.Scanner;

import dao.memberDAO;
import dto.memberDTO;

public class memberStart {
	Scanner scan = new Scanner(System.in);

	public void start() {
		System.out.println("memberStart.start() start!");
		while (true) {
			menuOutput();
			int menu = Integer.parseInt(scan.nextLine());
			if (menu == 1) {
				//1.회원목록
				memberAllList();
			} else if (menu == 2) {
				//2.회원등록
				memberInsert();
			} else if (menu == 3) {
				//3.회원수정
				memberEdit();
			} else if (menu == 4) {
				//4.회원삭제
				memberDel();
			} else if (menu == 5) {
				// 프로그램을 종료시킨다.
				System.exit(0);
			} else {
				System.out.println("메뉴를 잘못 입력하였습니다.");
			}
		}

	}
	//회원정보 수정하기
	public void memberEdit() {
		System.out.println("memberStart.memberEdit() start!");
		memberDTO dto = new memberDTO();
		//수정할 회원번호를 입력받고
		System.out.print("수정할 회원번호-> ");
		dto.setNum(Integer.parseInt(scan.nextLine()));
		//연락처, 이메일을 확인한 후
		System.out.print("수정할 항목을 번호입력(1.연락처, 2.이메일)-> ");
		String que = scan.nextLine();
		if(que.equals("1")) {//1.연락처
			System.out.print("수정할 연락처-> ");
			dto.setTel(scan.nextLine());
		}else if(que.equals("2")) {//2.이메일
			System.out.print("수정할 이메일-> ");
			dto.setEmail(scan.nextLine());
		}
		//업데이트
		memberDAO dao = new memberDAO();
		int cnt =dao.memberUpdate(que, dto);
		//결과
		if(cnt>0) {//수정됨
			System.out.println("회원정보가 수정되었습니다.");
		}else {//수정실패
			System.out.println("회원정보 수정 실패했습니다.");
		}
		
	}
	//회원정보 지우기
	public void memberDel() {
		System.out.println("memberStart.memberDel() start!");
		//삭제할 회원번호
		System.out.print("삭제할 회원번호-> ");
		int num = Integer.parseInt(scan.nextLine());
		
		memberDAO dao = new memberDAO();
		int result = dao.memberDelete(num);
		if(result>0) {
			System.out.println(num+"번 회원이 삭제되었습니다.");
		}else {
			System.out.println(num+"번 회원 삭제실패하였습니다.");
		}
	}
	
	//회원등록하기
	public void memberInsert() {
		System.out.println("memberStart.memberInsert() start!");
		//등록할 회원정보를 입력받아 DTO객체 setter를 한다.
		memberDTO dto = new memberDTO();
		System.out.print("이름-> ");
		dto.setUsername(scan.nextLine());
		System.out.print("연락처-> ");
		dto.setTel(scan.nextLine());
		System.out.print("이메일-> ");
		dto.setEmail(scan.nextLine());
		System.out.print("생년월일(ex:1900-10-10)-> ");
		dto.setBirth(scan.nextLine());
		System.out.print("성별(M,F)-> ");
		dto.setGender(scan.nextLine());
		
		memberDAO dao = new memberDAO();
		int result = dao.memberInsert(dto);
		if(result>0) {//회원등록
			System.out.println(dto.getUsername()+"의 정보가 등록되었습니다.");
		}else {//등록실패
			System.out.println("회원등록이 실패하였습니다.");
		}
	}
	
	//전체 회원목록 선택하기.
	public void memberAllList() {
		System.out.println("memberStart.memberAllList() start!");
		memberDAO dao = new memberDAO();
		List<memberDTO> list = dao.memberList();
		for(int idx=0; idx<list.size(); idx++) {// 0,1,2,3···
			//list에서 index위치의 객체를 구하여(dto) 콜솔에 출력한다.
			//memberDTO dto = list.get(idx);
			//출력
			//oneMemberOutput(dto);
			
			//37~39행과 같음.
			oneMemberOutput(list.get(idx));
		}
	}
	
	//1명의 회원을 출력하는 메소드.
	public void oneMemberOutput(memberDTO dto) {
		System.out.println("memberStart.oneMemberOutput() start!");
		//번호, 이름, 연락처, 이메일, 생년, 성별, 등록일
		System.out.printf("%5d %10s %20s %20s %10s %5s %20s\n",
				dto.getNum(),dto.getUsername(),dto.getTel(),dto.getEmail(),
				dto.getBirth(),dto.getGender(),dto.getWritedate());
	}

	public void menuOutput() {
		System.out.println("memberStart.menuOutput() start!");
		System.out.print("[메뉴] 1.회원목록 2.회원등록 3.회원수정 4.회원삭제 5.종료 : ");
	}

	//출력하는 또다른 방법.
//	public void memberList() {
//		memberDAO dao = new memberDAO();
//		dao.memberList2(); //모든회원출력
//	}
	
	public static void main(String[] args) {
		new memberStart().start();
	}
	
	

}
