package com.Eazyerpbackup;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {
 int a=0,b=0;
	private JFrame frame;

	/**	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JTextField idtext;
private JPasswordField pwtext;
	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		connection=sqliteconn.dbConnector();
		
	}
public static String t=null;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setBounds(81, 59, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 95, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		idtext = new JTextField();
		idtext.setBounds(179, 56, 86, 20);
		frame.getContentPane().add(idtext);
		idtext.setColumns(10);
		
		pwtext = new JPasswordField();
		pwtext.setBounds(179, 92, 86, 20);
		frame.getContentPane().add(pwtext);
		
		JButton btnlogin = new JButton("OK");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(a==0&&b==0)
					{JOptionPane.showMessageDialog(null, "Please Select Credentials");}
					if(a==1){
					String query="select * from admin where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, idtext.getText());
					t= idtext.getText();
					pst.setString(2, pwtext.getText());
					
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count++;
						
					}
					if(count==1)
					{JOptionPane.showMessageDialog(null, "id and pass is correct");
					MainFrame a=new MainFrame();
					frame.dispose();
					a.setVisible(true);
				}
					else
				{
					JOptionPane.showMessageDialog(null, "id and pass is incorrect");
				}rs.close();pst.close();}
				if(b==1)
				{
					String query="select * from manager where username=? and password=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, idtext.getText());
					pst.setString(2, pwtext.getText());
					t= idtext.getText();
					ResultSet rs=pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count++;
						
					}
					if(count==1)
					{JOptionPane.showMessageDialog(null, "id and pass is correct");
					MainFrameUser b= new MainFrameUser();
					b.setVisible(true);
				}else
				{
					JOptionPane.showMessageDialog(null, "id and pass is incorrect");
				}rs.close();pst.close();}}
				
					catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
		});
		btnlogin.setBounds(91, 180, 89, 23);
		frame.getContentPane().add(btnlogin);
		JRadioButton rdbtnUser = new JRadioButton("USer");
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=1;b=0;
				rdbtnUser.setSelected(false);
				
				
			}
		});
		rdbtnAdmin.setBounds(288, 168, 109, 23);
		frame.getContentPane().add(rdbtnAdmin);
		
		
		rdbtnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b=1;a=0;
				rdbtnAdmin.setSelected(false);
			}
		});
		rdbtnUser.setBounds(288, 194, 109, 23);
		frame.getContentPane().add(rdbtnUser);
	}
}
