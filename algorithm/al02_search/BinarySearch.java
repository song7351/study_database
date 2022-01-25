package al02_search;
//이진검색
//1. 데이터가 정렬되어 있어야 한다.
//2. 가운데 위치를 구해서 검색한다.

import java.util.Scanner;

public class BinarySearch {

	static int binarySearch(int arr[], int n, int key) {
		//왼쪽 배열의 시작은 항상 0
		int left = 0; 
		//오른쪽 배열의 끝은 데이터의개수, 배열의 길이
		int right = n-1;
		
		do {
			//중간 인덱스를 구한다.
			int center= (left+right)/2;
			if(key == arr[center]) {
				return center;
			}else if(key > arr[center]) {
				left = center+1;
			}else if(key < arr[center]) {
				right = center-1;
			}
		}while(left <= right);
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int arr[] = new int[n];
		for(int i=0; i<arr.length; i++) {
			System.out.print("arr["+i+"]= ");
			arr[i] = s.nextInt();
		}
		
		//검색할 숫자 받기
		int key = s.nextInt();
		
		//이진검색
		int result = binarySearch(arr,n,key);
		if(result != -1) {
			System.out.println(key+"는 arr["+result+"]에 있습니다.");
		}else {
			System.out.println(key+"는 존재하지 않는 데이터입니다.");
		}
		
		
		s.close();
		
	}

}
