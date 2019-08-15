package com.Eazyerp.conn;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import org.apache.log4j.Logger;

import com.Eazyerp.admin.EditEmployee;
import com.Eazyerp.admin.MainFrame;
import com.Eazyerp.user.MainFrameUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class Login {
 int a=0,b=0;
	private JFrame frmEazyErp;

	/**	 * Launch the application.
	 */
	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(Login.class);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmEazyErp.setVisible(true);
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
	public Login() {
		
		initialize();
		connection=sqliteconn.dbConnector();
		
	}
public static String t=null;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final Logger logger = Logger.getLogger(Login.class);
		frmEazyErp = new JFrame();
		frmEazyErp.setForeground(Color.WHITE);
		frmEazyErp.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmEazyErp.setBounds(100, 100, 474, 300);
		frmEazyErp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEazyErp.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setBounds(10, 56, 74, 14);
		frmEazyErp.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 98, 74, 14);
		frmEazyErp.getContentPane().add(lblPassword);
		
		idtext = new JTextField();
		idtext.setBounds(94, 53, 109, 20);
		frmEazyErp.getContentPane().add(idtext);
		idtext.setColumns(10);
		
		pwtext = new JPasswordField();
		pwtext.setBounds(94, 95, 109, 20);
		frmEazyErp.getContentPane().add(pwtext);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(a==0&&b==0)
					{JOptionPane.showMessageDialog(null, "Please Select Credentials");}
					if(a==1){
					String query="select * from admin where e_id=? and password=?";
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
					{
					MainFrame a=new MainFrame();
					frmEazyErp.dispose();
					a.setVisible(true);
				}
					else
				{
					JOptionPane.showMessageDialog(null, "Login credentials are Incorrect or User does not exist ");
				}rs.close();pst.close();}
				if(b==1)
				{
					String query="select * from user where e_id=? and password=?";
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
					{
					MainFrameUser b= new MainFrameUser();
					frmEazyErp.dispose();
					b.setVisible(true);
				}else
				{
					JOptionPane.showMessageDialog(null, "Login credentials are Incorrect or User does not exist");
				}rs.close();pst.close();}}
				
					catch(Exception e)
				{  logger.error(e);
					JOptionPane.showMessageDialog(null, "Please Correct and Full Details are Entered and that no other instances of the Program is Running");
					
				}
			}
		});
		btnlogin.setBounds(114, 162, 89, 23);
		frmEazyErp.getContentPane().add(btnlogin);
		JRadioButton rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBackground(SystemColor.inactiveCaption);
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setBackground(SystemColor.inactiveCaption);
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=1;b=0;
				rdbtnUser.setSelected(false);
				
				
			}
		});
		rdbtnAdmin.setBounds(282, 65, 109, 14);
		frmEazyErp.getContentPane().add(rdbtnAdmin);
		
		
		rdbtnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b=1;a=0;
				rdbtnAdmin.setSelected(false);
			}
		});
		rdbtnUser.setBounds(282, 83, 109, 14);
		frmEazyErp.getContentPane().add(rdbtnUser);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idtext.setText("");
				pwtext.setText("");
				
				
			}
		});
		btnClear.setBounds(235, 162, 89, 23);
		frmEazyErp.getContentPane().add(btnClear);
		
		JLabel lblEazyErp = new JLabel("Welcome to EZ ERP");
		lblEazyErp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEazyErp.setBounds(10, 0, 176, 30);
		frmEazyErp.getContentPane().add(lblEazyErp);
		
		JLabel lblPleaseChooseCredentials = new JLabel("Please Choose Credentials");
		lblPleaseChooseCredentials.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseChooseCredentials.setBounds(282, 28, 176, 30);
		frmEazyErp.getContentPane().add(lblPleaseChooseCredentials);
	}
}
