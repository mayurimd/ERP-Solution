package com.Eazyerp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Eazyerp.conn.sqliteconn;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ViewSalaryTable extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSalaryTable frame = new ViewSalaryTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public ViewSalaryTable() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				MainFrame m1=new MainFrame();
				m1.setVisible(true);
				
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				MainFrame m1=new MainFrame();
				m1.setVisible(true);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 473);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblEmployeeSalaryTable = new JLabel("Employee Salary Table");
		lblEmployeeSalaryTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmployeeSalaryTable.setBounds(10, 0, 242, 30);
		contentPane.add(lblEmployeeSalaryTable);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String query="select * from salstruct ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
				
				
				
				
			}
		});
		btnRefresh.setBounds(917, 8, 89, 23);
		contentPane.add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 996, 382);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 35, 225, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(224, -5, 10, 42);
		contentPane.add(separator_1);
	}
}
