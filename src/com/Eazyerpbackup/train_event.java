package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class train_event extends JFrame {

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
					train_event frame = new train_event();
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
	public train_event() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		event_id.setBounds(80, 52, 86, 17);
		contentPane.add(event_id);
		event_id.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 87, 46, 14);
		contentPane.add(lblTitle);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(10, 123, 46, 14);
		contentPane.add(lblLocation);
		
		JLabel lblStartDateddmmyy = new JLabel("Start Date (dd.mm.yy)");
		lblStartDateddmmyy.setBounds(10, 166, 116, 14);
		contentPane.add(lblStartDateddmmyy);
		
		JLabel lblEndDateddmmyy = new JLabel("End Date (dd.mm.yy)");
		lblEndDateddmmyy.setBounds(10, 203, 108, 14);
		contentPane.add(lblEndDateddmmyy);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(234, 54, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblTrainingProvider = new JLabel("Training Provider");
		lblTrainingProvider.setBounds(234, 87, 94, 14);
		contentPane.add(lblTrainingProvider);
		
		tit = new JTextField();
		tit.setColumns(10);
		tit.setBounds(80, 84, 86, 17);
		contentPane.add(tit);
		
		loc = new JTextField();
		loc.setColumns(10);
		loc.setBounds(80, 120, 86, 17);
		contentPane.add(loc);
		
		st_date = new JTextField();
		st_date.setColumns(10);
		st_date.setBounds(127, 164, 86, 17);
		contentPane.add(st_date);
		
		end_date = new JTextField();
		end_date.setColumns(10);
		end_date.setBounds(128, 201, 86, 17);
		contentPane.add(end_date);
		
		status = new JTextField();
		status.setColumns(10);
		status.setBounds(308, 51, 86, 17);
		contentPane.add(status);
		
		tr_prov = new JTextField();
		tr_prov.setColumns(10);
		tr_prov.setBounds(338, 85, 86, 17);
		contentPane.add(tr_prov);
		
		JButton btnNewButton = new JButton("Add Event");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql="Insert into training (event_id,tit,loc,st_date,end_date,status,tr_prov) values(?,?,?,?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(sql);  
				      pst.setString(1, event_id.getText());
				      pst.setString(2, tit.getText());
				      pst.setString(3, loc.getText());
				      pst.setString(4, st_date.getText());
				      pst.setString(5, end_date.getText());
				      pst.setString(6, status.getText());
				      pst.setString(7, tr_prov.getText());
					
				      pst.execute();
				     pst.close();
				     
				      JOptionPane.showMessageDialog(null, "Saved");
					
				}catch(Exception e4)
				{
					JOptionPane.showMessageDialog(null, e4);
				}
			}
		});
		btnNewButton.setBounds(294, 145, 89, 23);
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
						connection.commit();
						connection.close();
						
						
				}catch(Exception e5){
					JOptionPane.showMessageDialog(null,e5);
			}
			}});
		btnDelete.setBounds(294, 179, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setBounds(294, 213, 89, 23);
		contentPane.add(btnClear);
	}

}
