package algorismProject1;

import java.util.Scanner;

public class QuickSort {

	public static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void myQuick(int[] a, int left, int right) {
		int pl = left;	//왼쪽인덱스, 최초에는 0
		int pr = right;	//오른쪽인덱스, 최초에는 배열의 끝
		int std = a[(left+right)/2]; //기준인덱스 배열값, 배열의 중심이자 대소관계를 비교하는 유일한 기준

		// 내림차순 정렬:[ 왼쪽) 크다 (기준) 작다 (오른쪽 ]
		do {
			// 왼쪽이 기준보다 크다면 그대로 유지하고 +1 인덱스를 확인해야함.
			// 그러나, 기준보다 작다면 기준의 오른쪽으로 넘겨야함.
			while(a[pl]>std) {
				pl++;
			}
			// 오른쪽은 기준보다 작다면 그대로 유지하고 -1 인덱스를 확인해야함.
			// 그러나, 기준보다 크다면 기준의 왼쪽으로 넘겨야함.
			while(a[pr]<std) {
				pr--;
			}
			//21행과 26행에 해당하는 인덱스들끼리 교환해야함.
			//언제? pl <= pr 왼쪽 포인트가 오른쪽 포인트보다 같거나 작을때
			if(pl<=pr) {
				//교환할 pl과 pr은 교환했으니 각자 다음인덱스를 찝어야함.
				//그래서 pl++, pr--;
				swap(a,pl++,pr--);
			}
		}while(pl<=pr);
		
		//myQuick 함수는 결국, 1회 변경하는 메서드.
		//전체 반복을 하려면? 재귀호출!
		//pr(오른쪽 포인트)이 지속적으로 감소해도 left(0)보다 크다면,
		if(left<pr) {
			//최초의 right = pr이 됨. why? 위의 do-while문으로 이미 right는 변경했음.
			myQuick(a,left,pr);
		}
		//pl(왼쪽 포인트)이 지속적으로 증가해도 right(배열길이)보다 작다면,
		if(pl<right) {
			//위와 상동
			myQuick(a,pl,right);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("학생 수 입력: ");
		int num = s.nextInt();
		System.out.println("");
		int[] sc = new int[num];
		for (int i = 0; i < sc.length; i++) {
			System.out.print("학생" + (i + 1) + " 점수 입력: ");
			sc[i] = s.nextInt();
		}
		System.out.println("");

		// 퀵정렬 메서드
		myQuick(sc, 0, sc.length - 1);

		System.out.println("성적 순으로 정렬");
		for (int i = 0; i < sc.length; i++) {
			System.out.println((i + 1) + "등 : " + sc[i]);
		}
		
		s.close();
	}

}
