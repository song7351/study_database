package algorismProject2;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("상품 목록의 크기입력: ");
		int max = s.nextInt();
		Binary b = new Binary(max);
		
		while(true) {
			//메뉴표시
			System.out.println("(1) 상품 등록 (2) 상품 삭제 (3) 상품 검색 (4) 전체 상품 조회 (5) 종료");
			System.out.print("메뉴 선택: ");
			int menu = s.nextInt();
			
			if(menu == 5) {
				System.out.println("종료합니다.");
				break;
			}
			
			switch(menu) {
			case 1://(1)상품등록
				System.out.println("상품 등록");
				System.out.print("상품 번호 입력: ");
				int pNum = s.nextInt();
				s.nextLine();
				System.out.print("상품명 입력: ");
				String pName = s.nextLine();
				
				//메서드 (pNum, pName)
				b.input(pNum, pName);
				break;
				
			case 2://(2)상품삭제
				System.out.println("상품 삭제");
				System.out.print("상품 번호 입력: ");
				pNum = s.nextInt();
				
				//메서드 (pNum)
				b.delete(pNum);
				break;
				
			case 3://(3)상품검색
				System.out.println("상품 검색");
				System.out.print("상품 번호 입력: ");
				pNum = s.nextInt();
				
				//메서드 (pNum)
				String res = b.search(pNum);
				
				if(res != "-1") {
					System.out.println("상품명 : "+res);
				}else {
					System.out.println("등록된 상품이 아닙니다.");
				}
				
				break;
				
			case 4://(4)전체상품조회
				System.out.println("전체 상품 조회");
				
				//메서드 ()
				b.list();
				
				break;
			}
			
		}
		
		
		
		
		
		s.close();
	}

}
