package Exam;

import java.util.Scanner;

public class Exam_02_Rectangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Rectangle rec = new Rectangle();
	
		System.out.println("사각형의 가로 세로를 입력하세요.");
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		
		rec.rowRec = row*col;
		rec.colRec = (row+col) * 2;
		rec.display();
		
		sc.close();
	}
}


class Rectangle {
	
	int rowRec;
	int colRec;
	
	
	void display() {
		
		System.out.println("=======================");
		System.out.println("사각형의 넓이 : " + rowRec);
		System.out.println("사각형의 둘레 : " + colRec);
	}
}