package dbProject;

//도서 정보를 입력받아서 BookDAO 클래스의 insertBook() 메서드 호출하고 전달
// - 입력데이터 : BOO4 자바스크립트 강길동 2020 28000 서울출판사
// BookDAO 클래스의 selectBook() 호출해서 데이터 출력되도록 함.

public class BookTest {

	public BookTest() {

	}

	public static void main(String[] args) {
//		new BookDAO().insert('B004',"자바스크립트","강길동",2020,28000,'서울출판사');
//		BookDAO().selectBook();
		
		new BookDAO().insertBook();
		
		new BookDAO().selectBook();

	}

}
