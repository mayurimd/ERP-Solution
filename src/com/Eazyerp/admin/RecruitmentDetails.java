package com.Eazyerp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.sqliteconn;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RecruitmentDetails extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecruitmentDetails frame = new RecruitmentDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	/**
	 * Create the frame.
	 */
	public RecruitmentDetails() {
		final Logger logger = Logger.getLogger(RecruitmentDetails.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 793, 486);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblRecruitmentDetails = new JLabel("Recruitment Details");
		lblRecruitmentDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRecruitmentDetails.setBounds(10, 11, 215, 30);
		contentPane.add(lblRecruitmentDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 757, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String query="select * from emprec ";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
									
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
				
				
				
			}
		});
		btnRefresh.setBounds(226, 19, 89, 23);
		contentPane.add(btnRefresh);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 35, 187, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(187, 0, 10, 35);
		contentPane.add(separator_1);
	}
}
