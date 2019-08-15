package com.Eazyerp.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.Login;
import com.Eazyerp.conn.sqliteconn;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmpGoal extends JFrame {

	private JPanel contentPane;
	
	private JTextField gt_date;
	private JTextField gc_date;
	private JTextField e_id;
	private JTextField name;
	Connection connection=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpGoal frame = new EmpGoal();
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
	public EmpGoal() {
		final Logger logger = Logger.getLogger(EmpGoal.class);
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
		g1.setEditable(false);
		g1.setBounds(10, 95, 580, 111);
		contentPane.add(g1);
		
		JLabel lblNewLabel = new JLabel("Current Objectives / Goals");
		lblNewLabel.setBounds(10, 65, 155, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTargetDate = new JLabel("Target Date");
		lblTargetDate.setBounds(439, 65, 81, 14);
		contentPane.add(lblTargetDate);
		
		gt_date = new JTextField();
		gt_date.setEditable(false);
		gt_date.setText("dd.mm.yy");
		gt_date.setBounds(530, 62, 89, 20);
		contentPane.add(gt_date);
		gt_date.setColumns(10);
		
		JTextArea g2 = new JTextArea();
		g2.setEditable(false);
		g2.setBounds(10, 277, 580, 111);
		contentPane.add(g2);
		
		JLabel lblResultsPerformance = new JLabel("Results / Performance / Comments of Previous Goals");
		lblResultsPerformance.setBounds(10, 251, 298, 14);
		contentPane.add(lblResultsPerformance);
		
		JLabel lblCompletionDate = new JLabel("Completion Date");
		lblCompletionDate.setBounds(420, 252, 100, 14);
		contentPane.add(lblCompletionDate);
		
		gc_date = new JTextField();
		gc_date.setEditable(false);
		gc_date.setText("dd.mm.yy");
		gc_date.setColumns(10);
		gc_date.setBounds(533, 248, 86, 20);
		contentPane.add(gc_date);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setBounds(108, 23, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		e_id = new JTextField();
		e_id.setEditable(false);
		e_id.setBounds(212, 20, 46, 20);
		contentPane.add(e_id);
		e_id.setColumns(10);
		e_id.setText(Login.t);
		
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
		btnNewButton.setBounds(281, 19, 79, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setBounds(385, 23, 100, 14);
		contentPane.add(lblEmployeeName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(492, 20, 98, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 39, 70, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(69, 0, 10, 41);
		contentPane.add(separator_1);
	}

}
