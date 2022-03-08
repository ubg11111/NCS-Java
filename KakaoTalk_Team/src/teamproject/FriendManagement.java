package teamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FriendManagement extends JFrame{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
	DefaultTableModel model;
	JTextField jtf1,jtf2,jtf3,jtf4; 
	JComboBox<String> jcb1,jcb2;
	JTable table;
	String imageloot;
	
	public FriendManagement() {
		setTitle("친구관리");
		
		//상단 컴포넌트 start`
		JPanel container1 = new JPanel(new GridLayout(1,2)); //상단컨테이너 1
		container1.setBackground(Color.white);
		JPanel container2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); //상단컨테이너 2
		JPanel container3 = new JPanel(new FlowLayout(FlowLayout.CENTER)); //상단컨테이너 3
		JPanel congruop1 = new JPanel(new BorderLayout()); 
		
		//상단 notrh 컴포넌트 start
		JPanel iconcont1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		iconcont1.setBackground(Color.white);
		JPanel iconcont2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconcont2.setBackground(Color.white);
		JPanel iconcont3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		iconcont3.setBackground(Color.white);
		JButton iconjb1 = new JButton(ImageChage.BackIcon);
		iconjb1.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb1.setContentAreaFilled(false); 
		
		//프로필 이미지 선택
		connect();
		imageloot = findLoot();
		JButton iconjb2 = new JButton(new ImageIcon(imageloot));
		iconjb2.setBorder(BorderFactory.createEmptyBorder()); 
		iconjb2.setContentAreaFilled(false); 
		JButton iconjb3 = new JButton(new ImageIcon("src/images/f.png")); //위치조정용 아이콘 버튼 nonedisplay

		iconcont1.add(iconjb1); iconcont2.add(iconjb2); iconcont3.add(iconjb3);
		iconcont3.setVisible(false);
		
		container1.add(iconcont1); container1.add(iconcont2); container1.add(iconcont3);
		//상단 notrh 컴포넌트 end
		
		//상단 ceter 컴포넌트 start
		JLabel jlb1 = new JLabel("친구 아이디 : ");
		jtf1 = new JTextField(9);
		
		JLabel jlb2 = new JLabel("친구 이름 : ");
		jtf2 = new JTextField(8);
		
		JLabel jlb3 = new JLabel("성별 : ");
		jcb1 = new JComboBox<String>();
		jcb1.setBackground(Color.white);
		jcb1.addItem("선택"); jcb1.addItem("남"); jcb1.addItem("여");
		
		container2.add(jlb1); container2.add(jtf1);
		container2.add(jlb2); container2.add(jtf2);
		container2.add(jlb3); container2.add(jcb1);
		container2.setBackground(Color.white);
		//상단 ceter 컴포넌트 end
		
		//상단 south 컴포넌트 start
		JLabel jlb4 = new JLabel("친구 전화번호 : ");
		jtf3 = new JTextField(10);
		
		JLabel jlb5 = new JLabel("친구 이메일 : ");
		jtf4 = new JTextField(10);
		
		JLabel jlb6 = new JLabel("@");
		String[] mail = {"선택","gmail.com","hanmail.net","hotmail.com","korea.com","nate.com","naver.com","yahoo.com"};
		jcb2 = new JComboBox<String>(mail);
		jcb2.setBackground(Color.white);
		jcb2.setSelectedItem("선택");
		
		container3.add(jlb4); container3.add(jtf3);
		container3.add(jlb5); container3.add(jtf4);
		container3.add(jlb6); container3.add(jcb2);
		container3.setBackground(Color.white);
		//상단 south 컴포넌트 end
		
		congruop1.add(container1,BorderLayout.NORTH); 
		congruop1.add(container2,BorderLayout.CENTER); 
		congruop1.add(container3,BorderLayout.SOUTH);
		
		//상단 컴포넌트 end
		
		
		//하단 컴포넌트 start
		JPanel container4 = new JPanel(); //하단컨테이너 1
		JPanel congruop2 = new JPanel(new BorderLayout());
		
		//하단 center 컴포넌트 start
		Object[] header = {"아이디","이름","성별","전화번호","E-Mail","등록일"};
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		table.getTableHeader().setBackground(Color.white);
		JScrollPane jsp = new JScrollPane(
				table,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getViewport().setBackground(Color.white);
		//하단 center 컴포넌트 end
		
		//하단 south 컴포넌트 start
		JButton jbt1 = new JButton("친구 조회");
		JButton jbt2 = new JButton("친구 등록");
		JButton jbt3 = new JButton("친구 수정");
		JButton jbt4 = new JButton("친구 삭제");
		
		jbt1.setBackground(new Color(204, 102, 0));
		jbt2.setBackground(new Color(204, 102, 0));
		jbt3.setBackground(new Color(204, 102, 0));
		jbt4.setBackground(new Color(204, 102, 0));

		
		container4.add(jbt1); container4.add(jbt2);
		container4.add(jbt3); container4.add(jbt4);
		container4.setBackground(Color.white);
		//하단 south 컴포넌트 end
		
		congruop2.add(jsp,BorderLayout.NORTH);
		congruop2.add(container4,BorderLayout.CENTER);
		congruop2.setBackground(Color.white);
		
		add(congruop1,BorderLayout.NORTH);		
		add(congruop2,BorderLayout.CENTER);		
		
		jsp.setPreferredSize(new Dimension(700, 150));
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(-800, 600, 700, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				String F_id = table.getValueAt(row, 0).toString();
				String F_name = table.getValueAt(row, 1).toString();
				jtf1.setText(F_id);
				jtf2.setText(F_name);
				try {
					String F_gender = table.getValueAt(row, 2).toString();
					jcb1.setSelectedItem(F_gender);
				}catch(NullPointerException npe) {
					jcb1.setSelectedItem("선택");
	
				}
				try {
					int Delimiter = (table.getValueAt(row, 4).toString()).indexOf('@', 0);
					String F_enamilFront = (table.getValueAt(row, 4).toString()).substring(0, Delimiter);
					String F_enamilEnd = (table.getValueAt(row, 4).toString()).substring(Delimiter+1,
							(table.getValueAt(row, 4).toString()).length());
					jtf4.setText(F_enamilFront);
					jcb2.setSelectedItem(F_enamilEnd);
					
				}catch(NullPointerException npe) {
					jtf4.setText("");
					jcb2.setSelectedItem("선택");
				}
				try {
					String F_phone = table.getValueAt(row, 3).toString();
					jtf3.setText(F_phone);
				}catch(NullPointerException npe) {
					jtf3.setText("");
				}
			}
		});
		
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				model.setRowCount(0);
				select();
			}
		});
		
		jbt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				insert();
				jtf1.setText(""); jtf2.setText(""); jcb1.setSelectedItem("선택");
				jtf3.setText(""); jtf4.setText(""); jcb2.setSelectedItem("선택");
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
			}
		});
		
		jbt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				update();
				jtf1.setText(""); jtf2.setText(""); jcb1.setSelectedItem("선택");
				jtf3.setText(""); jtf4.setText(""); jcb2.setSelectedItem("선택");
				jtf1.requestFocus();
				model.setRowCount(0);
				select();
			}
		});
		
		jbt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				int result = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showConfirmDialog(null, "취소를 클릭하셨습니다.");
				}else if(result ==JOptionPane.YES_OPTION) {
					delete();
					jtf1.setText(""); jtf2.setText(""); jcb1.setSelectedItem("선택");
					jtf3.setText(""); jtf4.setText(""); jcb2.setSelectedItem("선택");
					jtf1.requestFocus();
				}
				
			}
		});
		
		iconjb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Main();
				dispose();
			}
		});
		
		iconjb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new frofileImage();
				dispose();
			}
		});
		
		
		
	}

	public static void main(String[] args) {
		new FriendManagement();
	}
	
	String findLoot() {
		String loot="";
		try {
			sql = "select *from kkakkao_photoLoot";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				loot = rs.getString("friend_Loot");
			}
			rs.close(); pstmt.close(); //con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loot;
	}
	void connect() {
		try {
			con = DBConnection.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void select() {
		try {
			sql = "select *from kkakkao_friends order by F_name asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String F_id = rs.getString("F_id");
				String F_name = rs.getString("F_name");
				String F_gender = rs.getString("F_gender");
				String F_phone = rs.getString("F_phone");
				String F_email = rs.getString("F_email");
				String F_Edate = rs.getString("F_Edate");
				Object[] data = {F_id,F_name,F_gender,F_phone,F_email,F_Edate};
				model.addRow(data);
			}
			rs.close(); pstmt.close(); con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void insert() {
		try {
			sql = "insert into kkakkao_friends values(?,?,?,?,?,sysdate,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf2.getText());
			
			String gender = jcb1.getSelectedItem().toString();
			if (gender=="선택") {
				pstmt.setString(3, "");
			}else {
				pstmt.setString(3, gender);
			}
			
			pstmt.setString(4, jtf3.getText());
			String F_enamilFront = jtf4.getText();
			String F_enamilEnd = jcb2.getSelectedItem().toString();
			if(F_enamilEnd=="선택") {
				pstmt.setString(5, "");
			}else {
				pstmt.setString(5, F_enamilFront+"@"+F_enamilEnd);
			}
			
			pstmt.setString(6, imageloot);
			
			int res = pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "친구등록 완료");
			}else {
				JOptionPane.showMessageDialog(null, "친구등록 실패");
			}
			pstmt.close(); 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	void update() {
		
		try {
			sql = "update kkakkao_friends set F_id=?,F_name=?,F_gender=?,F_phone=?,F_email=?,F_photo=? where F_id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, jtf1.getText());
			pstmt.setString(2, jtf2.getText());
			String gender = jcb1.getSelectedItem().toString();
			if (gender=="선택") {
				pstmt.setString(3, "");
			}else {
				pstmt.setString(3, gender);
			}
			
			pstmt.setString(4, jtf3.getText());
			
			String F_enamilFront = jtf4.getText();
			String F_enamilEnd = jcb2.getSelectedItem().toString();
			if(F_enamilEnd=="선택") {
				pstmt.setString(5, "");
			}else {
				pstmt.setString(5, F_enamilFront+"@"+F_enamilEnd);
			}
			pstmt.setString(6, imageloot);
			pstmt.setString(7, jtf1.getText());
			int res = pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "친구수정 완료");
			}else {
				JOptionPane.showMessageDialog(null, "친구수정 실패");
			}
			
			pstmt.close(); 
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	void delete() {
		try {
			sql = "delete from kkakkao_friends where F_id = ?";
			pstmt = con.prepareStatement(sql);
			int row = table.getSelectedRow();
			String F_id = table.getValueAt(row, 0).toString();
			pstmt.setString(1, F_id);
			int res = pstmt.executeUpdate();
			if(res>0) {
				JOptionPane.showMessageDialog(null, "삭제 성공");
			}else {
				JOptionPane.showMessageDialog(null, "삭제 실패");
			}
			model.removeRow(row);
			pstmt.close(); con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
