package com.Eazyerp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.sqliteconn;

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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmpGoals extends JFrame {

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
					EmpGoals frame = new EmpGoals();
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
	public EmpGoals() {
		final Logger logger = Logger.getLogger(EmpGoals.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 645, 491);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
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
		lblNewLabel.setBounds(10, 65, 163, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTargetDate = new JLabel("Target Date");
		lblTargetDate.setBounds(428, 65, 80, 14);
		contentPane.add(lblTargetDate);
		
		gt_date = new JTextField();
		gt_date.setText("dd.mm.yy");
		gt_date.setBounds(533, 62, 86, 20);
		contentPane.add(gt_date);
		gt_date.setColumns(10);
		
		JTextArea g2 = new JTextArea();
		g2.setBounds(10, 276, 580, 111);
		contentPane.add(g2);
		
		JLabel lblResultsPerformance = new JLabel("Results / Performance / Comments of Previous Goals");
		lblResultsPerformance.setBounds(10, 251, 279, 14);
		contentPane.add(lblResultsPerformance);
		
		JLabel lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(428, 252, 95, 14);
		contentPane.add(lblCompletionDate);
		
		gc_date = new JTextField();
		gc_date.setText("dd.mm.yy");
		gc_date.setColumns(10);
		gc_date.setBounds(533, 248, 86, 20);
		contentPane.add(gc_date);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String val1=g1.getText();
				
					String val3=e_id.getText();
					String val5=gt_date.getText();
				
					

					String sql="update emp set e_id='"+val3+"',goal='"+val1+"', goaltarget_date='"+val5+"' where e_id='"+val3+"' "; 
					
                     PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
				}catch(Exception e2)
				{    logger.error(e2);
					JOptionPane.showMessageDialog(null, "Please ensure correct ID and that the information is Complete");
				}
				
				
			}
		});
		btnUpdate.setBounds(365, 206, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					
					String val2=g2.getText();
					String val3=e_id.getText();
					
					String val6=gc_date.getText();
					

					String sql="update emp set e_id='"+val3+"', last_goal='"+val2+"',goalcompletion_date='"+val6+"' where e_id='"+val3+"' "; 
					
                     PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
				}catch(Exception e2)
				{
					logger.error(e2);
					JOptionPane.showMessageDialog(null, "Please ensure correct ID and that the information is Complete");
				}
				
				
				
			}
		});
		button.setBounds(365, 390, 89, 23);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(153, 23, 80, 14);
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
					
					String add12 =rs.getString("goaltarget_date");
					gt_date.setText(add12);
					
					String add13 =rs.getString("goalcompletion_date");
					gc_date.setText(add13);
										
					String add17=rs.getString("goal");
					g1.setText(add17);
					
					String add2 =rs.getString("last_goal");
					g2.setText(add2);
					
					rs.close();
					pst.close();
					
					
					
					
					
				}catch(SQLException e){
					logger.error(e);
              	  JOptionPane.showMessageDialog(null, "Employee Does Not Exist. Please Enter Correct ID");
				    }
				
				
				
			}
		});
		btnNewButton.setBounds(320, 19, 79, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(183, 70, 92, 14);
		contentPane.add(lblEmployeeName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(282, 67, 98, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				g1.setText("");
				gt_date.setText("");
			}
		});
		btnClear.setBounds(467, 206, 89, 23);
		contentPane.add(btnClear);
		
		JButton button_1 = new JButton("Clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g2.setText("");
				gc_date.setText("");
			}
		});
		button_1.setBounds(467, 390, 89, 23);
		contentPane.add(button_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 80, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(80, 0, 10, 41);
		contentPane.add(separator_1);
	}
}
