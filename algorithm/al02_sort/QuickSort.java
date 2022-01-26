package al02_sort;

import java.util.Arrays;

public class QuickSort {

	public static void swap(int a[], int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void myQuick(int[] a, int left, int right) {
		int pl = left; // 왼쪽부터 검색 index
		int pr = right; // 오른쪽부터 검색 index
		int pivot = a[(left + right) / 2];

		// 오른차순 정렬:[ 왼쪽) 작다 (기준) 크다 (오른쪽 ]
		// 왼쪽이 기준보다 작으면 그대로 유지하고 +1 인덱스를 확인해야함.
		// 그러나, 기준보다 크다면 기준의 오른쪽으로 넘겨야함.
		// 오른쪽은 기준보다 크다면 그대로 유지하고 -1 인덱스를 확인해야함.
		// 그러나, 기준보다 작다면 기준의 왼쪽으로 넘겨야함.
		// 피벗기준 왼쪽에서 오른쪽으로 피벗의 값보다 큰데이터가 있는 index찾기
		do {
			while (a[pl] < pivot) {
				pl++;
			}
			while (a[pr] > pivot) {
				pr--;
			}
			if (pl <= pr) {
				swap(a, pl++, pr--);
			}
		} while (pl <= pr);

		System.out.println(Arrays.toString(a));
		System.out.println("pl-> "+pl+", pr-> "+pr);
		if(left<pr) {
			myQuick(a, left, pr);
		}
		if(pl<right) {
			myQuick(a, pl, right);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 175, 170, 160, 168, 165, 170, 155, 150 };
		System.out.println(Arrays.toString(arr));
		myQuick(arr, 0, arr.length-1);
	}

}
