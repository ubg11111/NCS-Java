package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.StudentDTO;

/*
 * [문제] Ex04 클래스처럼 키보드로 학생 수를 입력을 받고
 * 		 입력 받은 학생 수 만큼의 정보를 키보드로 입력을 받아서
 * 		 ArrayList에 정보를 저장 후 화면에 출력해 보세요.
 * 		 (단, 학생의 정보는 학번, 이름, 학과, 연락처, 주소)
 */


public class Ex05 {

	public static void main(String[] args) {
		
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생의 수를 입력하세요. >>> ");
		
		int studentCount = sc.nextInt();
		
		for(int i=0; i<studentCount; i++) {
			
			System.out.println((i+1) + "번째 학생의" + "학번,이름,학과,연락처,주소를 입력하세요.");
			
			StudentDTO st = new StudentDTO(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.next());
			
			
			list.add(st); // for반복문에서 st 객체생성만큼 list.add 된다. 즉 list.size()가 정해진다
			
			System.out.println("st ["+i+"] >>> " + st );
			System.out.println();
		}
		
		System.out.println("학번\t이름\t학과\t연락처\t\t주소");
		
		for(int i=0; i<list.size(); i++) {
			StudentDTO st = list.get(i);
			System.out.println(st.getHuckbun() +"\t" + st.getName() + "\t" + st.getMajor() + "\t" + st.getPhone() + "\t" + st.getAddres());
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		}
		
		sc.close();
	}
}
