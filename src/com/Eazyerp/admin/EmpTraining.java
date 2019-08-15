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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class EmpTraining extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField event_id;
	private JTextField tr_prov;
	private JTextField loc;
	private JTextField status;
	private JTextField eid1;
	private JTextField eid2;
	private JTextField eid3;
	private JTextField eid4;
	private JTextField eid5;
	private JTextField eid6;
	private JTextField eid7;
	private JTextField eid8;
	private JTextField eid9;
	private JTextField eid10;

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
	Connection connection=null;
	private JTextField tit;
	/**
	 * Create the frame.
	 */
	public EmpTraining() {
		final Logger logger = Logger.getLogger(EmpTraining.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 778, 538);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		connection=sqliteconn.dbConnector();
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 292, 742, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollPane.setColumnHeaderView(scrollbar);
		
		Scrollbar scrollbar_1 = new Scrollbar();
		scrollPane.setColumnHeaderView(scrollbar_1);
		
		Scrollbar scrollbar_2 = new Scrollbar();
		scrollPane.setColumnHeaderView(scrollbar_2);
		
		event_id = new JTextField();
		event_id.setBounds(134, 54, 86, 20);
		contentPane.add(event_id);
		event_id.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Event ID");
		lblNewLabel.setBounds(22, 57, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId = new JLabel("Training Provider");
		lblEmployeeId.setBounds(22, 143, 102, 20);
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
				
				String add5 =rs.getString("emp1");
				eid1.setText(add5);
				
				String add6 =rs.getString("emp2");
				eid2.setText(add6);
				
				String add7 =rs.getString("emp3");
				eid3.setText(add7);
				
				String add8 =rs.getString("emp4");
				eid4.setText(add8);
				
				String add9 =rs.getString("emp5");
				eid5.setText(add9);
				
				String add10 =rs.getString("emp6");
				eid6.setText(add10);
				
				String add11 =rs.getString("emp7");
				eid7.setText(add11);
				
				String add12 =rs.getString("emp8");
				eid8.setText(add12);
				
				String add13 =rs.getString("emp9");
				eid9.setText(add13);
				
				String add14 =rs.getString("emp10");
				eid10.setText(add14);
				
				pst.close();
				rs.close();
				
				
				 }catch(SQLException e1){
					 logger.error(e1);
					 if(e1.getErrorCode()== 0)
						{
							JOptionPane.showMessageDialog(null,"Please Input Correct Event ID");
						}
						 else
						 {
							 JOptionPane.showMessageDialog(null,e);
						 }
							
						}	
				
				
				
				
			}
		});
		contentPane.add(btnView);
		
		tr_prov = new JTextField();
		tr_prov.setBounds(134, 143, 86, 20);
		tr_prov.setColumns(10);
		contentPane.add(tr_prov);
		
		JLabel lblTrainingLocation = new JLabel("Training Location");
		lblTrainingLocation.setBounds(22, 186, 102, 14);
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
		
		JLabel lblAddEmployee = new JLabel("Add Employee ID");
		lblAddEmployee.setBounds(560, 11, 109, 14);
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblAddEmployee);
		
		JLabel label = new JLabel("1.");
		label.setBounds(511, 33, 10, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2.");
		label_1.setBounds(511, 57, 10, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3.");
		label_2.setBounds(511, 82, 10, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4.");
		label_3.setBounds(511, 105, 10, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5.");
		label_4.setBounds(511, 126, 10, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6.");
		label_5.setBounds(650, 33, 10, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("7.");
		label_6.setBounds(650, 57, 10, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("8.");
		label_7.setBounds(650, 82, 10, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("9.");
		label_8.setBounds(650, 105, 10, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("10.");
		label_9.setBounds(644, 126, 16, 14);
		contentPane.add(label_9);
		
		eid1 = new JTextField();
		eid1.setBounds(531, 30, 38, 20);
		eid1.setColumns(10);
		contentPane.add(eid1);
		
		eid2 = new JTextField();
		eid2.setBounds(531, 54, 38, 20);
		eid2.setColumns(10);
		contentPane.add(eid2);
		
		eid3 = new JTextField();
		eid3.setBounds(531, 79, 38, 20);
		eid3.setColumns(10);
		contentPane.add(eid3);
		
		eid4 = new JTextField();
		eid4.setBounds(531, 102, 38, 20);
		eid4.setColumns(10);
		contentPane.add(eid4);
		
		eid5 = new JTextField();
		eid5.setBounds(531, 123, 38, 20);
		eid5.setColumns(10);
		contentPane.add(eid5);
		
		eid6 = new JTextField();
		eid6.setBounds(670, 30, 38, 20);
		eid6.setColumns(10);
		contentPane.add(eid6);
		
		eid7 = new JTextField();
		eid7.setBounds(670, 54, 38, 20);
		eid7.setColumns(10);
		contentPane.add(eid7);
		
		eid8 = new JTextField();
		eid8.setBounds(670, 79, 38, 20);
		eid8.setColumns(10);
		contentPane.add(eid8);
		
		eid9 = new JTextField();
		eid9.setBounds(670, 102, 38, 20);
		eid9.setColumns(10);
		contentPane.add(eid9);
		
		eid10 = new JTextField();
		eid10.setBounds(670, 123, 38, 20);
		eid10.setColumns(10);
		contentPane.add(eid10);
		
		JButton btnAdd = new JButton("Update Event");
		btnAdd.setBounds(571, 169, 109, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String val1=eid1.getText();
					String val2=eid2.getText();
					String val3=eid3.getText();
					String val4=eid4.getText();
					String val5=eid5.getText();
					String val6=eid6.getText();
					String val7=eid7.getText();
					String val8=eid8.getText();
					String val9=eid9.getText();
					String val10=eid10.getText();
					String val11=event_id.getText();
					
					String sql="update training set emp1='"+val1+"',emp2='"+val2+"', emp3='"+val3+"', " + "emp4='"+val4+"',emp5='"+val5+"',"
							+ "emp6='"+val6+"',emp7='"+val7+"',emp8='"+val8+"',emp9 = '"+val9+"', " + "emp10 = '"+val10+"' where event_id='"+val11+"' "; 
					
					
					
                    PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					 JOptionPane.showMessageDialog(null, "Record Updated");
					
					
					
					
					
					
					
				}catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				
				
			}
		});
		contentPane.add(btnAdd);
		
		JLabel lblEmployeeTraining = new JLabel("Employee Training");
		lblEmployeeTraining.setBounds(0, -2, 177, 35);
		lblEmployeeTraining.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblEmployeeTraining);
		
		JLabel lblT = new JLabel("Title");
		lblT.setBounds(22, 105, 46, 14);
		contentPane.add(lblT);
		
		tit = new JTextField();
		tit.setBounds(134, 102, 86, 20);
		tit.setColumns(10);
		contentPane.add(tit);
		
		JButton btnRefreshEventTable = new JButton("Refresh Event Table");
		btnRefreshEventTable.setBounds(10, 264, 161, 23);
		btnRefreshEventTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				
				String query="select * from training ";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e3)
			{
				JOptionPane.showInternalMessageDialog(null, e3);
			}
				
				
				
				
				
				
			}
		});
		contentPane.add(btnRefreshEventTable);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 33, 187, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(186, 33, 1, -33);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(187, -2, 10, 35);
		contentPane.add(separator_2);
	}
}
