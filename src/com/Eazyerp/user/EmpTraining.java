package com.Eazyerp.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.SystemColor;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.sqliteconn;

import net.proteanit.sql.DbUtils;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmpTraining extends JFrame {

	private JPanel contentPane;
	private JTextField event_id;
	private JTextField tr_prov;
	private JTextField loc;
	private JTextField status;
	Connection connection=null;
	private JTextField tit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpTraining frame = new EmpTraining();
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
	public EmpTraining() {
		final Logger logger = Logger.getLogger(EmpTraining.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 445, 321);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		connection=sqliteconn.dbConnector();
		contentPane.setLayout(null);
		
		event_id = new JTextField();
		event_id.setBounds(134, 54, 86, 20);
		contentPane.add(event_id);
		event_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Event ID");
		lblNewLabel.setBounds(22, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId = new JLabel("Training Provider");
		lblEmployeeId.setBounds(22, 143, 89, 20);
		contentPane.add(lblEmployeeId);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(261, 53, 89, 23);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
				String sql = "select * from training where event_id=?";
				PreparedStatement pst=connection.prepareStatement(sql);
				pst.setString(1,event_id.getText());
				ResultSet rs=pst.executeQuery();
				rs=pst.executeQuery();
				
				//String add1 =rs.getString("event_id");
				//event_id.setText(add1);
				
				
				String add17=rs.getString("title");
				tit.setText(add17);
				
				String add2 =rs.getString("location");
				loc.setText(add2);
				
				String add3 =rs.getString("tr_prov");
				tr_prov.setText(add3);
				
				String add4 =rs.getString("status");
				status.setText(add4);
				
	
				
				pst.close();
				rs.close();
				
				
				 }catch(SQLException e1){
					 logger.error(e1);
               	  JOptionPane.showMessageDialog(null, "Employee Does Not Exist. Please Enter Correct ID");
				    }
					
				
				
				
				
			}
		});
		contentPane.add(btnView);
		
		tr_prov = new JTextField();
		tr_prov.setBounds(134, 143, 86, 20);
		tr_prov.setColumns(10);
		contentPane.add(tr_prov);
		
		JLabel lblTrainingLocation = new JLabel("Training Location");
		lblTrainingLocation.setBounds(22, 186, 89, 14);
		contentPane.add(lblTrainingLocation);
		
		JLabel Statuslbl = new JLabel("Status");
		Statuslbl.setBounds(22, 222, 89, 20);
		contentPane.add(Statuslbl);
		
		loc = new JTextField();
		loc.setBounds(134, 183, 86, 20);
		loc.setColumns(10);
		contentPane.add(loc);
		
		status = new JTextField();
		status.setBounds(134, 222, 86, 20);
		status.setColumns(10);
		contentPane.add(status);
		
		JLabel lblEmployeeTraining = new JLabel("Employee Training");
		lblEmployeeTraining.setBounds(10, 0, 177, 35);
		lblEmployeeTraining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmployeeTraining);
		
		JLabel lblT = new JLabel("Title");
		lblT.setBounds(22, 105, 46, 14);
		contentPane.add(lblT);
		
		tit = new JTextField();
		tit.setBounds(134, 102, 86, 20);
		tit.setColumns(10);
		contentPane.add(tit);
		
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