package overriding;

public class Ex01_Animal {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		Duck duck = new Duck();
		Mouse mouse = new Mouse();
		
		dog.sound();
		cat.sound();
		duck.sound();
		mouse.animal.sound();
	}
}
