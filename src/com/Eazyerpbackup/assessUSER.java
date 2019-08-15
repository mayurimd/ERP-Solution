package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class assessUSER extends JFrame {

	private JPanel contentPane;
	Connection connection=null;
	private JTextField e_id;
	private JTextField name;
	private JTextField dob;
	private JTextField desig;
	private JTextField dept;
	private JTextField email;
	private JTextField mob;
	private JTextField b1;
	private JTextField b2;
	private JTextField b3;
	private JTextField b4;
	private JTextField b5;
	private JTextField b6;
	private JTextField b7;
	private JTextField b8;
	private JTextField l_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					assessUSER frame = new assessUSER();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public assessUSER() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 601, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblEmployeeAssessment = new JLabel("Employee Assessment");
		lblEmployeeAssessment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeAssessment.setBounds(10, 11, 215, 30);
		contentPane.add(lblEmployeeAssessment);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(10, 69, 65, 14);
		contentPane.add(lblEmployeeId);
		
		e_id = new JTextField();
		e_id.setEditable(false);
		e_id.setBounds(93, 66, 86, 20);
		contentPane.add(e_id);
		e_id.setColumns(10);
		e_id.setText(login.t);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 112, 65, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(93, 109, 86, 20);
		contentPane.add(name);
		
		JLabel lblDateOdBirth = new JLabel("Date of Birth");
		lblDateOdBirth.setBounds(10, 153, 65, 14);
		contentPane.add(lblDateOdBirth);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setColumns(10);
		dob.setBounds(93, 150, 86, 20);
		contentPane.add(dob);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 190, 65, 14);
		contentPane.add(lblDesignation);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setColumns(10);
		desig.setBounds(93, 187, 86, 20);
		contentPane.add(desig);
		
		JLabel lblDept = new JLabel("Dept");
		lblDept.setBounds(10, 233, 65, 14);
		contentPane.add(lblDept);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 281, 65, 14);
		contentPane.add(lblEmail);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(10, 319, 65, 14);
		contentPane.add(lblMobile);
		
		dept = new JTextField();
		dept.setEditable(false);
		dept.setColumns(10);
		dept.setBounds(93, 230, 86, 20);
		contentPane.add(dept);
		
		email = new JTextField();
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(93, 278, 117, 20);
		contentPane.add(email);
		
		mob = new JTextField();
		mob.setEditable(false);
		mob.setColumns(10);
		mob.setBounds(93, 316, 117, 20);
		contentPane.add(mob);
		
		JButton btnGoals = new JButton("Goals");
		btnGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goalsUSER  a=new goalsUSER();
				a.setVisible(true);
			}
		});
		btnGoals.setBounds(347, 437, 89, 23);
		contentPane.add(btnGoals);
		
		JList list = new JList();
		list.setBounds(494, 92, 39, -23);
		contentPane.add(list);
		
		JLabel lblOnTheJob_1 = new JLabel("On the Job Knowledge :");
		lblOnTheJob_1.setBounds(307, 69, 117, 14);
		contentPane.add(lblOnTheJob_1);
		
		JLabel lblQualityOfWork_1 = new JLabel("Quality of work :");
		lblQualityOfWork_1.setBounds(307, 112, 117, 14);
		contentPane.add(lblQualityOfWork_1);
		
		JLabel lblInitiative = new JLabel("Initiative :");
		lblInitiative.setBounds(307, 153, 117, 14);
		contentPane.add(lblInitiative);
		
		JLabel lblCreativeThinking_1 = new JLabel("Creative Thinking / Innovation :");
		lblCreativeThinking_1.setBounds(307, 190, 159, 14);
		contentPane.add(lblCreativeThinking_1);
		
		JLabel lblLeadershipAbilities_1 = new JLabel("Leadership Abilities :");
		lblLeadershipAbilities_1.setBounds(307, 233, 117, 14);
		contentPane.add(lblLeadershipAbilities_1);
		
		JLabel b6lbl = new JLabel("Reliability :");
		b6lbl.setBounds(307, 281, 55, 14);
		contentPane.add(b6lbl);
		
		JLabel lblTimeliness_1 = new JLabel("Timeliness :");
		lblTimeliness_1.setBounds(307, 319, 55, 14);
		contentPane.add(lblTimeliness_1);
		
		JLabel lblEfficiency_1 = new JLabel("Efficiency :");
		lblEfficiency_1.setBounds(307, 357, 55, 14);
		contentPane.add(lblEfficiency_1);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql = "select * from emp where e_id=?";
					PreparedStatement pst=connection.prepareStatement(sql);
					pst.setString(1,e_id.getText());
					ResultSet rs=pst.executeQuery();
					rs=pst.executeQuery();
					
					String add1 =rs.getString("name");
					name.setText(add1);
										
					String add17=rs.getString("dob");
					dob.setText(add17);
					
					String add2 =rs.getString("desig");
					desig.setText(add2);
					
					String add21 =rs.getString("dept");
					dept.setText(add2);
					
					String add3 =rs.getString("email");
					email.setText(add3);
																		
					String add7 =rs.getString("mob");
					mob.setText(add7);
					
					String add8 =rs.getString("l_date");
					l_date.setText(add8);
					
					String add9 =rs.getString("b1");
					b1.setText(add9);
					
					String add10 =rs.getString("b2");
					b2.setText(add10);
					
					String add11 =rs.getString("b3");
					b3.setText(add11);
					
					String add12 =rs.getString("b4");
					b4.setText(add12);
					
					String add13 =rs.getString("b5");
					b5.setText(add13);
					
					String add14 =rs.getString("b6");
					b6.setText(add14);
					
					String add15 =rs.getString("b7");
					b7.setText(add15);
					
					String add16 =rs.getString("b8");
					b8.setText(add16);
					
					
					rs.close();
					pst.close();
					
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(189, 65, 55, 23);
		contentPane.add(btnNewButton);
		
		b1 = new JTextField();
		b1.setEditable(false);
		b1.setBounds(456, 66, 24, 20);
		contentPane.add(b1);
		b1.setColumns(10);
		
		b2 = new JTextField();
		b2.setEditable(false);
		b2.setColumns(10);
		b2.setBounds(456, 109, 24, 20);
		contentPane.add(b2);
		
		b3 = new JTextField();
		b3.setEditable(false);
		b3.setColumns(10);
		b3.setBounds(456, 150, 24, 20);
		contentPane.add(b3);
		
		b4 = new JTextField();
		b4.setEditable(false);
		b4.setColumns(10);
		b4.setBounds(494, 187, 24, 20);
		contentPane.add(b4);
		
		b5 = new JTextField();
		b5.setEditable(false);
		b5.setColumns(10);
		b5.setBounds(456, 230, 24, 20);
		contentPane.add(b5);
		
		b6 = new JTextField();
		b6.setEditable(false);
		b6.setColumns(10);
		b6.setBounds(456, 278, 24, 20);
		contentPane.add(b6);
		
		b7 = new JTextField();
		b7.setEditable(false);
		b7.setColumns(10);
		b7.setBounds(456, 316, 24, 20);
		contentPane.add(b7);
		
		b8 = new JTextField();
		b8.setEditable(false);
		b8.setColumns(10);
		b8.setBounds(456, 354, 24, 20);
		contentPane.add(b8);
		
		JLabel lblDateOfLast = new JLabel("Date of Last Assessment");
		lblDateOfLast.setBounds(307, 23, 128, 14);
		contentPane.add(lblDateOfLast);
		
		l_date = new JTextField();
		l_date.setEditable(false);
		l_date.setColumns(10);
		l_date.setBounds(445, 20, 86, 20);
		contentPane.add(l_date);
		connection=sqliteconn.dbConnector();
	}

}
