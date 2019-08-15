package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class empassess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empassess frame = new empassess();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JTextField e_id;
private JTextField name;
private JTextField dob;
private JTextField desig;
private JTextField dept;
private JTextField email;
private JTextField mob;
private JTextField cur_date;
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
	 * Create the frame.
	 */
	public empassess() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 786, 546);
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
		e_id.setBounds(93, 66, 86, 20);
		contentPane.add(e_id);
		e_id.setColumns(10);
		
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
		
		JLabel lblOnTheJob = new JLabel("On the Job Knowledge");
		lblOnTheJob.setBounds(272, 69, 117, 14);
		contentPane.add(lblOnTheJob);
		
		JLabel lblQualityOfWork = new JLabel("Quality of work");
		lblQualityOfWork.setBounds(272, 112, 117, 14);
		contentPane.add(lblQualityOfWork);
		
		JLabel lblIsThe = new JLabel("Initiative");
		lblIsThe.setBounds(272, 153, 117, 14);
		contentPane.add(lblIsThe);
		
		JLabel lblCreativeThinking = new JLabel("Creative Thinking / Innovation");
		lblCreativeThinking.setBounds(272, 190, 145, 14);
		contentPane.add(lblCreativeThinking);
		
		JLabel lblLeadershipAbilities = new JLabel("Leadership Abilities");
		lblLeadershipAbilities.setBounds(272, 233, 117, 14);
		contentPane.add(lblLeadershipAbilities);
		
		JLabel lblReliability = new JLabel("Reliability");
		lblReliability.setBounds(272, 278, 117, 14);
		contentPane.add(lblReliability);
		
		JButton btnGoals = new JButton("Goals");
		btnGoals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goals a=new goals();
				a.setVisible(true);
			}
		});
		btnGoals.setBounds(347, 437, 89, 23);
		contentPane.add(btnGoals);
		
		JLabel lblCurrentDate = new JLabel("Current Date");
		lblCurrentDate.setBounds(272, 23, 65, 14);
		contentPane.add(lblCurrentDate);
		
		cur_date = new JTextField();
		cur_date.setColumns(10);
		cur_date.setBounds(347, 20, 86, 20);
		contentPane.add(cur_date);
		
		JList list = new JList();
		list.setBounds(494, 92, 39, -23);
		contentPane.add(list);
		
		JComboBox a1 = new JComboBox();
		a1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a1.setBounds(430, 66, 39, 20);
		contentPane.add(a1);
		
		JComboBox a2 = new JComboBox();
		a2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a2.setBounds(430, 109, 39, 20);
		contentPane.add(a2);
		
		JComboBox a3 = new JComboBox();
		a3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a3.setBounds(430, 150, 39, 20);
		contentPane.add(a3);
		
		JComboBox a4 = new JComboBox();
		a4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a4.setBounds(430, 187, 39, 20);
		contentPane.add(a4);
		
		JComboBox a5 = new JComboBox();
		a5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a5.setBounds(430, 230, 39, 20);
		contentPane.add(a5);
		
		JComboBox a6 = new JComboBox();
		a6.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a6.setBounds(430, 275, 39, 20);
		contentPane.add(a6);
		
		JLabel lblTimeliness = new JLabel("Timeliness");
		lblTimeliness.setBounds(272, 319, 117, 14);
		contentPane.add(lblTimeliness);
		
		JLabel lblEfficiency = new JLabel("Efficiency");
		lblEfficiency.setBounds(272, 357, 117, 14);
		contentPane.add(lblEfficiency);
		
		JComboBox a7 = new JComboBox();
		a7.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a7.setBounds(430, 316, 39, 20);
		contentPane.add(a7);
		
		JComboBox a8 = new JComboBox();
		a8.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		a8.setBounds(430, 354, 39, 20);
		contentPane.add(a8);
		
		JLabel lblOnTheJob_1 = new JLabel("On the Job Knowledge :");
		lblOnTheJob_1.setBounds(550, 69, 117, 14);
		contentPane.add(lblOnTheJob_1);
		
		JLabel lblQualityOfWork_1 = new JLabel("Quality of work :");
		lblQualityOfWork_1.setBounds(550, 112, 117, 14);
		contentPane.add(lblQualityOfWork_1);
		
		JLabel lblInitiative = new JLabel("Initiative :");
		lblInitiative.setBounds(550, 153, 117, 14);
		contentPane.add(lblInitiative);
		
		JLabel lblCreativeThinking_1 = new JLabel("Creative Thinking / Innovation :");
		lblCreativeThinking_1.setBounds(550, 190, 159, 14);
		contentPane.add(lblCreativeThinking_1);
		
		JLabel lblLeadershipAbilities_1 = new JLabel("Leadership Abilities :");
		lblLeadershipAbilities_1.setBounds(550, 233, 117, 14);
		contentPane.add(lblLeadershipAbilities_1);
		
		JLabel b6lbl = new JLabel("Reliability :");
		b6lbl.setBounds(550, 278, 55, 14);
		contentPane.add(b6lbl);
		
		JLabel lblTimeliness_1 = new JLabel("Timeliness :");
		lblTimeliness_1.setBounds(550, 319, 55, 14);
		contentPane.add(lblTimeliness_1);
		
		JLabel lblEfficiency_1 = new JLabel("Efficiency :");
		lblEfficiency_1.setBounds(550, 357, 55, 14);
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
		b1.setBounds(674, 66, 24, 20);
		contentPane.add(b1);
		b1.setColumns(10);
		
		b2 = new JTextField();
		b2.setEditable(false);
		b2.setColumns(10);
		b2.setBounds(677, 109, 24, 20);
		contentPane.add(b2);
		
		b3 = new JTextField();
		b3.setEditable(false);
		b3.setColumns(10);
		b3.setBounds(677, 150, 24, 20);
		contentPane.add(b3);
		
		b4 = new JTextField();
		b4.setEditable(false);
		b4.setColumns(10);
		b4.setBounds(719, 187, 24, 20);
		contentPane.add(b4);
		
		b5 = new JTextField();
		b5.setEditable(false);
		b5.setColumns(10);
		b5.setBounds(674, 230, 24, 20);
		contentPane.add(b5);
		
		b6 = new JTextField();
		b6.setEditable(false);
		b6.setColumns(10);
		b6.setBounds(622, 275, 24, 20);
		contentPane.add(b6);
		
		b7 = new JTextField();
		b7.setEditable(false);
		b7.setColumns(10);
		b7.setBounds(622, 316, 24, 20);
		contentPane.add(b7);
		
		b8 = new JTextField();
		b8.setEditable(false);
		b8.setColumns(10);
		b8.setBounds(622, 354, 24, 20);
		contentPane.add(b8);
		
		JLabel lblDateOfLast = new JLabel("Date of Last Assessment");
		lblDateOfLast.setBounds(550, 23, 128, 14);
		contentPane.add(lblDateOfLast);
		
		l_date = new JTextField();
		l_date.setEditable(false);
		l_date.setColumns(10);
		l_date.setBounds(674, 20, 86, 20);
		contentPane.add(l_date);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

					String val1=cur_date.getText();
					String val2=e_id.getText();
					String val3=(String) a1.getSelectedItem();
					String val4=(String) a2.getSelectedItem();
					String val5=(String) a3.getSelectedItem();
					String val6=(String) a4.getSelectedItem();
					String val7=(String) a5.getSelectedItem();
					String val8=(String) a6.getSelectedItem();
					String val9=(String) a7.getSelectedItem();
					String val10=(String) a8.getSelectedItem();
					
					
					String sql="update emp set e_id='"+val2+"',l_date='"+val1+"', b1='"+val3+"', " + "b2='"+val4+"',b3='"+val5+"',"
							+ "b4='"+val6+"',b5='"+val7+"',b6='"+val8+"', b7 = '"+val9+"', " + "b8 = '"+val10+"' where e_id='"+val2+"' "; 
					
					PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
					
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				
				
				
				
			}
		});
		btnUpdate.setBounds(456, 437, 89, 23);
		contentPane.add(btnUpdate);
		connection=sqliteconn.dbConnector();
	}
}
