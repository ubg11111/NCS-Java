package teamproject;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

public class Main extends JFrame{
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	String sql;
	
	public Main() {
		setTitle("깨깨오톡 메인화면");
		
		JPanel conGroup1 = new JPanel(new BorderLayout());
		JPanel conGroup2 = new JPanel(new BorderLayout());
		
		// 상단-North 컨테이너(north,center) 그룹 start
		JPanel container1 = new JPanel(new GridLayout(1,2));
		JPanel container2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		
		
		// 상단-North 컨테이너 그룹 (north) Friends title및 친구관리 이미지 버튼 start
		JPanel Panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT,30,30));
		JLabel jlb1 = new JLabel("Friends");
		jlb1.setFont(new Font("한컴 윤고딕", Font.BOLD, 40));
		Panel1.add(jlb1);
		Panel1.setBackground(Color.WHITE);
		JPanel Panel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT,50,40));
		//button 컴포넌트 생성시  ImageIcon객체를 생성자에 포함시킨다.
		JButton iconjb1 = new JButton(ImageChage.managerIcon); //size 50 50 정도의 사이즈가 적당하다.
		iconjb1.setBorder(BorderFactory.createEmptyBorder()); //iconButton1의 윤곽선제거
		iconjb1.setContentAreaFilled(false); //iconButton1의 주변필드 제거
		Panel2.add(iconjb1);
		Panel2.setBackground(Color.WHITE);
		container1.add(Panel1); container1.add(Panel2);
		// 상단-North 컨테이너 그룹 (north) Friends title및 친구관리 이미지 버튼 end
		
		
		// 상단-North 컨테이너 그룹 (center) Friends' Names Display > 라벨 start
		JLabel iconjl1 = new JLabel(ImageChage.ListIcon);
		JLabel jlb2 = new JLabel("Friends' Names Display >");
		jlb2.setFont(new Font("한컴 윤고딕", Font.BOLD, 20));
		jlb2.setForeground(new Color(192, 192, 192));
		container2.add(iconjl1); container2.add(jlb2);
		container2.setBackground(Color.WHITE);
		container2.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		// 상단-North 컨테이너 그룹 (center) Friends' Names Display > 라벨 end
		
		
		conGroup1.add(container1,BorderLayout.NORTH);
		conGroup1.add(container2,BorderLayout.CENTER);
		// 상단-North 컨테이너(north,center,south) 그룹 end
		
		// 중앙-center 컨테이너(north,center,south,) 그룹 start
		JPanel container3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel container4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel container5 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
		
		// 중앙-North 컨테이너 그룹 (north) user icon, username start
//		JPanel mpanel1 = new JPanel(new GridLayout(1,2));
		connect();
		JPanel Panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		String user_photo = finduser_photo();
		JLabel iconjl2 = new JLabel(new ImageIcon("src/images/user.PNG"));
		iconjl2.setFont(new Font("한컴 윤고딕", Font.BOLD, 30));
		Panel3.add(iconjl2);
		Panel3.setBackground(Color.WHITE);
		
		JPanel Panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		String user_name = finduser_name();
		JLabel jlb3 = new JLabel(user_name);
		jlb3.setFont(new Font("한컴 윤고딕", Font.BOLD, 30));
		Panel4.add(jlb3);
		Panel4.setBackground(Color.WHITE);
		
//		mpanel1.add(Panel3); mpanel1.add(Panel4);
//		container3.add(mpanel1);
		container3.add(Panel3); container3.add(Panel4);
		container3.setBackground(Color.WHITE);
		// 중앙-North 컨테이너 그룹 (north) user icon, username end
				
		// 중앙-center 컨테이너(center) friendicon griendname start
		Map<String, JPanel> friendsMap = new HashMap<String, JPanel>();
		int i = 1;
		int size=0;
		try {
			connect();
			String sql = "select F_name,F_photo from kkakkao_friends order by F_name";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String F_name = rs.getString("F_name");
				String F_photo = rs.getString("F_photo");
				JPanel mpanel2 = new JPanel();
				JPanel Panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
				JLabel iconjl3 = new JLabel(new ImageIcon(F_photo),JLabel.LEFT);
				iconjl3.setFont(new Font("한컴 윤고딕", Font.BOLD, 30));
				Panel5.add(iconjl3); Panel5.setBackground(Color.WHITE);
				
				JPanel Panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,10));
				JLabel jlb4 = new JLabel(F_name+"               ",JLabel.LEFT);
				jlb4.setFont(new Font("한컴 윤고딕", Font.BOLD, 20));
				Panel6.add(jlb4); Panel6.setBackground(Color.WHITE);
				mpanel2.add(Panel5); mpanel2.add(Panel6);
				mpanel2.setBackground(Color.WHITE);
				
				friendsMap.put(F_name, mpanel2);
				container4.add(friendsMap.get(F_name));
//				Dimension dim = friends.getPreferredSize();
//				System.out.println(dim);
				size +=75;
				i++;
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		container4.setBackground(Color.WHITE);
		container4.setPreferredSize(new Dimension(100, size));
		
		JScrollPane jsp = new JScrollPane(
				container4,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.LIGHT_GRAY));
		// 중앙-center 컨테이너(center) friendicon griendname end
		
		
		// 중앙-center 컨테이너(south) iconbuttongroup start
		JPanel mpanel3 = new JPanel(new GridLayout(1,4,80,20));
		JButton iconjb2 = new JButton(ImageChage.LoginIcon); 
		iconjb2.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb2.setContentAreaFilled(false); 
		JButton iconjb3 = new JButton(ImageChage.MessageIcon); 
		iconjb3.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb3.setContentAreaFilled(false); 
		JButton iconjb4 = new JButton(ImageChage.MarketIcon); 
		iconjb4.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb4.setContentAreaFilled(false); 
		JButton iconjb5 = new JButton(ImageChage.EditIcon); 
		iconjb5.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb5.setContentAreaFilled(false); 
		
		mpanel3.add(iconjb2); mpanel3.add(iconjb3);
		mpanel3.add(iconjb4); mpanel3.add(iconjb5);
		container5.add(mpanel3);
		mpanel3.setBackground(Color.WHITE);
		container5.setBackground(Color.WHITE);
		mpanel3.setBackground(new Color(204, 102, 0));
		container5.setBackground(new Color(204, 102, 0));
		// 중앙-center 컨테이너(south) iconbuttongroup end
		
		
		conGroup2.add(container3,BorderLayout.NORTH);
		conGroup2.add(jsp,BorderLayout.CENTER);
		conGroup2.add(container5,BorderLayout.SOUTH);
		// 중앙-center 컨테이너(north,center,south,) 그룹 end
		
		add(conGroup1,BorderLayout.NORTH);
		add(conGroup2,BorderLayout.CENTER);
		
		
//		getContentPane().setBackground(Color.WHITE);
		setBounds(-800, 600, 500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		iconjb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "친구관리 페이지로 이동합니다.");
				new FriendManagement();
				dispose();
			}
		});

		iconjb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("로그인화면으로 이동");
				new Login();
				dispose();
			}
		});

		iconjb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("채팅창화면으로 이동");
				new Chat();
				dispose();
			}
		});
		
		iconjb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("이모티콘상점으로 이동");
				new Shop();
				dispose();
			}
		});
		
		iconjb5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("회원정보수정화면으로 이동");
				new kkae();
				dispose();
			}
		});
	}
	public static void main(String[] args) {
		new Main();
	}
	
	void connect() {
		try {
			con = DBConnection.getConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String finduser_name() {
		String user_name = null;
		
		try {
			
			sql = "select user_name from kkakkao_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user_name = rs.getString("user_name");
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_name;
	}
	String finduser_photo() {
		String user_photo = null;
		
		try {
			
			sql = "select user_loot from kkakkao_photoLoot";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				user_photo = rs.getString("user_loot");
			}
			rs.close(); pstmt.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_photo;		
	}

}
