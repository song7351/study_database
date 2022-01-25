package al02_search;

import java.util.Scanner;

//선형검색(LinearSearch, SequenceSearch)
//순차적으로 검색한다.
//key의 값이 있는 위치를 구하여 index를 반환하는 메소드.

public class SequenceSearch {

	static int linearSearch1(int[] data, int n, int key) {
		// 배열에서 key값을 검색하여 index를 리턴해준다.
		// 검색 결과가 없다면 -1을 리턴.
		for (int i = 0; i < n; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
	}
	
	static int linearSearch2(int[] d, int n, int k) {
		// 배열에서 key값을 검색하여 index를 리턴해준다.
		// 검색 결과가 없다면 -1을 리턴.
		int i =0;
		while(true) {
			if(i==n) {
				return -1;
			}
			if(d[i] == k) {
				return i;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		// 데이터의 갯수 입력: 배열을 생성
		System.out.print("데이터수-> ");
		int n = s.nextInt();

		// 배열을 생성
		int data[] = new int[n];
		for (int i = 0; i < data.length; i++) {
			System.out.print("data[" + i + "]= ");
			data[i] = s.nextInt();
		}

		// 찾을 숫자를 입력받는다.
		System.out.print("검색할 데이터-> ");
		int key = s.nextInt();

		/// for를 이용한 선형검색 호출
		int idx = linearSearch1(data, n, key);
		
		//검색한 데이터가 있을때or 없을때.
		if(idx != -1) {
			System.out.println(key+"는 data["+idx+"]에 있습니다.");
		}else {
			System.out.println(key+"는 존재하지 않는 데이터입니다.");
		}
		
		int idx2 = linearSearch2(data,n,key);
		if(idx2 != -1) {
			System.out.println(key+"는 data["+idx+"]에 있습니다.");
		}else {
			System.out.println(key+"는 존재하지 않는 데이터입니다.");
		}
		s.close();
		
	}
	

}
