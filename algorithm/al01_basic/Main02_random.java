package al01_basic;

public class Main02_random {
/*
 1. 1~100까지의 난수를 50개 만들어 합을 구하라.
 2. 한줄에 6개의 난수를 출력하라.
 3. 마지막줄에 합을 출력한다.
 
 실행
 15 65 15 24 35  1
        :
        :
  5  2  6  7 23  6
 23 12
 합=1234
  
 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//난수
//
//		int sum = 0;
//		for(int i=1; i<=50; i++) {
//		int ran = (int)(Math.random()*100)+1;
//		sum += ran;
//		System.out.printf("%3d ",ran);
//		if(i%6==0) {
//			System.out.println();
//		}
//		}
//		System.out.println("\n합="+sum);
//	}
	public static void main(String[] args) {
		int numbers [] = new int [50];
		int sum = 0;
		int count = 1;
		
		for (int i = 0; i <50; i++) {
			numbers[i] = (int)(Math.random()*100)+1;
			sum+= numbers[i];

		}
		for (int j = 0; j < 50; j++) {
			if (count%6==0) {
				count+=1;
				System.out.printf("%3d ",numbers[j]);
				System.out.println();
			}else {
				count+=1;
				System.out.printf("%3d ",numbers[j]);
			}
		}
		System.out.println("\n"+"합="+sum);
	}

}
