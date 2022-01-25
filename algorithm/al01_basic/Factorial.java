package al01_basic;

import java.util.Scanner;

/*
 1행: 입력
 2행: 결과
 실행
 5
 120
 */

public class Factorial {
	
	//(for문)
	static int factorial1(int max) {
		// 5*···*1
		// 결과를 저장할 변수
		int result = 1;
		for(int i=max; i>=1; i--) {
			result *= i;
		}
		return result;
	}
	
	//(재귀호출)
	static int result = 1;
	public static void factorial2(int max) {
		if(max<=0) {
			return; //여기 걸리면 종료
		}
		result *= max;
		factorial2(max-1);
	}
	
	//(재귀호출 - 반환형)
	public static int factorial3(int max) {
		if(max<=1) {
			return 1;
		}
		return max*factorial3(max-1);
	}
	// max = 5
	// 5*factorial3(4) == 5*4*factorial3(3) == 5*4*3*factorial3(2) == 5*4*3*2*factorial3(1) == 5*4*3*2*1
	
	//(while문)
		public static int factorial4(int max) {
			int result = 1;
			while(max >= 1) {
				result *= max;
				max--;
			}
			return result;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		//입력한 수 까지 팩토리얼 구하기.
		int max = s.nextInt();
		
		//(for문)
		int res1 = factorial1(max);
		System.out.println("for문-> "+res1);
		
		//(재귀호출)
		factorial2(max);
		System.out.println("재귀함수-> "+result);
		
		//(재귀호출-반환형)
		int res2 = factorial3(max);
		System.out.println("재귀함수-> "+res2);
		
		//(while문)
		int res3 = factorial4(max);
		System.out.println("While문-> "+res3);
		
	}

}
