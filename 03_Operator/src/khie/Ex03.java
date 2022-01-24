package khie;

/*
 * 3. 논리연산자
 * - 논리곱 (&&) : 주어진 조건이 모두 참일 때 결과가 true. 나머지는 false
 
 * - 논리합(||) : 주어진 조건이 하나라도 참일 때 결과가 true. 주어진 조건이 모두 false인 경우 false
 
 * - 부 정(!) : true -> false가 되고, false -> true가 됨 
   - 논리 연산자는 우선적으로 관계연산자를 실행한 후에 그 결과값을 가지고 논리연산을 수행함.
   
 */


public class Ex03 {

	public static void main(String[] args) {
		
		int su1 = 10, su2 = 7;
		
		// 논리곱인 경우 : true && true ==> true 
		
		boolean test = (su1 >= su2) && (su1 >= 5);
		
		System.out.println("test의 결과값은 = " + test); // 10 > 7 크고 , 10 > 5보다 크기에 둘다 true 
		
		// true && false ==> false
		boolean test2 = (su1 >= su2) && (su2 <= 5);
		
		System.out.println("test2의 결과값은 = " + test2);
	
		// false && true ==> false 
		boolean test3 = (su1 <= su2) && (su2 >= 5);
		System.out.println("test3의 결과값은 = " + test3);
		
		// false && false == false
		boolean test4 = (su1 <= su2) && (su2 <= 5);
		System.out.println("test4의 결과값은 = " + test4);
		System.out.println();
		
		// 논리곱인 경우 : true || true ==> true 
		
		boolean test5 = (su1 >= su2) || (su1 >= 5);
		
		System.out.println("test5의 결과값은 = " + test5); // 10 > 7 크고 , 10 > 5보다 크기에 둘다 true 
		
		// true && false ==> false
		boolean test6 = (su1 >= su2) || (su2 <= 5);
		
		System.out.println("test6의 결과값은 = " + test6);
	
		// false && true ==> false 
		boolean test7 = (su1 <= su2) || (su2 >= 5);
		System.out.println("test7의 결과값은 = " + test7);
		
		// false && false == false
		boolean test8 = (su1 <= su2) || (su2 <= 5);
		System.out.println("test8의 결과값은 = " + test8);
	}
}
