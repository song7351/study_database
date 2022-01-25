package algorismProject2;

public class Binary {
	//대충 크기 100인 목록을 만든다.
	String[] catalog;
	
	Binary(int max){
		catalog = new String[max];
	}
	
	//(1)상품등록
	public void input(int pNum, String pName) {
		if(catalog[pNum-1] == null) {
		catalog[pNum-1] = pName;
		}else {
			System.out.println("이미 등록된 번호입니다.");
		}
	}
	
	//(2)상품삭제
	public void delete(int pNum) {
		if(catalog[pNum-1] != null) {
		catalog[pNum-1] = null;
		System.out.println("상품 삭제 완료");
		}else {
		System.out.println("이미 삭제된 번호입니다.");
		}
	}
	
	//(3)상품검색
	public String search(int pNum) {
		int left = 0;
		int right = catalog.length-1;
		
		do {
			//중간 인덱스를 구한다.
			int center = (left+right)/2;
			if(pNum-1 == center) {
				return catalog[center];
			}else if(pNum-1 > center) {
				left = center + 1;
			}else if(pNum-1 < center) {
				right = center - 1;
			}
		}while(left <= right);
		
		return "-1";
	}
	
	//(4)전체상품조회
	public void list() {
		int cnt = 0;
		for(int i=0; i<catalog.length; i++) {
			if(catalog[i] != null) {
				System.out.printf("%3d\t%s\n",(i+1),catalog[i]);
				cnt += 1;
			}
		}
		if(cnt == 0) {
			System.out.println("등록된 상품이 없습니다.");
		}
	}
	
}
