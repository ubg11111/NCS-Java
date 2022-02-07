package khie;

import java.util.Scanner;

/*
 * 배열의 데이터를 저장
 * - 내림차순으로 정렬할 예정.
 * 	예)19, 43, 6, 97, 65
 * 	==> 97,65,43,19,6
 */


public class Ex08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열의 크기 입력 >>> ");
		
		
		// int[] score 배열에 new int[sc.nexInt()] 키보드로 입력받은 값만큼 배열을 생성한다. 3을 입력하는경우 score[0],score[1],score[2]가 생성
		int[] score = new int[sc.nextInt()];
		
		// for반복문을 통하여 score[i] 입력받은 값만큼 저장된 각 배열에 값을 초기화한다 
		// ex) score[0] = 20 , score[1] = 10 , score[2] =33
		for(int i=0; i<score.length; i++) {
			
			System.out.print((i+1) + " 번째 정수 입력 >>> ");
			
			// 키보드로 입력한 각 배열의 정수값을 score[i]배열의 값만큼 저장한다 
			// ex) score[0] = 20 , score[1] = 10 , score[2] =33 >>>> score[i]
			score[i] = sc.nextInt();
		}
		
		// 내림차순으로 정렬을 진행해 보자.
		
		// 값을 섞기 위해 temp라는 디폴트값 변수를 만들어둔다 일종의 담아두는 보조용컵
		int temp = 0;
		
		
		// 다중 for 반복문을 통하여 score.length 만큼 1씩증가
		// for j=i+1 i가 1증가하면 j는 2의 값으로 배열의 수만큼 둘이 같이 증가하는 과정이다.
		for(int i=0; i<score.length; i++) {
			for(int j=i+1; j<score.length; j++) {
				// if score[j] > score[i] >>> j=i+1의값에 의하여 j>i보다 큰것이 참이기에 아래의 조건문이 시행된다.
				if(score[j] > score[i]) {
					// 빈 temp값에 score[i]를 넣는다. 
					temp = score[i];
					// 빈 score[i]값에 score[j]값을 넣는다.
					score[i] = score[j];
					// 빈 score[j]값에 temp값을 넣는다.
					score[j] = temp;
				}
				// 최종적으로 score[i] = score[j]가 되고 , score[j]는 score[i]가되어 값이 섞이는것이다. 
				// 해당 조건문또한 다중for 반복문에의해 계속해서 값을 비교하게되어 내림차순으로 정리되는 것이다.
			}
		}
		
		// 내림차순으로 정렬된 배열을 화면에 출력해 보자
		for(int i=0; i<score.length; i++) {
			System.out.println("score["+i+"] >>> " + score[i]);
		}
		
		
		sc.close();
	}
}
