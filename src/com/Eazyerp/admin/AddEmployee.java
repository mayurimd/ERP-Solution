package com.Eazyerp.admin;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;


import com.Eazyerp.conn.sqliteconn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
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

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField e_id;
	private JTextField name;
	private JTextField desig;
	private JTextField emp_type;
	private JTextField email;
	private JTextField f_name;
	private JTextField dob;
	private JTextField sex;
	private JTextField b_grp;
	private JTextField nation;
	private JTextField age;
	private JTextField mob;
	private JTextField rec_mode;
	private JTextField j_date;
	private JTextField dept;
	private JTextField report_to;
	private JTextField bonus;
	private JTextField m_sal;
	private JTextField p_code;
	private JTextField h_no;
	private JTextField st_name;
	private JTextField city;
	private JTextField state;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {          
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		final Logger logger = Logger.getLogger(AddEmployee.class);
		connection=sqliteconn.dbConnector();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 964, 522);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Employee Code");
		label.setBounds(10, 71, 94, 24);
		contentPane.add(label);
		
		e_id = new JTextField();
		e_id.setColumns(10);
		e_id.setBounds(114, 73, 95, 20);
		contentPane.add(e_id);
		
		JLabel namelbl = new JLabel("Full Name");
		namelbl.setBounds(10, 106, 74, 24);
		contentPane.add(namelbl);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(10, 141, 74, 24);
		contentPane.add(lblDesignation);
		
		JLabel lblEmployeeType = new JLabel("Employee Type");
		lblEmployeeType.setBounds(10, 176, 94, 24);
		contentPane.add(lblEmployeeType);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 211, 74, 24);
		contentPane.add(lblEmail);
		
		JLabel lblFathersName = new JLabel("Fathers Name");
		lblFathersName.setBounds(10, 246, 94, 24);
		contentPane.add(lblFathersName);
		
		JLabel lblBod = new JLabel("BOD");
		lblBod.setBounds(10, 281, 74, 24);
		contentPane.add(lblBod);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(10, 316, 74, 24);
		contentPane.add(lblSex);
		
		JLabel lblBloodGroup = new JLabel("Blood Group");
		lblBloodGroup.setBounds(10, 351, 74, 24);
		contentPane.add(lblBloodGroup);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(10, 386, 74, 24);
		contentPane.add(lblNationality);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(10, 421, 74, 24);
		contentPane.add(lblAge);
		
		JLabel moblbl = new JLabel("Mobile");
		moblbl.setBounds(318, 71, 74, 24);
		contentPane.add(moblbl);
		
		JLabel lblRecruitmentMode = new JLabel("Recruitment Mode");
		lblRecruitmentMode.setBounds(318, 106, 115, 24);
		contentPane.add(lblRecruitmentMode);
		
		JLabel lblJoinDate = new JLabel("Join Date");
		lblJoinDate.setBounds(318, 141, 74, 24);
		contentPane.add(lblJoinDate);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(318, 176, 74, 24);
		contentPane.add(lblDepartment);
		
		JLabel lblReportTo = new JLabel("Report To");
		lblReportTo.setBounds(318, 211, 74, 24);
		contentPane.add(lblReportTo);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(318, 281, 74, 24);
		contentPane.add(lblBonus);
		
		JLabel lblSalaryPerMonth = new JLabel("Salary per Month");
		lblSalaryPerMonth.setBounds(318, 246, 115, 24);
		contentPane.add(lblSalaryPerMonth);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setBounds(626, 211, 74, 24);
		contentPane.add(lblPinCode);
		
		JLabel lblHouseNo = new JLabel("House No.");
		lblHouseNo.setBounds(626, 71, 74, 24);
		contentPane.add(lblHouseNo);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(626, 106, 74, 24);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(626, 141, 74, 24);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(626, 176, 74, 24);
		contentPane.add(lblState);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(114, 108, 95, 20);
		contentPane.add(name);
		
		desig = new JTextField();
		desig.setColumns(10);
		desig.setBounds(114, 143, 95, 20);
		contentPane.add(desig);
		
		emp_type = new JTextField();
		emp_type.setColumns(10);
		emp_type.setBounds(114, 178, 95, 20);
		contentPane.add(emp_type);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(114, 213, 95, 20);
		contentPane.add(email);
		
		f_name = new JTextField();
		f_name.setColumns(10);
		f_name.setBounds(114, 248, 95, 20);
		contentPane.add(f_name);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(114, 283, 95, 20);
		contentPane.add(dob);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(114, 318, 95, 20);
		contentPane.add(sex);
		
		b_grp = new JTextField();
		b_grp.setColumns(10);
		b_grp.setBounds(114, 353, 95, 20);
		contentPane.add(b_grp);
		
		nation = new JTextField();
		nation.setColumns(10);
		nation.setBounds(114, 388, 95, 20);
		contentPane.add(nation);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(114, 423, 95, 20);
		contentPane.add(age);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(443, 73, 108, 20);
		contentPane.add(mob);
		
		rec_mode = new JTextField();
		rec_mode.setColumns(10);
		rec_mode.setBounds(443, 108, 108, 20);
		contentPane.add(rec_mode);
		
		j_date = new JTextField();
		j_date.setColumns(10);
		j_date.setBounds(443, 143, 108, 20);
		contentPane.add(j_date);
		
		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(443, 178, 108, 20);
		contentPane.add(dept);
		
		report_to = new JTextField();
		report_to.setColumns(10);
		report_to.setBounds(443, 213, 108, 20);
		contentPane.add(report_to);
		
		bonus = new JTextField();
		bonus.setColumns(10);
		bonus.setBounds(443, 283, 108, 20);
		contentPane.add(bonus);
		
		m_sal = new JTextField();
		m_sal.setColumns(10);
		m_sal.setBounds(443, 248, 108, 20);
		contentPane.add(m_sal);
		
		p_code = new JTextField();
		p_code.setColumns(10);
		p_code.setBounds(729, 213, 95, 20);
		contentPane.add(p_code);
		
		h_no = new JTextField();
		h_no.setColumns(10);
		h_no.setBounds(729, 73, 95, 20);
		contentPane.add(h_no);
		
		st_name = new JTextField();
		st_name.setColumns(10);
		st_name.setBounds(729, 108, 95, 20);
		contentPane.add(st_name);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(729, 143, 95, 20);
		contentPane.add(city);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(729, 178, 95, 20);
		contentPane.add(state);
		
		JLabel lblNewLabel = new JLabel("Personal Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(43, 36, 121, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblJobAndSalary = new JLabel("Job and Salary");
		lblJobAndSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJobAndSalary.setBounds(413, 36, 108, 24);
		contentPane.add(lblJobAndSalary);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(706, 36, 86, 24);
		contentPane.add(lblAddress);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					String sql="Insert into Emp (e_id,name,age,desig,emp_type,email,f_name,dob,sex,b_grp,nation,h_no,st_name,city,state,p_code,mob,rec_mode,join_date,dept,report_to,a_sal,bonus,m_sal) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement pst=connection.prepareStatement(sql);  
				      pst.setString(1, e_id.getText());
				      pst.setString(2, name.getText());
				      pst.setString(3, age.getText());
				      pst.setString(4, desig.getText());
				      pst.setString(5, emp_type.getText());
				      pst.setString(6, email.getText());
				      pst.setString(7, f_name.getText());
				      pst.setString(8, dob.getText());
				      pst.setString(9, sex.getText());
				      pst.setString(10, b_grp.getText());
				      pst.setString(11, nation.getText());
				      pst.setString(12, h_no.getText());
				      pst.setString(13, st_name.getText());
				      pst.setString(14, city.getText());
				      pst.setString(15, state.getText());
				      pst.setString(16, p_code.getText());
				      pst.setString(17, mob.getText());
				      pst.setString(18, rec_mode.getText());
				      pst.setString(19, j_date.getText());
				      pst.setString(20, dept.getText());
				      pst.setString(21, report_to.getText());
				      pst.setString(23, bonus.getText());
				      pst.setString(24, m_sal.getText());
				      pst.execute();
				      JOptionPane.showMessageDialog(null, "Saved");
				      pst.close();
				}
				catch(SQLException e)
                {   logger.error(e);
					int SQLITE_CONSTRAINT_PRIMARYKEY = 19 ; // Exception codes are initialized to Variables
			    int SQLITE_DATATYPE_MISMATCH = 20;
			
			if (e.getErrorCode()== SQLITE_CONSTRAINT_PRIMARYKEY)  // Check for a specific Exception
			{   
				JOptionPane.showMessageDialog(null,"This Employee already Exists");
				
			}
			if (e.getErrorCode()== SQLITE_DATATYPE_MISMATCH)     // Check for a specific Exception
			{
				JOptionPane.showMessageDialog(null,"Please ensure that correct Data has been filled in all fields");
			}
			
				
			   }
				
				
				
				
			}
		});
		btnNewButton.setBounds(641, 399, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f_name.setText("");
				e_id.setText("");
				name.setText("");
				dob.setText("");
				email.setText("");
				emp_type.setText("");
				desig.setText("");
				b_grp.setText("");
				sex.setText("");
				dept.setText("");
				report_to.setText("");
			
				bonus.setText("");
				m_sal.setText("");
				h_no.setText("");
				st_name.setText("");
				city.setText("");
				state.setText("");
				p_code.setText("");
				rec_mode.setText("");
				j_date.setText("");
				age.setText("");
				mob.setText("");
				nation.setText("");
				
				
				
				
				
			}
		});
		btnClear.setBounds(487, 399, 89, 23);
		contentPane.add(btnClear);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.WHITE);
		separator.setBounds(136, 0, 8, 38);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 36, 138, 2);
		contentPane.add(separator_1);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddEmployee.setBounds(10, 0, 234, 35);
		contentPane.add(lblAddEmployee);
	}
}
