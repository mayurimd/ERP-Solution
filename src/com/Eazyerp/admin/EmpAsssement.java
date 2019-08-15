package com.Eazyerp.admin;


import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.sqliteconn;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmpAsssement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					EmpAsssement frame = new EmpAsssement();
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
private JTextField last_assess1;
private JTextField last_assess2;
private JTextField last_assess3;
private JTextField last_assess4;
private JTextField last_assess5;
private JTextField last_assess6;
private JTextField last_assess7;
private JTextField last_assess8;
private JTextField l_date;

	/**
	 * Create the frame.
	 */
	public EmpAsssement() {
		final Logger logger = Logger.getLogger(EmpAsssement.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 786, 546);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblEmployeeAssessment = new JLabel("Employee Assessment");
		lblEmployeeAssessment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeAssessment.setBounds(10, 11, 215, 30);
		contentPane.add(lblEmployeeAssessment);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(10, 69, 86, 14);
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
		lblDateOdBirth.setBounds(10, 153, 86, 14);
		contentPane.add(lblDateOdBirth);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setColumns(10);
		dob.setBounds(93, 150, 86, 20);
		contentPane.add(dob);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 190, 86, 14);
		contentPane.add(lblDesignation);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setColumns(10);
		desig.setBounds(93, 187, 86, 20);
		contentPane.add(desig);
		
		JLabel lblDept = new JLabel("Department");
		lblDept.setBounds(10, 233, 86, 14);
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
		lblOnTheJob.setBounds(272, 69, 145, 14);
		contentPane.add(lblOnTheJob);
		
		JLabel lblQualityOfWork = new JLabel("Quality of work");
		lblQualityOfWork.setBounds(272, 112, 117, 14);
		contentPane.add(lblQualityOfWork);
		
		JLabel lblIsThe = new JLabel("Initiative");
		lblIsThe.setBounds(272, 153, 117, 14);
		contentPane.add(lblIsThe);
		
		JLabel lblCreativeThinking = new JLabel("Creative Thinking / Innovation");
		lblCreativeThinking.setBounds(270, 190, 181, 14);
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
				EmpGoals a=new EmpGoals();
				a.setVisible(true);
			}
		});
		btnGoals.setBounds(347, 437, 89, 23);
		contentPane.add(btnGoals);
		
		JLabel lblCurrentDate = new JLabel("Current Date");
		lblCurrentDate.setBounds(272, 23, 83, 14);
		contentPane.add(lblCurrentDate);
		
		cur_date = new JTextField();
		cur_date.setColumns(10);
		cur_date.setBounds(347, 20, 86, 20);
		contentPane.add(cur_date);
		
		JList list = new JList();
		list.setBounds(494, 92, 39, -23);
		contentPane.add(list);
		
		JComboBox assess1 = new JComboBox();
		assess1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess1.setBounds(443, 66, 39, 20);
		contentPane.add(assess1);
		
		JComboBox assess2 = new JComboBox();
		assess2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess2.setBounds(443, 109, 39, 20);
		contentPane.add(assess2);
		
		JComboBox assess3 = new JComboBox();
		assess3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess3.setBounds(443, 150, 39, 20);
		contentPane.add(assess3);
		
		JComboBox assess4 = new JComboBox();
		assess4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess4.setBounds(443, 187, 39, 20);
		contentPane.add(assess4);
		
		JComboBox assess5 = new JComboBox();
		assess5.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess5.setBounds(443, 230, 39, 20);
		contentPane.add(assess5);
		
		JComboBox assess6 = new JComboBox();
		assess6.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess6.setBounds(443, 278, 39, 20);
		contentPane.add(assess6);
		
		JLabel lblTimeliness = new JLabel("Timeliness");
		lblTimeliness.setBounds(272, 319, 117, 14);
		contentPane.add(lblTimeliness);
		
		JLabel lblEfficiency = new JLabel("Efficiency");
		lblEfficiency.setBounds(272, 357, 117, 14);
		contentPane.add(lblEfficiency);
		
		JComboBox assess7 = new JComboBox();
		assess7.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess7.setBounds(443, 316, 39, 20);
		contentPane.add(assess7);
		
		JComboBox assess8 = new JComboBox();
		assess8.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		assess8.setBounds(443, 354, 39, 20);
		contentPane.add(assess8);
		
		JLabel lblOnTheJob_1 = new JLabel("On the Job Knowledge :");
		lblOnTheJob_1.setBounds(550, 69, 139, 14);
		contentPane.add(lblOnTheJob_1);
		
		JLabel lblQualityOfWork_1 = new JLabel("Quality of work :");
		lblQualityOfWork_1.setBounds(550, 112, 117, 14);
		contentPane.add(lblQualityOfWork_1);
		
		JLabel lblInitiative = new JLabel("Initiative :");
		lblInitiative.setBounds(550, 153, 117, 14);
		contentPane.add(lblInitiative);
		
		JLabel lblCreativeThinking_1 = new JLabel("Creative Thinking / Innovation :");
		lblCreativeThinking_1.setBounds(550, 190, 173, 14);
		contentPane.add(lblCreativeThinking_1);
		
		JLabel lblLeadershipAbilities_1 = new JLabel("Leadership Abilities :");
		lblLeadershipAbilities_1.setBounds(550, 233, 117, 14);
		contentPane.add(lblLeadershipAbilities_1);
		
		JLabel b6lbl = new JLabel("Reliability :");
		b6lbl.setBounds(550, 278, 83, 14);
		contentPane.add(b6lbl);
		
		JLabel lblTimeliness_1 = new JLabel("Timeliness :");
		lblTimeliness_1.setBounds(550, 319, 83, 14);
		contentPane.add(lblTimeliness_1);
		
		JLabel lblEfficiency_1 = new JLabel("Efficiency :");
		lblEfficiency_1.setBounds(550, 357, 83, 14);
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
					
					String add9 =rs.getString("last_assess1");
					last_assess1.setText(add9);
					
					String add10 =rs.getString("last_assess2");
					last_assess2.setText(add10);
					
					String add11 =rs.getString("last_assess3");
					last_assess3.setText(add11);
					
					String add12 =rs.getString("last_assess4");
					last_assess4.setText(add12);
					
					String add13 =rs.getString("last_assess5");
					last_assess5.setText(add13);
					
					String add14 =rs.getString("last_assess6");
					last_assess6.setText(add14);
					
					String add15 =rs.getString("last_assess7");
					last_assess7.setText(add15);
					
					String add16 =rs.getString("last_assess8");
					last_assess8.setText(add16);
					
					
					rs.close();
					pst.close();
					
					
					
					
					
					
				}catch(SQLException e){
					logger.error(e);
					 if(e.getErrorCode()== 0)
						{
							JOptionPane.showMessageDialog(null,"Please Input Correct Employee ID");
						}
						 else
						 {
							 JOptionPane.showMessageDialog(null,e);
						 }
							
						}	
				
				
				
			}
		});
		btnNewButton.setBounds(189, 65, 73, 23);
		contentPane.add(btnNewButton);
		
		last_assess1 = new JTextField();
		last_assess1.setEditable(false);
		last_assess1.setBounds(736, 66, 24, 20);
		contentPane.add(last_assess1);
		last_assess1.setColumns(10);
		
		last_assess2 = new JTextField();
		last_assess2.setEditable(false);
		last_assess2.setColumns(10);
		last_assess2.setBounds(736, 109, 24, 20);
		contentPane.add(last_assess2);
		
		last_assess3 = new JTextField();
		last_assess3.setEditable(false);
		last_assess3.setColumns(10);
		last_assess3.setBounds(736, 150, 24, 20);
		contentPane.add(last_assess3);
		
		last_assess4 = new JTextField();
		last_assess4.setEditable(false);
		last_assess4.setColumns(10);
		last_assess4.setBounds(736, 187, 24, 20);
		contentPane.add(last_assess4);
		
		last_assess5 = new JTextField();
		last_assess5.setEditable(false);
		last_assess5.setColumns(10);
		last_assess5.setBounds(736, 230, 24, 20);
		contentPane.add(last_assess5);
		
		last_assess6 = new JTextField();
		last_assess6.setEditable(false);
		last_assess6.setColumns(10);
		last_assess6.setBounds(736, 278, 24, 20);
		contentPane.add(last_assess6);
		
		last_assess7 = new JTextField();
		last_assess7.setEditable(false);
		last_assess7.setColumns(10);
		last_assess7.setBounds(736, 316, 24, 20);
		contentPane.add(last_assess7);
		
		last_assess8 = new JTextField();
		last_assess8.setEditable(false);
		last_assess8.setColumns(10);
		last_assess8.setBounds(736, 354, 24, 20);
		contentPane.add(last_assess8);
		
		JLabel lblDateOfLast = new JLabel("Date of Last Assessment");
		lblDateOfLast.setBounds(522, 23, 159, 14);
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
					String val3=(String) assess1.getSelectedItem();
					String val4=(String) assess2.getSelectedItem();
					String val5=(String) assess3.getSelectedItem();
					String val6=(String) assess4.getSelectedItem();
					String val7=(String) assess5.getSelectedItem();
					String val8=(String) assess6.getSelectedItem();
					String val9=(String) assess7.getSelectedItem();
					String val10=(String) assess8.getSelectedItem();
					
					
					String sql="update emp set e_id='"+val2+"',l_date='"+val1+"', last_assess1='"+val3+"', " + "last_assess2='"+val4+"',last_assess3='"+val5+"',"
							+ "last_assess4='"+val6+"',last_assess5='"+val7+"',last_assess6='"+val8+"', last_assess7 = '"+val9+"', " + "last_assess8 = '"+val10+"' where e_id='"+val2+"' "; 
					
					PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					pst.close();
				    JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
					
				}catch(Exception e2)
				{   logger.error(e2);
					JOptionPane.showMessageDialog(null, "Please Ensure correct ID and that the Information is Comeplete");
				}
				
				
				
				
				
				
				
			}
		});
		btnUpdate.setBounds(456, 437, 89, 23);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 215, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(215, 0, 10, 41);
		contentPane.add(separator_1);
		connection=sqliteconn.dbConnector();
	}
}
