package dbProject;
// 실습1의 book 테이블 구조와 동일

public class BookDTO {
	private String no;
	private String title;
	private String author;
	private int year;
	private int price;
	private String publisher;

	public BookDTO(String no, String title, String author, int year, int price, String publisher) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.publisher = publisher;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
	
}
