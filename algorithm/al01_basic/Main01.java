package al01_basic;

import java.util.Scanner;

public class Main01 {
/*
 1행. 입력받을 년도의 갯수.
 2행. 년도 입력
 3행. 실행결과

 실행(1)
 6
 4 100 400 2000 2001 2004
 #1 윤년
 #2 평년
 #3 윤년
 #4 윤년
 #5 평년
 #6 윤년
 실행(2)
 3
 200 205 6000
 */
	public static void main(String[] args) {
//		Scanner stdin = new Scanner(System.in);
//		int cnt = stdin.nextInt();
//		int[] year = new int[cnt];
//		String ans;
//		for(int i=0; i<cnt; i++) {
//			year[i] = stdin.nextInt();
//		}
//		for(int i=0; i<year.length; i++) {
//			if(year[i] % 4 == 0 && year[i] % 100 != 0||year[i] % 400 == 0) {
//				ans = "윤년";
//			}else {
//				ans = "평년";
//			}
//			System.out.println("#"+(i+1)+" "+ans);
//		}
		
		Scanner s = new Scanner(System.in);
		int n = Integer.parseInt(s.nextLine());
		String data[] = s.nextLine().split(" ");
		String r[] = new String[n];
		for(int i=0; i<n; i++) {
			int y = Integer.parseInt(data[i]);
			if(y%4==0&&y%100!=0||y%400==0) {
				r[i] = "윤년";
			}else {
				r[i] = "평년";
			}
		}
		for(int i=1; i<= n; i++) {
			System.out.println("#"+i+" "+r[i-1]);
		}
		s.close();
		
	}
}
