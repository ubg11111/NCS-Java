package exam;

public class ProductSearchData {
	String[][] proTable; // 2차원 배열선언

	public ProductSearchData() {
		proTable = new String[3][2]; // 0 ~ 2의 행이 생성 / 0 ~ 1의 열이 생성
		
		//[0]인덱스에는 상품명을 저장 [1] 인덱스에는 상품정보를 저장.
		proTable[0][0] = "세탁기";
		proTable[0][1] = "드럼세탁기 최신형";
		
		proTable[1][0] = "냉장고";
		proTable[1][1] = "지펠 냉장고 최신형";
		
		proTable[2][0] = "TV";
		proTable[2][1] = "HDTV 150인치 최신 모델";
		
	}; // 기본생성자 선언
	
	// 상품명을 매개변수로 넘겨 받아서 해당 상품에 대한 상품정보를 반환해 주는 메서드
	String search(String productName) {
		
		String productInfo = null; // 상품 정보가 저장될 변수
		
		for(int i=0; i<proTable.length; i++) {
			if(productName.equalsIgnoreCase(proTable[i][0])) {
				productInfo = proTable[i][1];
			}
		}
		return productInfo;
	}
}
