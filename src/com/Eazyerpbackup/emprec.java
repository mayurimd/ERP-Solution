package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class emprec extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField app_id;
	private JTextField sex;
	private JTextField email;
	private JTextField field;
	private JTextField exp;
	private JTextField cur_emp;
	private JTextField dob;
	private JTextField mob;
	private JTextField edu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emprec frame = new emprec();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTextField age;
	private JTextField desig;
	/**
	 * Create the frame.
	 */
	public emprec() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 771, 508);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblNewLabel = new JLabel("Applicant ID");
		lblNewLabel.setBounds(254, 57, 84, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegisterANew = new JLabel("Register");
		lblRegisterANew.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRegisterANew.setBounds(20, 11, 94, 35);
		contentPane.add(lblRegisterANew);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(338, 44, -311, 20);
		contentPane.add(separator);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setBounds(20, 103, 84, 20);
		contentPane.add(lblName);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(20, 148, 84, 20);
		contentPane.add(lblSex);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(125, 103, 101, 20);
		contentPane.add(name);
		
		app_id = new JTextField();
		app_id.setColumns(10);
		app_id.setBounds(324, 57, 101, 20);
		contentPane.add(app_id);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(125, 148, 101, 20);
		contentPane.add(sex);
		
		JLabel lblEmailid = new JLabel("Education");
		lblEmailid.setBounds(468, 148, 84, 20);
		contentPane.add(lblEmailid);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(589, 103, 101, 20);
		contentPane.add(email);
		
		JLabel lblEmailid_1 = new JLabel("Email ID");
		lblEmailid_1.setBounds(468, 103, 84, 20);
		contentPane.add(lblEmailid_1);
		
		field = new JTextField();
		field.setColumns(10);
		field.setBounds(589, 193, 101, 20);
		contentPane.add(field);
		
		JLabel lblField = new JLabel("Field");
		lblField.setBounds(468, 193, 74, 20);
		contentPane.add(lblField);
		
		exp = new JTextField();
		exp.setColumns(10);
		exp.setBounds(589, 240, 101, 20);
		contentPane.add(exp);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setBounds(468, 236, 74, 29);
		contentPane.add(lblExperience);
		
		cur_emp = new JTextField();
		cur_emp.setColumns(10);
		cur_emp.setBounds(589, 285, 101, 20);
		contentPane.add(cur_emp);
		
		JLabel lblCurrentemp = new JLabel("Current Employer");
		lblCurrentemp.setBounds(468, 281, 84, 29);
		contentPane.add(lblCurrentemp);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(125, 240, 101, 20);
		contentPane.add(dob);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setBounds(20, 240, 74, 20);
		contentPane.add(lblDob);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(125, 285, 101, 20);
		contentPane.add(mob);
		
		JLabel lblContactno = new JLabel("Contact_No.");
		lblContactno.setBounds(20, 285, 74, 20);
		contentPane.add(lblContactno);
		
		edu = new JTextField();
		edu.setColumns(10);
		edu.setBounds(589, 148, 101, 20);
		contentPane.add(edu);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String sql="Insert into emprec (app_id,name,sex,dob,mob,email,edu,field,exp,curr_emp,age,desig) values(?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(sql); 
					
					pst.setString(1, app_id.getText());
				      pst.setString(2, name.getText());
				      pst.setString(3, sex.getText());
				      pst.setString(4, dob.getText());
				      pst.setString(5, mob.getText());
				      pst.setString(6, email.getText());
				      pst.setString(7, edu.getText());
				      pst.setString(8, field.getText());
				      pst.setString(9, exp.getText());
				      pst.setString(10, cur_emp.getText());
				      pst.setString(11, age.getText());
				      pst.setString(12, desig.getText());
				      pst.execute();
				      JOptionPane.showMessageDialog(null, "Saved");
				      
				      
					
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(254, 396, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			name.setText("");
			app_id.setText("");
			sex.setText("");
				dob.setText("");
				email.setText("");
				cur_emp.setText("");
				exp.setText("");
				edu.setText("");
				field.setText("");
				mob.setText("");
				age.setText("");
				
				
				
			}
		});
		btnNewButton_1.setBounds(353, 396, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(20, 196, 46, 14);
		contentPane.add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(125, 193, 101, 20);
		contentPane.add(age);
		
		JLabel lblSeignation = new JLabel("Designation");
		lblSeignation.setBounds(20, 326, 74, 20);
		contentPane.add(lblSeignation);
		
		desig = new JTextField();
		desig.setColumns(10);
		desig.setBounds(125, 326, 101, 20);
		contentPane.add(desig);
	}
}
