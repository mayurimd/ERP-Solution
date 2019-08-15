package com.Eazyerp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.sqliteconn;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class TrainingEvent extends JFrame {

	private JPanel contentPane;
	private JTextField event_id;
	private JTextField tit;
	private JTextField loc;
	private JTextField st_date;
	private JTextField end_date;
	private JTextField status;
	private JTextField tr_prov;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingEvent frame = new TrainingEvent();
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
	public TrainingEvent() {
		final Logger logger = Logger.getLogger(TrainingEvent.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 619, 394);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblAddTrainingEvent = new JLabel("Add Training Event");
		lblAddTrainingEvent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddTrainingEvent.setBounds(10, 0, 181, 30);
		contentPane.add(lblAddTrainingEvent);
		
		JLabel lblNewLabel = new JLabel("Event ID");
		lblNewLabel.setBounds(10, 54, 46, 14);
		contentPane.add(lblNewLabel);
		
		event_id = new JTextField();
		event_id.setBounds(151, 52, 86, 17);
		contentPane.add(event_id);
		event_id.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 87, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 123, 86, 14);
		contentPane.add(lblLocation);
		
		JLabel lblStartDateddmmyy = new JLabel("Start Date (dd.mm.yy)");
		lblStartDateddmmyy.setBounds(10, 166, 131, 14);
		contentPane.add(lblStartDateddmmyy);
		
		JLabel lblEndDateddmmyy = new JLabel("End Date (dd.mm.yy)");
		lblEndDateddmmyy.setBounds(10, 203, 131, 14);
		contentPane.add(lblEndDateddmmyy);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(373, 54, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblTrainingProvider = new JLabel("Training Provider");
		lblTrainingProvider.setBounds(325, 87, 118, 14);
		contentPane.add(lblTrainingProvider);
		
		tit = new JTextField();
		tit.setColumns(10);
		tit.setBounds(151, 85, 136, 17);
		contentPane.add(tit);
		
		loc = new JTextField();
		loc.setColumns(10);
		loc.setBounds(151, 121, 136, 17);
		contentPane.add(loc);
		
		st_date = new JTextField();
		st_date.setColumns(10);
		st_date.setBounds(151, 164, 136, 17);
		contentPane.add(st_date);
		
		end_date = new JTextField();
		end_date.setColumns(10);
		end_date.setBounds(151, 201, 136, 17);
		contentPane.add(end_date);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(453, 52, 112, 17);
		contentPane.add(status);
		
		tr_prov = new JTextField();
		tr_prov.setColumns(10);
		tr_prov.setBounds(453, 85, 112, 17);
		contentPane.add(tr_prov);
		
		JButton btnNewButton = new JButton("Add Event");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql="Insert into training (event_id,title,location,st_date,end_date,status,tr_prov) values(?,?,?,?,?,?,?)";
					PreparedStatement pst1=connection.prepareStatement(sql);  
					
				      pst1.setString(1, event_id.getText());
				      pst1.setString(2, tit.getText());
				      pst1.setString(3, loc.getText());
				      pst1.setString(4, st_date.getText());
				      pst1.setString(5, end_date.getText());
				      pst1.setString(6, status.getText());
				      pst1.setString(7, tr_prov.getText());
					
				     pst1.execute();
				     pst1.close();
				     
				   JOptionPane.showMessageDialog(null, "Saved");
					
				}
				catch(SQLException e1)
				{ logger.error(e1);
					int SQLITE_CONSTRAINT_PRIMARYKEY = 19 ;
			    int SQLITE_DATATYPE_MISMATCH = 20;
			
			if (e1.getErrorCode()== SQLITE_CONSTRAINT_PRIMARYKEY)
			{
				JOptionPane.showMessageDialog(null,"This Event already Exists");
			}
			if (e1.getErrorCode()== SQLITE_DATATYPE_MISMATCH)
			{
				JOptionPane.showMessageDialog(null,"Please ensure that correct Data has been filled in all fields");
			}
			
				
			}
				
			}
		});
		btnNewButton.setBounds(127, 289, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					  String sql="delete from training where event_id=?";
					  PreparedStatement pst=connection.prepareStatement(sql);
						pst.setString(1,event_id.getText());
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"Event Deleted");
						pst.close();
						
						
						
						
				}catch(Exception e5){
					logger.error(e5);
					JOptionPane.showMessageDialog(null,"Please ensure correct ID and that the Data is Complete");
			}
			}});
		btnDelete.setBounds(253, 289, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event_id.setText("");
			    tit.setText("");
			      loc.setText("");
			      st_date.setText("");
			      end_date.setText("");
			    status.setText("");
			     tr_prov.setText("");
				
			}
		});
		btnClear.setBounds(380, 289, 89, 23);
		contentPane.add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 35, 197, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(197, 0, 10, 35);
		contentPane.add(separator_1);
	}
}
