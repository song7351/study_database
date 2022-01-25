package al02_sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayInsertionSort {

	//삽입정렬
	static void mySortint(int[] a, int n) {
		for(int i=1; i<n; i++) { //1,···,9
			int temp = a[i];
			int j;
			for(j=i; j>0 && a[j-1]> temp; j--) { //처음엔 1만 실행.
				if(a[j-1]>temp) {
					a[j] = a[j-1];
				}
			}
			a[j] = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int a[] = new int[10];
		for(int i=0; i<a.length; i++) {
			a[i] = r.nextInt(100); // 0~99
		}
		
		System.out.println("정렬전: "+Arrays.toString(a));
		mySortint(a, a.length);
		System.out.println("정렬후: "+Arrays.toString(a));

		
		
		
		
		
	}

}
