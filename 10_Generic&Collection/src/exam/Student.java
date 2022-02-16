package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.StudentDTO;

public class Student {

	public static void main(String[] args) {
		
		List<StudentDTO> list1 = new ArrayList<StudentDTO>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 수를 입력하세요");
		
		int studentCount = sc.nextInt();
		
		for(int i=0; i<studentCount; i++) {
			System.out.println((i+1) + " 번째 학생의 학번,이름,학과,전화번호,주소를 입력하세요..");
			
			StudentDTO dto = new StudentDTO(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next());
				
			list1.add(dto);
		}
		
		System.out.println("학번\t이름\t학과\t연락처\t\t주소");
	
		for(int i=0; i<list1.size(); i++) {
			
			StudentDTO dto = list1.get(i);
			
			System.out.println(dto.getHuckbun() + "\t" + dto.getName() + "\t" + dto.getMajor() + "\t" + dto.getPhone() + "\t" + dto.getAddres());
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		}
		sc.close();
	}
}
