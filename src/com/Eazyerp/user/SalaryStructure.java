package com.Eazyerp.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.Eazyerp.conn.Login;
import com.Eazyerp.conn.sqliteconn;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SalaryStructure extends JFrame {

	private JPanel contentPane;
int a=0;int b=0;
	private JTextField emp_sr;
	private JTextField dob;
	private JTextField dept;
	private JTable table;
	private JTextField m_sal;
	private JTextField overtime;
	private JTextField med;
	private JTextField bonus;
	private JTextField other;
	private JTextField t_overtime;
	private JTextField ot_rate;
	private JTextField e_id;
	private JTextField name;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalaryStructure frame = new SalaryStructure();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection=null;
private JTextField report_to;
private JTextField desig;
private JTextField tot_sal;
private JTextField unpaid_leave;
	/**
	 * Create the frame.
	 */
	public SalaryStructure() {
		final Logger logger = Logger.getLogger(SalaryStructure.class);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 501);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblSalaryStructure = new JLabel("Salary Structure");
		lblSalaryStructure.setBounds(5, 5, 215, 30);
		lblSalaryStructure.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSalaryStructure);
		
		JLabel label = new JLabel("Enter Employee Code");
		label.setBounds(240, 46, 139, 24);
		contentPane.add(label);
		
		emp_sr = new JTextField();
		emp_sr.setEditable(false);
		emp_sr.setBounds(417, 48, 86, 20);
		contentPane.add(emp_sr);
		emp_sr.setColumns(10);
		emp_sr.setText(Login.t);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(5, 104, 43, 24);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(58, 106, 121, 20);
		contentPane.add(name);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(5, 147, 84, 24);
		contentPane.add(lblDateOfBirth);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setColumns(10);
		dob.setBounds(99, 149, 121, 20);
		contentPane.add(dob);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(5, 194, 84, 24);
		contentPane.add(lblDepartment);
		
		dept = new JTextField();
		dept.setEditable(false);
		dept.setColumns(10);
		dept.setBounds(99, 196, 121, 20);
		contentPane.add(dept);
		
		table = new JTable();
		table.setBounds(587, 332, -210, -184);
		contentPane.add(table);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setBounds(5, 241, 84, 24);
		contentPane.add(lblBasicSalary);
		
		m_sal = new JTextField();
		m_sal.setEditable(false);
		m_sal.setColumns(10);
		m_sal.setBounds(99, 243, 121, 20);
		contentPane.add(m_sal);
		
		JLabel lblOvertime = new JLabel("Overtime (in Hours )");
		lblOvertime.setBounds(270, 104, 109, 24);
		contentPane.add(lblOvertime);
		
		JLabel lblMedical = new JLabel("Medical");
		lblMedical.setBounds(313, 194, 66, 24);
		contentPane.add(lblMedical);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setBounds(313, 226, 64, 24);
		contentPane.add(lblBonus);
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setBounds(313, 261, 66, 24);
		contentPane.add(lblOther);
		
		overtime = new JTextField();
		overtime.setEditable(false);
		overtime.setText("0");
		overtime.setColumns(10);
		overtime.setBounds(387, 106, 121, 20);
		contentPane.add(overtime);
		
		med = new JTextField();
		med.setEditable(false);
		med.setText("0");
		med.setColumns(10);
		med.setBounds(382, 196, 121, 20);
		contentPane.add(med);
		
		bonus = new JTextField();
		bonus.setEditable(false);
		bonus.setText("0");
		bonus.setColumns(10);
		bonus.setBounds(382, 228, 121, 20);
		contentPane.add(bonus);
		
		other = new JTextField();
		other.setEditable(false);
		other.setText("0");
		other.setColumns(10);
		other.setBounds(382, 263, 121, 20);
		contentPane.add(other);
		
		JLabel lblTotalOvertime = new JLabel("Total Overtime");
		lblTotalOvertime.setBounds(569, 104, 109, 24);
		contentPane.add(lblTotalOvertime);
		
		JLabel lblRatePerHour = new JLabel("Rate per Hour");
		lblRatePerHour.setBounds(313, 147, 87, 24);
		contentPane.add(lblRatePerHour);
		
		t_overtime = new JTextField();
		t_overtime.setEditable(false);
		t_overtime.setColumns(10);
		t_overtime.setBounds(665, 106, 121, 20);
		contentPane.add(t_overtime);
		
		ot_rate = new JTextField();
		ot_rate.setEditable(false);
		ot_rate.setText("0");
		ot_rate.setColumns(10);
		ot_rate.setBounds(410, 149, 121, 20);
		contentPane.add(ot_rate);
		
		JLabel lblTotalSalary = new JLabel("Total Salary :");
		lblTotalSalary.setBounds(569, 194, 98, 24);
		contentPane.add(lblTotalSalary);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		lblEmpId.setBounds(5, 62, 61, 24);
		contentPane.add(lblEmpId);
		
		e_id = new JTextField();
		e_id.setEditable(false);
		e_id.setColumns(10);
		e_id.setBounds(58, 64, 86, 20);
		contentPane.add(e_id);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{ 
					String sql = "select * from emp where e_id=?";
					PreparedStatement pst=connection.prepareStatement(sql);
					pst.setString(1,emp_sr.getText());
					ResultSet rs=pst.executeQuery();
					rs=pst.executeQuery();
					
					String add1 =rs.getString("e_id");
					e_id.setText(add1);
					
					String add2 =rs.getString("name");
					name.setText(add2);
					
					String add5 =rs.getString("desig");
					desig.setText(add5);
					
					String add7 =rs.getString("dept");
					dept.setText(add7);
					
					String add11 =rs.getString("m_sal");
					m_sal.setText(add11);
					
					String add8 =rs.getString("report_to");
					report_to.setText(add8);
					
					String add10 =rs.getString("bonus");
					bonus.setText(add10);
					
					String add15 =rs.getString("dob");
					dob.setText(add15);
					
					rs.close();
					pst.close();
					
				}catch(SQLException e){
					logger.error(e);
              	  JOptionPane.showMessageDialog(null, "Employee Does Not Exist. Please Enter Correct ID");
				    }
				
					
					
					
				
				
				
				
			}
		});
		btnNewButton.setBounds(530, 47, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel repot_to = new JLabel("Reporting to");
		repot_to.setBounds(5, 279, 84, 24);
		contentPane.add(repot_to);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(5, 314, 84, 24);
		contentPane.add(lblDesignation);
		
		report_to = new JTextField();
		report_to.setEditable(false);
		report_to.setColumns(10);
		report_to.setBounds(99, 281, 121, 20);
		contentPane.add(report_to);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setColumns(10);
		desig.setBounds(99, 316, 121, 20);
		contentPane.add(desig);
		
		tot_sal = new JTextField();
		tot_sal.setEditable(false);
		tot_sal.setColumns(10);
		tot_sal.setBounds(665, 196, 86, 20);
		contentPane.add(tot_sal);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				e_id.setText("");
				name.setText("");
				desig.setText("");
				dept.setText("");
				
				dob.setText("");
				m_sal.setText("");
				report_to.setText("");
				overtime.setText("");
				ot_rate.setText("");
				tot_sal.setText("");
				t_overtime.setText("");
				med.setText("");
				bonus.setText("");
				
				emp_sr.setText("");
				other.setText("");
				
			      
				
				
				
			}
		});
		btnClear.setBounds(648, 47, 89, 23);
		contentPane.add(btnClear);
		
		report_to = new JTextField();
		report_to.setEditable(false);
		report_to.setColumns(10);
		report_to.setBounds(99, 281, 121, 20);
		contentPane.add(report_to);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setColumns(10);
		desig.setBounds(99, 316, 121, 20);
		contentPane.add(desig);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 40, 187, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(187, 0, 10, 40);
		contentPane.add(separator_1);
		
		
	}
}
