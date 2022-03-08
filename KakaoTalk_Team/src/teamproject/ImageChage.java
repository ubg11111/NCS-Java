package teamproject;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageChage {
	   ImageChage(){}; // 기본생성자 생성
	   
	   // Manager아이콘
	   public static ImageIcon icon1 = new ImageIcon("src/images/Manager.png");
	   public static Image img1 = icon1.getImage();
	   public static Image changeImg1 = img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	   public static ImageIcon managerIcon = new ImageIcon(changeImg1);
	   
	   
	   // List아이콘
	   public static ImageIcon icon2 = new ImageIcon("src/images/List.png");
	   public static Image img2 = icon2.getImage();
	   public static Image changeImg2 = img2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	   public static ImageIcon ListIcon = new ImageIcon(changeImg2);
	   
	   // Login아이콘
	   public static ImageIcon icon3 = new ImageIcon("src/images/Login.png");
	   public static Image img3 = icon3.getImage();
	   public static Image changeImg3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	   public static ImageIcon LoginIcon = new ImageIcon(changeImg3);
	   
	   // Message아이콘
	   public static ImageIcon icon4 = new ImageIcon("src/images/Message.png");
	   public static Image img4 = icon4.getImage();
	   public static Image changeImg4 = img4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	   public static ImageIcon MessageIcon = new ImageIcon(changeImg4);
	   
	   // Market아이콘
	   public static ImageIcon icon5 = new ImageIcon("src/images/Market.png");
	   public static Image img5 = icon5.getImage();
	   public static Image changeImg5 = img5.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	   public static ImageIcon MarketIcon = new ImageIcon(changeImg5);
	   
	   // Edit아이콘
	   public static ImageIcon icon6 = new ImageIcon("src/images/Edit.png");
	   public static Image img6 = icon6.getImage();
	   public static Image changeImg6 = img6.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	   public static ImageIcon EditIcon = new ImageIcon(changeImg6);
	   
	   // Back아이콘
	   public static ImageIcon icon7 = new ImageIcon("src/images/Back.png");
	   public static Image img7 = icon7.getImage();
	   public static Image changeImg7 = img7.getScaledInstance(48, 48, Image.SCALE_SMOOTH);
	   public static ImageIcon BackIcon = new ImageIcon(changeImg7);
	   
	   
	   
	  
	   
	    	}