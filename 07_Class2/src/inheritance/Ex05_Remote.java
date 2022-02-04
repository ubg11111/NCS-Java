package inheritance;

import java.util.Scanner;

public class Ex05_Remote {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		TV tv = new TV();
		Radio radio = new Radio();
		Computer computer = new Computer();
		
		
		while(true) {
			System.out.print("1. TV / 2.Radio / 3.Computer / 4. 종료 : ");
			
			
			int menu = sc.nextInt();
			
			if(menu == 4) {
				break;
			}
			
			System.out.print("1. 볼륨을 Up / 2. 볼륨을 Down : ");
			int volume = sc.nextInt();
		
			switch(menu) {
				case 1 : // Tv를 선택
					if(volume == 1) { //volume을 Up을 선택한 경우
						tv.volumeUp();
					} else { // volume을 Down을 선택한 경우
						tv.volumeDown();
					}
					break;
				case 2 : // Radio를 선택
					if(volume == 1) { //volume을 Up을 선택한 경우
						radio.volumeUp();
					} else { // volume을 Down을 선택한 경우
						radio.volumeDown();
					}
					break;
				case 3 : // computer를 선택
					if(volume == 1) { //volume을 Up을 선택한 경우
						computer.volumeUp();
					} else { // volume을 Down을 선택한 경우
						computer.volumeDown();
					}
					break;
			} // switch ~ case의 end문
	
			System.out.println();
			
			System.out.println("::::::::::::::::::::::::::::::::::::::");
			
			System.out.println("TV Volume : " + tv.getVol() + " / Radio Volume : " + radio.getVol() + 
					"/  Computer Volume : " + computer.getVol());
		}	// while 문 end
	
		System.out.println();
		
		System.out.println("수고 많이 하셨습니다. ~~~~~~~~~~");
		
		sc.close();
	}
}
