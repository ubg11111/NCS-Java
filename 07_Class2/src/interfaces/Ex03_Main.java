package interfaces;

interface Camera{
	
	// 사진을 찍는 기능
	void photo();
}

interface DMB{
	
	// TV를 보는 기능
	void viewTv();
}

interface MP3 {
	
	// 음악을 듣는 기능
	void playMP3();
}

class MyPhone implements Camera, DMB, MP3{

	@Override
	public void playMP3() {
		System.out.println("핸드폰으로 음악을 들어욧~");
	}

	@Override
	public void viewTv() {
		System.out.println("핸드폰으로 tv를 봅니다.");
	}

	@Override
	public void photo() {
		System.out.println("핸드폰으로 사진을 찍습니닷");
	}
	
}


public class Ex03_Main {

	public static void main(String[] args) {
		
		MyPhone myphone = new MyPhone();
		
		myphone.playMP3();
		myphone.viewTv();
		myphone.photo();
	}
}
