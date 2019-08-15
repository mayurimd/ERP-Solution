package com.Eazyerp.user;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Eazyerp.conn.Login;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrameUser extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameUser frame = new MainFrameUser();
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
	public MainFrameUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 358);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 498, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View Profile");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditEmployee a= new EditEmployee();
				a.setVisible(true);
				
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Payroll");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salary Structure");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalaryStructure a=new SalaryStructure();
				a.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Appraisals");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Assessment");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpAssement a = new EmpAssement();
				a.setVisible(true);
				
				
				
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("Training");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Event Details");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpTraining a = new EmpTraining();
				a.setVisible(true);
				
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JLabel lblYouAreLogged = new JLabel("You are logged in as a User");
		lblYouAreLogged.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYouAreLogged.setBounds(10, 289, 203, 19);
		contentPane.add(lblYouAreLogged);
		
		JLabel label = new JLabel("Your Employee ID is :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(223, 289, 156, 19);
		contentPane.add(label);
		
		JLabel idlbl = new JLabel((String) null);
		idlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idlbl.setBounds(375, 289, 56, 19);
		contentPane.add(idlbl);
		idlbl.setText(Login.t);
	}
}
