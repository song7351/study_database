package al01_basic;

import java.util.Scanner;

public class solution02 {
	/*
	 실행
	 5
	 5*2 = 10
	 :
	 :
	 5*9 = 45
	 */
	
	public static void gugudan(int num) {
		for(int i=2; i<=9; i++) {
			int r = num*i;
			System.out.printf("%2d * %2d = %-4d\n", num,i,r);
		}
	}
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int num = stdin.nextInt();
		gugudan(num);
		stdin.close();
	}


}
