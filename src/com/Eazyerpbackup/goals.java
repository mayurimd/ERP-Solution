package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class goals extends JFrame {

	private JPanel contentPane;
	private JTextField gt_date;
	private JTextField gc_date;
	private JTextField e_id;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					goals frame = new goals();
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
	public goals() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 645, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblGoals = new JLabel("Goals");
		lblGoals.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGoals.setBounds(10, 11, 60, 30);
		contentPane.add(lblGoals);
		
		JTextArea g1 = new JTextArea();
		g1.setBounds(10, 95, 580, 111);
		contentPane.add(g1);
		
		JLabel lblNewLabel = new JLabel("Current Objectives / Goals");
		lblNewLabel.setBounds(10, 65, 144, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTargetDate = new JLabel("Target Date");
		lblTargetDate.setBounds(461, 65, 60, 14);
		contentPane.add(lblTargetDate);
		
		gt_date = new JTextField();
		gt_date.setText("dd.mm.yy");
		gt_date.setBounds(533, 62, 60, 20);
		contentPane.add(gt_date);
		gt_date.setColumns(10);
		
		JTextArea g2 = new JTextArea();
		g2.setBounds(10, 277, 580, 111);
		contentPane.add(g2);
		
		JLabel lblResultsPerformance = new JLabel("Results / Performance / Comments of Previous Goals");
		lblResultsPerformance.setBounds(10, 251, 265, 14);
		contentPane.add(lblResultsPerformance);
		
		JLabel lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(442, 251, 79, 14);
		contentPane.add(lblCompletionDate);
		
		gc_date = new JTextField();
		gc_date.setText("dd.mm.yy");
		gc_date.setColumns(10);
		gc_date.setBounds(533, 248, 60, 20);
		contentPane.add(gc_date);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String val1=g1.getText();
				
					String val3=e_id.getText();
					String val5=gt_date.getText();
				
					

					String sql="update emp set e_id='"+val3+"',g1='"+val1+"', gt_date='"+val5+"' where e_id='"+val3+"' "; 
					
                     PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnUpdate.setBounds(365, 206, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnRetreive = new JButton("Retreive");
		btnRetreive.setBounds(480, 206, 89, 23);
		contentPane.add(btnRetreive);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String val2=g2.getText();
					String val3=e_id.getText();
					
					String val6=gc_date.getText();
					

					String sql="update emp set e_id='"+val3+"', g2='"+val2+"',gc_date='"+val6+"' where e_id='"+val3+"' "; 
					
                     PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
		});
		button.setBounds(365, 390, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Retreive");
		button_1.setBounds(480, 390, 89, 23);
		contentPane.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(153, 23, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		e_id = new JTextField();
		e_id.setBounds(243, 20, 46, 20);
		contentPane.add(e_id);
		e_id.setColumns(10);
		
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
					
					String add12 =rs.getString("gt_date");
					gt_date.setText(add12);
					
					String add13 =rs.getString("gc_date");
					gc_date.setText(add13);
										
					String add17=rs.getString("g1");
					g1.setText(add17);
					
					String add2 =rs.getString("g2");
					g2.setText(add2);
					
					rs.close();
					pst.close();
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(320, 19, 60, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(183, 70, 79, 14);
		contentPane.add(lblEmployeeName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(282, 67, 98, 20);
		contentPane.add(name);
		name.setColumns(10);
	}
}
