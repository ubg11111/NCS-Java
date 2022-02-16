package khie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex05 {

	public static void main(String[] args) {
		Reader reader = null;
		
		int readByte;
		
		try {
			reader = new FileReader("C:/Users/ubg11/git/NCS-Java/11_File_IO/src/khie/Ex04.java");
			while(true) {
					readByte = reader.read();
					
					if(readByte == -1) {
						break;
					}
					System.out.print((char)readByte);
			}
			
					// 파일 입출력과 관련된 객체는 닫아주는 것이 좋음.
					reader.close();
					} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
