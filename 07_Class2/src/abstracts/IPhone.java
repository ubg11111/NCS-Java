package abstracts;

public class IPhone extends SmartPhone{

	
	@Override
	void spec() {
		company = "Apple";
		name = "IPhone 13 Pro";
		color = "화이트";
		size = "15cm";
		weight = "250g";
		price = "150만원";
		
		System.out.println(company + " / "+name+ " / " + color + " / " + size + " / " + weight + " / " + price);
	}
}
