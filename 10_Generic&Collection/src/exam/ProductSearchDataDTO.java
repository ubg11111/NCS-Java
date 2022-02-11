package exam;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class ProductSearchDataDTO {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		String product = JOptionPane.showInputDialog("검색할 상품명을 입력하세요.");
		
		// key,value를 통해서 저장
		map.put("세탁기", "드럼세탁기 최신형");
		map.put("냉장고", "지펠 냉장고 최신형");
		map.put("TV", "HD 150인치 짱큰 TV");
		
		if(map.containsKey(product)) { // containsKey() map이 가진 키의 값이 있는 경우 체크하는 메서드
			System.out.println(map.get(product));
			JOptionPane.showMessageDialog(null, map.get(product));
		} else {
			System.out.println("해당 상품이 없습니다.");
			JOptionPane.showMessageDialog(null, "해당 상품이 없습니다.");
		}
		
		System.out.println();
		
	}
}
