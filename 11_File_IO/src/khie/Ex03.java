package khie;

import java.io.IOException;

public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("한 줄을 입력하세요....");
		
		int num;
		
		while(true) {
			try {
				num = System.in.read();
				
				if(num == '\n')
					break;
				System.out.print((char)num);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
