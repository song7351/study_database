package al03_stack_queue;

import java.util.Scanner;

import al03_stack_queue.InStack.EmptyIntStackException;
import al03_stack_queue.InStack.OverflowIntStackException;

public class InstackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("stack의 크기입력: ");
		int max = s.nextInt();

		InStack stack = new InStack(max);
		while (true) {
			// 현재스택의 데이터개수와 스택의 크기를 출력하고
			System.out.print("데이터의 수 -> " + stack.getSize());
			System.out.println(", 메모리크기 -> " + stack.getCapacity());
			// 메뉴표시: push pop peek print search empty stack정보확인 종료
			System.out.println("[메뉴]1.push, 2.pop, 3.peek, 4.print(dump) 5.search 6.empty 7.정보표시 8.종료");
			int menu = s.nextInt();

			if (menu == 8) {
				break;
			}
			// 변수, 수식, 상수, -> 정수형, char, String
			switch (menu) {
			case 1: // 메뉴 1.push
				System.out.print("스택에 추가할 데이터: ");
				int data = s.nextInt();
				try {
					int result = stack.push(data);
					System.out.println("스택에 push한 데이터: " + result);
				} catch (OverflowIntStackException oise) {
					// TODO: handle exception
					System.out.println("(Overflow)스택이 가득찼습니다.");
				}
				break;

			case 2: // 메뉴 2.pop
				System.out.print("스택에서 pop합니다.");
				try {
					int result = stack.pop();
					System.out.println("스택에 pop한 데이터: " + result);
				} catch (EmptyIntStackException oise) {
					// TODO: handle exception
					System.out.println("(Underflow)스택이 비어있습니다.");
				}
				break;

			case 3: // 메뉴 3.peek
				System.out.print("스택에서 peek합니다.");
				try {
					int result = stack.pop();
					System.out.println("스택에 peek한 데이터: " + result);
				} catch (EmptyIntStackException oise) {
					// TODO: handle exception
					System.out.println("(Underflow)스택이 비어있습니다.");
				}
				break;

			case 4: // 메뉴 4.print(dump)
				System.out.print("스택의 모든데이터를 print합니다.");
				stack.print();
				break;

			case 5: // 메뉴 5.search: 값의 인덱스 구하기.
				System.out.println("값을 search 합니다.");
				System.out.print("search할 데이터: ");
				int search = s.nextInt();
				
				int idx = stack.indexOf(search);
				if(idx>=0) {
					System.out.println(search+"는 스택의 "+idx+"위치에 존재합니다.");
				}else {
					System.out.println(search+"는 스택에 존재하지 않습니다.");
				}
				break;
				
			case 6: // 메뉴 6.empty: 스택이 비어있는가?
				System.out.println("스택에서 empty를 실행합니다.");

				if (stack.isEmpty()) {
					System.out.println("스택에 데이터가 비어 있습니다.");
				}else {
					System.out.println("스택에 데이터가 모두 있습니다.");
				}
				break;
				
			case 7: // 메뉴 7.empty: 정보표시(스택의 크기, 데이터갯수, 비어있는지, 가득찼는지
				System.out.println("스택에서 정보표시를 실행합니다.");
				System.out.println("스택의 크기는 "+stack.getCapacity()+"입니다.");
				System.out.println("테이터의 갯수는 "+stack.getSize()+"입니다.");
				System.out.println("데이터 존재유무: "+((stack.isEmpty()) ? "없음" : "있음"));
				System.out.println("데이터 full유무: "+((stack.isFull()) ? "full" : "not full"));
				break;

			default:
				break;
			}
			System.out.println("프로그램이 종료되었습니다.");
		}
		
		s.close();
	}

}
