package al02_sort;

import java.util.Arrays;
import java.util.Scanner;

/*
국어점수를 입력받아 점수순으로 출력하라.
 출력
 국어점수의 수: (입력)5
 국어점수1:(입력)56
 국어점수2:92
 국어점수3:95
 국어점수4:85
 국어점수5:56
 
 점수순으로 출력
 1등: ~
 :
 5등: ~
 
 */

public class QuickSortEx {
	
	//위치 교환하는 메서드
	public static void swap(int a[], int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	//퀵정렬
	public static int[] myQuick(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = a[(left+right)/2];
		
		do {
			while(a[pl] < pivot) {
				pl++;
			}
			while(a[pr] > pivot) {
				pr--;
			}
			if(pl <= pr) {
				swap(a,pl++,pr--);
			}
		}while(pl<=pr);
		
		if(left<pr) {
			myQuick(a, left, pr);
		}
		if(pl<right) {
			myQuick(a, pl, right);
		}
		return a;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("국어점수의 수: ");
		int num = s.nextInt();
		int[] sc = new int[num];
		for(int i=0; i<num; i++) {
			System.out.print("국어점수"+(i+1)+": ");
			int score = s.nextInt();
			sc[i] = score;
		}
		System.out.println(Arrays.toString(sc));
		sc = myQuick(sc,0,sc.length-1);
		
		for(int i=sc.length-1; i>-1; i--) {
			System.out.println((num-i)+"등: "+sc[i]);
		}
	}

}
