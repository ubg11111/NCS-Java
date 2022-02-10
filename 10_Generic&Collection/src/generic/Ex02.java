package generic;

class StringType{
	
	String[] str;
	String var;
	
	void setStr(String[] str) {
		this.str = str;
	}
	
	
	void setVar(String var) {
		this.var = var;
	}
	
	void output() {
		// 배열객체를 순서대로 출력하기 위해 향상된 for문을 사용
		for(String k : str) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		
		System.out.println("var >>> " + var);
	}
}


class IntegerType{
	Integer[] iarr;
	Integer ivar;
	
	void setStr(Integer[] iarr) {
		this.iarr = iarr;
	}
	
	
	void setVar(Integer var) {
		this.ivar = var;
	}
	
	void output() {
		// 배열객체를 순서대로 출력하기 위해 향상된 for문을 사용
		for(Integer k : iarr) {
			System.out.println("str 배열 요소 >>> " + k);
		}
		
		System.out.println("var >>> " + ivar);
	}
}




public class Ex02 {

	public static void main(String[] args) {
		
		// StringType 클래스 객체 생성
		StringType st = new StringType();
		
		String[] str = {"홍길동", "이순신", "유관순"};
		String var = "김연아";
		
		st.setStr(str);
		
		st.setVar(var);
		
		st.output();
		
		System.out.println();
		
		// IntegerType 클래스 객체 생성
		IntegerType it = new IntegerType();
		
		Integer[] iarr = {10,20,30,40,50};
		
		Integer ivar = 500;
		
		it.setStr(iarr);
		
		it.setVar(ivar);
		
		it.output();
		
		System.out.println();
	}
}
