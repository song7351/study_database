package dbProject;

//���� ������ �Է¹޾Ƽ� BookDAO Ŭ������ insertBook() �޼��� ȣ���ϰ� ����
// - �Էµ����� : BOO4 �ڹٽ�ũ��Ʈ ���浿 2020 28000 �������ǻ�
// BookDAO Ŭ������ selectBook() ȣ���ؼ� ������ ��µǵ��� ��.

public class BookTest {

	public BookTest() {

	}

	public static void main(String[] args) {
//		new BookDAO().insert('B004',"�ڹٽ�ũ��Ʈ","���浿",2020,28000,'�������ǻ�');
//		BookDAO().selectBook();
		
		new BookDAO().insertBook();
		
		new BookDAO().selectBook();

	}

}
