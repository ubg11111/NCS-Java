package project;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageChage2 {
	ImageChage2(){}; // 기본생성자 생성
	
	// 첫번째 이미지 변환
	public static ImageIcon icon1 = new ImageIcon("src/images/따봉라이언.jpg");
	public static Image img1 = icon1.getImage();
	public static Image changeImg1 = img1.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	public static ImageIcon changeIcon1 = new ImageIcon(changeImg1);
	
	// 두번째 이미지 변환
	public static ImageIcon icon2 = new ImageIcon("src/images/박수치는 라이언.png");
	public static Image img2 = icon2.getImage();
	public static Image changeImg2 = img2.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	public static ImageIcon changeIcon2 = new ImageIcon(changeImg2);
	
	// 세번째 이미지 변환
	public static ImageIcon icon3 = new ImageIcon("src/images/손흔드는 라이언.png");
	public static Image img3 = icon3.getImage();
	public static Image changeImg3 = img3.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	public static ImageIcon changeIcon3 = new ImageIcon(changeImg3);
	
	// 네번째 이미지 변환
	public static ImageIcon icon4 = new ImageIcon("src/images/하트눈라이언.png");
	public static Image img4 = icon4.getImage();
	public static Image changeImg4 = img4.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	public static ImageIcon changeIcon4 = new ImageIcon(changeImg4);
	
	
	// 다섯번째 이미지 변환
	public static ImageIcon icon5 = new ImageIcon("src/images/뒤로가기.png");
	public static Image img5 = icon5.getImage();
	public static Image changeImg5 = img5.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	public static ImageIcon changeIcon5 = new ImageIcon(changeImg5);
}
