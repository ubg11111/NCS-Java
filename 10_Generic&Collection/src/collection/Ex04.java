package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.MemberDTO;


// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 

public class Ex04 {

	public static void main(String[] args) {
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("회원 수를 입력하세요. : ");
		
		int memberCount = sc.nextInt();
		
		// 1. 키보드로 회원의 수만큼 회원 정보를 입력받아서
		// list(ArrayList)에 저장해 보자.
		
		for(int i=0; i<memberCount; i++) {
			
			System.out.println((i+1) + " 번째 회원의" + "아이디,이름,나이,연락처,주소를 입력하세요....");
			
			// dto 참조변수가 객체를 생성할 때 마다 리스트의 객체주소에 추가된다. 0번째 1번째 2번째 .... 
			MemberDTO dto = new MemberDTO(sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next());
		
			// 주소값 추가 새로 생성 0x100 ....
			list.add(dto);
		}
		
		// 리스트 0번째에 MemberDTO를 가져옴
//		System.out.println("list[0] >>> " + list.get(0));
		
		System.out.println("아이디\t이름\t나이\t연락처\t주소");
		
		// 2. list에 들어 있는 데이터들을 화면에 출력해 보자.
		
		for(int i=0; i<list.size(); i++) {
			MemberDTO dto = list.get(i); // dto 참조변수에 list 참조변수를 넣는다
			
			System.out.println(dto.getId() + "\t" + dto.getName() + "\t" + dto.getAge() + "\t" + dto.getPhone() + "\t" + dto.getAddress());
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//System.out.println("dto >>> " + dto);
		}
		sc.close();
	}
}
