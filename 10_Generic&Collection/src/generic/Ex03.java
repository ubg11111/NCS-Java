package generic;


// <T> 제네릭 타입의 약자
class Generic<T> {
	
	// T(Type)위치에 원하는 자료형을 넣을 수 있다.
	T[] str;
	T var;
	
	void setStr(T[] str) {
		this.str = str;
	}
	
	void setVar(T var) {
		this.var = var;
	}
	
	void output() {
		for(T k : str) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		System.out.println("var >>> " + var);
	}
}


public class Ex03 {

	public static void main(String[] args) {
		
		// String 타입의 클래스 객체를 생성 <T(Object) 자료형이 들어감>
		Generic<String> st = new Generic<String>();
		
		String[] str = {"홍길동","이순신","유관순"};
		
		String var = "김연아";
		
		// String type의 배열이 들어가야하는데 Integer 타입의 배열이 들어가려는 경우 error
		st.setStr(str);
		
		st.setVar(var);
		
		st.output();
		
		System.out.println();
		
		// Integer 타입의 클래스 객체 생성
		Generic<Integer> in = new Generic<Integer>();
		
		Integer[] iarr = {10,20,30,40,50};
		
		Integer ivar = 500;
		
		in.setStr(iarr);
		in.setVar(ivar);
		
		in.output();
	}
}
