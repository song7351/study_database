package al03_stack_queue;

public class InStack {
	int capacity; // 최대로 저장할 수 있는 객체의 수
	int stk[]; // 정수를 저장할 수 있는 배열을 생성
	int point; // stack의 채워진 값의 위치+1;

	InStack() {

	}

	InStack(int max) {
		capacity = max;
		point = 0;
		stk = new int[max];
	}

	// 데이터의 수를 리턴하는 메소드
	public int getSize() {
		System.out.println("InStack.getSize 실행.");
		return point;
	}

	// 메모리의 크기를 리턴하는 메소드
	public int getCapacity() {
		// System.out.println("InStack.getCapacity 실행.");
		return capacity;
	}

	// 메뉴 1.push : 제일 마지막 위치에 값을 추가한다.
	public int push(int data) throws OverflowIntStackException {
		System.out.println("InStack.push 실행.");
		if (point >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[point++] = data;
	}

	// 오버플로우 발생시 예외처리 클래스
	class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {

		};
	}

	// 메뉴 2.pop : 제일 마지막 값(point-1)을 제외시킨다.
	public int pop() throws EmptyIntStackException {
		System.out.println("InStack.pop 실행.");
		if (point <= 0) {// 스택이 비어져있을때.
			throw new EmptyIntStackException();
		}
		return stk[--point];
	}

	// 메뉴 3.peek : 제일 마지막 값(point-1)을 얻어온다.
	public int peek() throws EmptyIntStackException {
		System.out.println("InStack.peek 실행.");
		if (point <= 0) {// 스택이 비어져있을때.
			throw new EmptyIntStackException();
		}
		return stk[point - 1];
	}

	// 언더플로우 발생시 예외처리 클래스
	class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {

		};
	}

	// 메뉴 4.print : 스택의 모든 데이터를 출력한다.
	public void print() throws EmptyIntStackException {
		System.out.println("InStack.print 실행.");
		if (point <= 0) {// 스택이 비어져있을때.
			System.out.println("스택이 비어있습니다..");
		} else {
			for (int i = 0; i < point; i++) {
				System.out.println("stk[" + i + "]=" + stk[i]);
			}
		}

	}

	// 메뉴 5.search: 값의 인덱스 구하기.
	// 특징 검색은 역순(마지막 값부터)으로 실행.
	public int indexOf(int search) {
		System.out.println("InStack.indexOf 실행.");
		for (int i = point - 1; i >= 0; i--) {
			if (stk[i] == search) {
				return i;
			}
		}
		return -1;
	}

	// 메뉴 6.empty: 값이 비어있는가?
	// 특징 검색은 역순(마지막 값부터)으로 실행.
	public boolean isEmpty() {
		//return (point<=0) ? true : false;
		return point<=0;
	}
	
	// 메뉴 7.정보표시: 스택이 가득차있는가?
	public boolean isFull() {
		return (point>=capacity) ? true : false;
	}
}
