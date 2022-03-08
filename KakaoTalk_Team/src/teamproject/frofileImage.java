package teamproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class frofileImage extends JFrame{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	String imageLoot;
	JButton jb1,jb2;
	JTextField jtf1;
	frofileImage() {
		setTitle("프로필 이미지 변경");
		
		JPanel grid1 = new JPanel(new GridLayout(2,2,50,0));
		
		JLabel iconjlb1 = new JLabel(new ImageIcon("src/images/t1.png"));
		JCheckBox jcheckbox1 = new JCheckBox("프로필1",true);
		
		JLabel iconjlb2 = new JLabel(new ImageIcon("src/images/t2.png"));
		JCheckBox jcheckbox2 = new JCheckBox("프로필2");
		
		grid1.add(iconjlb1); grid1.add(iconjlb2);
		grid1.add(jcheckbox1); grid1.add(jcheckbox2);
		
		
		JPanel grid2 = new JPanel(new GridLayout(2,2,40,0));
		
		JLabel iconjlb3 = new JLabel(new ImageIcon("src/images/t3.png"));
		JCheckBox jcheckbox3 = new JCheckBox("프로필3");
		
		JLabel iconjlb4 = new JLabel(new ImageIcon("src/images/t4.png"));
		JCheckBox jcheckbox4 = new JCheckBox("프로필4");
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(jcheckbox1); bgroup.add(jcheckbox2);
		bgroup.add(jcheckbox3); bgroup.add(jcheckbox4);
		
		grid2.add(iconjlb3); grid2.add(iconjlb4);
		grid2.add(jcheckbox3); grid2.add(jcheckbox4);
		
		JPanel container1 = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
		container1.add(grid1); container1.add(grid2);
		container1.setPreferredSize(new Dimension(300, 250));
		
		JPanel grid3 = new JPanel(new GridLayout(2,2));
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel jlb1 = new JLabel("프로필 사진 경로 : ");
		panel1.add(jlb1);
		
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		jtf1 = new JTextField(10);
		jtf1.setText("src/images/t1.png");
		panel2.add(jtf1);
		
		jb1 = new JButton("확인");
		jb2 = new JButton("취소");
		
		grid3.add(panel1); grid3.add(panel2);
		grid3.add(jb1); grid3.add(jb2);
		
		JPanel container2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0,20));
		container2.add(grid3);
		
		add(container1,BorderLayout.NORTH);
		add(container2,BorderLayout.CENTER);
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(-800, 600, 400, 400);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		jcheckbox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("src/images/t1.png");
			}
		});
		jcheckbox2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("src/images/t2.png");
			}
		});
		jcheckbox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("src/images/t3.png");
			}
		});
		jcheckbox4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jtf1.setText("src/images/t4.png");
			}
		});
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				System.out.println("연결 성공");
				updateloot();
				new FriendManagement();
				dispose();
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FriendManagement();
				dispose();
			}
		});
		
	}

	public static void main(String[] args) {
		new frofileImage();
	}
	
	void connect() {
		try {
			con = DBConnection.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void updateloot() {
		try {
			sql = "update kkakkao_photoLoot set friend_loot = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jtf1.getText());
			int res = pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "프로필 사진 업데이트 성공");
			}else {
				JOptionPane.showMessageDialog(null, "프로필 사진 업데이트 실패");
			}
			pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
