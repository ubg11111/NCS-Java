package singleton;

public class Ex01_Company {

	public static void main(String[] args) {
		
		// 주소가 엄청 많아진다 (메모리 과부화)
//		Company com1 = new Company();		100번지
//		Company com2 = new Company();		200번지
//		Company com3 = new Company();       300번지
//		Company com4 = new Company();
//		Company com5 = new Company();
//		Company com6 = new Company();
//		Company com7 = new Company();
//		Company com8 = new Company();
//		Company com9 = new Company();
//		Company com10 = new Company();
		
		// 싱글턴 참조변수 Copaney com1 = Company.getInstance(); 100번지 주소가 참조변수 com1을 가리키고 com2를 파생해도 static 메서드를 가리키는 주소는 같다.
		
		
		// static(스태틱,정적) 호출방법은 = 클래스이름.메서드이름; 
		// 동일한 주소에 같은 작업을 해주는 경우엔 싱글톤 방식으로 객체를 활용하는것이 좋은 방법이다.
		Company com1 = Company.getInstance();
		Company com2 = Company.getInstance();
		Company com3 = Company.getInstance();
		Company com4 = Company.getInstance();
		Company com5 = Company.getInstance();
		Company com6 = Company.getInstance();
		Company com7 = Company.getInstance();
		Company com8 = Company.getInstance();
		Company com9 = Company.getInstance();
		Company com10 = Company.getInstance();
		
		
		Company car1 = Company.getCar();
		Company car2 = Company.getCar();
		
		
		System.out.println(com1.getVolume());
		Company.getInstance().setVolume(100);
		System.out.println(com1.getVolume());
		System.out.println(com2.getVolume());
		System.out.println(com3.getVolume());
		
		System.out.println();
		
		// 컴퍼니라는 클래스에서 set을 저장하거나 get을 가져와도 모든 참조변수의 주소값은 같기에 똑같이 적용된다.
		Company.getInstance().setVolume(50);
		System.out.println(car1.getVolume());
		System.out.println(car2.getVolume());
		
		System.out.println();
		
		// 메서드를 몇개를 만들던 주소값은 같다. 메서드 이름이 틀려도 마찬자기 같은 클래스를 활용한다.
		System.out.println("car1 >>> " + car1);
		System.out.println("car2 >>> " + car2);
		
		System.out.println();
		
		System.out.println("com1 >>> " + com1);
		System.out.println("com2 >>> " + com2);
		System.out.println("com3 >>> " + com3);
		System.out.println("com4 >>> " + com4);
		System.out.println("com5 >>> " + com5);
		System.out.println("com6 >>> " + com6);
		System.out.println("com7 >>> " + com7);
		System.out.println("com8 >>> " + com8);
		System.out.println("com9 >>> " + com9);
		System.out.println("com10 >>> " + com10);
	}
}
