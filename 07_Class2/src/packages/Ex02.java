package packages;

import java.util.Scanner;
import model.MemberDTO;


/*
 * [문제] 회원 수를 키보드로 입력 받아서 회원 수 만큼 
 * 		객채 배열에 회원의 정보를 입력받아서 화면에 출력해보자
 */


public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 1. 회원수를 키보드로 입력을 받아서 객체 배열에 회원 수를 입력해 보자.
		System.out.print("회원 수를 입력하세요 >>> ");
		
		// MemberDTO[0],[1],[2]..... 객채의 배열이 생성되고 주소값이 생성된다.
		MemberDTO[] members = new MemberDTO[sc.nextInt()];
		

		//2. 반복문을 이용하여 회원 수 만큼 회원 정보를 키보드로 입력을 받자.
		for(int i=0; i<members.length; i++) {
			
			members[i] = new MemberDTO();
			
			System.out.println((i+1) + "번째 회원의 아이디, 이름, 나이, 연락처, 주소를 입력하세요.");
			
			
			// private 접근지정자 형식으로 set메서드와 get메서드를 사용
			// set메서드를 사용해서 키보드로 인자를 넘겨준다.
			members[i].setId(sc.next());
			members[i].setName(sc.next());
			members[i].setAge(sc.nextInt());
			members[i].setPhone(sc.next());
			members[i].setAddress(sc.next());
			
			// 매개변수생성자를 통해서 인자전달
			// members[i] new MemberDTO(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next())
		}
		
		// 3. 반복문을 이용하여 객체 배열에 저장된 데이터들을 화면에 출력해 보자.
			System.out.println("아이디\t이름\t나 이\t연락처\t주 소");
			for(int i=0; i<members.length; i++) {
				System.out.println(members[i].getId() + "\t" + members[i].getName() + "\t" + members[i].getAge() + "\t" + members[i].getPhone() 
						+ "\t" + members[i].getAddress());
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}
			sc.close();
		}
	}
