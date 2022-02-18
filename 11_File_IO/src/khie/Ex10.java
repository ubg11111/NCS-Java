package khie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ex10 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("C:/test/sample/sample.txt");
		
		
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("===================================================");
		bw.newLine(); // 다음 줄로 이동시키는 명령어
		
		bw.write("KH정보교육원");
		bw.newLine();
		
		bw.write("SptringFrameWork & 클라우드 융합 웹 개발자 양성과정 D강의실");
		bw.newLine();
		
		bw.write("안녕하세요 반갑습니다.");
		bw.newLine();
		
		bw.flush(); // 버퍼에 있는 데이터를 모두 출력시키는 메서드
		
		// 입출력 객체를 닫아주자.
		bw.close();
		fw.close();
	}	
}
