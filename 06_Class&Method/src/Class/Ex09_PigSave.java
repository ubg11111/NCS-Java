package Class;

public class Ex09_PigSave {

	public static void main(String[] args) {
		
		// 돼지 저금통 객체 생성.
		PigSave save = new PigSave(0);
		
		save.dposit(3000); // 입금메서드 호출
		save.dposit(10000);
		save.dposit(10000);
		save.withdraw(15000); // 출금 메서드 호출
		save.withdraw(10000); // 출금 메서드 호출
		
//		save.balance = 100000; // 이런식으로 접근하면 안됨. 
	}
}
