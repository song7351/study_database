package al03_stack_queue;

import java.util.Scanner;

public class IntQueueMain {
	
	static Scanner s = new Scanner(System.in);
	//메뉴를 입력받는 메소드
	static String getMenu() {
		System.out.print("[메뉴]1.(추가)enqueue, 2.(삭제)dequeue, 3.(확인)peek, 4.(모두확인)info, 9.end ? ");
		return s.nextLine();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntQueue queue = new IntQueue(10);
		
		while(true) {
			String menu = getMenu();
			if(menu.equals("9")) {
				break;
			}else {
				switch (menu) {
				case "1": //1.(추가)enqueue
					System.out.println("1.(추가)enqueue를 실행합니다.");
					System.out.print("큐에 추가할 데이터: ");
					int data = Integer.parseInt(s.nextLine());
					try {
						int result = queue.enqueue(data);
					} catch (Exception e) {
						System.out.println("큐가 가득찼습니다.");
					}
					break;
					
				case "2": //2.(삭제)dequeue
					System.out.println("2.(삭제)dequeue를 실행합니다.");
					try {
						int result = queue.dequeue();
						System.out.println("큐에서 가져온 데이터: "+result);
					} catch (Exception e) {
						System.out.println("큐가 비어있습니다.");
					}
					break;

				case "3": //3.(확인)peek
					try {
						queue.peek();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("큐가 비어있습니다.");
					}
					break;
					
				case "4": //4.(모두확인)info
					System.out.println("큐의 크기: "+queue.getCapacity());
					System.out.println("데이터의 수: "+queue.getSize());
					System.out.println("front index: "+queue.getFrontIndex());
					System.out.println("rear index: "+queue.getRearIndex());
					try {
						int res = queue.getFrontData();
					System.out.println("front data: "+res);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("front data: 큐가 비어있습니다.");
					}
					System.out.println("rear data: "+queue.getRearData());
					
					break;
					
				case "5": //1.(추가)enqueue
					
					break;
				case "6": //1.(추가)enqueue
					
					break;
				case "7": //1.(추가)enqueue
					
					break;
				case "8": //1.(추가)enqueue
					
					break;

				default: //1~9번 이외
					System.out.println("메뉴를 잘못선택하였습니다.");
					break;
				}
				
				
			}
		}
		System.out.println("프로그램이 종료되었습니다.");
		
		
		
	}

}
