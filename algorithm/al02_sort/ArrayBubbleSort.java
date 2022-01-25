package al02_sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayBubbleSort {

	public static void swap(int a[], int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	//오름차순
	public static void mySort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > 0; j--) { // j=9
				if (a[j - 1] > a[j]) { // 8번째랑 9번째랑 비교해서 9번째가 더 작다면?
					swap(a, j - 1, j); // 8번 9번을 교환해라
				}
			}
			System.out.println((i+1) + "번정렬: " + Arrays.toString(a));
		}
	}
	
	//내림차순
	public static void mySort_r(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > 0; j--) { // j=9
				if (a[j - 1] < a[j]) { // 8번째랑 9번째랑 비교해서 9번째가 더 크다면?
					swap(a, j - 1, j); // 8번 9번을 교환해라
				}
			}
			System.out.println((i+1) + "번정렬: " + Arrays.toString(a));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터 준비
		// 난수 1 ~ 100까지 난수를 생성해서 크기순으로 정렬(오름차순)
		Random ran = new Random();
		// 대충 10개만 해봅시다.
		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = ran.nextInt(100) + 1; // 1 ~ 100;
		}
		// 정렬하기 전 배열확인
		System.out.println("정렬전: " + Arrays.toString(arr));

		mySort_r(arr, 10);
		System.out.println("정렬후: " + Arrays.toString(arr));
	}

}
