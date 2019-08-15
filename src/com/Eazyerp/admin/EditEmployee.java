package com.Eazyerp.admin;



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
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.SwingConstants;

public class EditEmployee extends JFrame {
	

	private JPanel contentPane;
	private JTextField emp_sr;
	private JTextField e_id;
	private JTextField name;
	private JTextField email;
	private JTextField emp_type;
	private JTextField desig;
	private JTextField sex;
	private JTextField dept;
	private JTextField report_to;
	private JTextField bonus;
	private JTextField m_sal;
	private JTextField h_no;
	private JTextField st_name;
	private JTextField city;
	private JTextField state;
	private JTextField pin_code;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployee frame = new EditEmployee();
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
	public EditEmployee() {
		final Logger logger = Logger.getLogger(EditEmployee.class);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 832, 487);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		connection=sqliteconn.dbConnector();
		
		JLabel lblEnterEmployeeCode = new JLabel("Enter Employee Code");
		lblEnterEmployeeCode.setBounds(10, 57, 139, 24);
		contentPane.add(lblEnterEmployeeCode);
		
		emp_sr = new JTextField();
		emp_sr.setColumns(10);
		emp_sr.setBounds(137, 59, 64, 20);
		contentPane.add(emp_sr);
		
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
					
					String add17=rs.getString("p_code");
					pin_code.setText(add17);
					
					String add2 =rs.getString("name");
					name.setText(add2);
					
					String add3 =rs.getString("email");
					email.setText(add3);
					
					String add4 =rs.getString("emp_type");
					emp_type.setText(add4);
					
					String add5 =rs.getString("desig");
					desig.setText(add5);
					
					String add6 =rs.getString("sex");
					sex.setText(add6);
					
					String add7 =rs.getString("dept");
					dept.setText(add7);
					
					String add8 =rs.getString("report_to");
					report_to.setText(add8);
					
					String add10 =rs.getString("bonus");
					bonus.setText(add10);
					
					String add11 =rs.getString("m_sal");
					m_sal.setText(add11);
					
					String add12 =rs.getString("h_no");
					h_no.setText(add12);
					
					String add13 =rs.getString("st_name");
					st_name.setText(add13);
					
					String add14 =rs.getString("city");
					city.setText(add14);
					
					String add15 =rs.getString("state");
					state.setText(add15);
					
					String add16 =rs.getString("p_code");
					h_no.setText(add16);
					
					
					rs.close();
					pst.close();
				}
					
                  catch(SQLException e){
                	  logger.error(e);
                	  JOptionPane.showMessageDialog(null, "Employee Does Not Exist. Please Enter Correct ID");
				    }
					
					
				
				
		
			}
		});
		btnNewButton.setBounds(236, 57, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Employee Code");
		label.setBounds(10, 92, 100, 24);
		contentPane.add(label);
		
		e_id = new JTextField();
		e_id.setColumns(10);
		e_id.setBounds(120, 92, 97, 20);
		contentPane.add(e_id);
		
		JLabel label_1 = new JLabel("Full Name");
		label_1.setBounds(10, 127, 74, 24);
		contentPane.add(label_1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(104, 129, 113, 20);
		contentPane.add(name);
		
		JLabel label_2 = new JLabel("E-mail");
		label_2.setBounds(10, 162, 46, 19);
		contentPane.add(label_2);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(104, 160, 113, 20);
		contentPane.add(email);
		
		JLabel label_3 = new JLabel("Type of Employee");
		label_3.setBounds(10, 192, 107, 24);
		contentPane.add(label_3);
		
		emp_type = new JTextField();
		emp_type.setColumns(10);
		emp_type.setBounds(120, 194, 113, 20);
		contentPane.add(emp_type);
		
		JLabel label_4 = new JLabel("Designation");
		label_4.setBounds(10, 227, 61, 19);
		contentPane.add(label_4);
		
		desig = new JTextField();
		desig.setColumns(10);
		desig.setBounds(104, 226, 140, 20);
		contentPane.add(desig);
		
		JLabel label_5 = new JLabel("Sex");
		label_5.setBounds(10, 257, 23, 24);
		contentPane.add(label_5);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(104, 259, 64, 20);
		contentPane.add(sex);
		
		JLabel label_6 = new JLabel("Department");
		label_6.setBounds(10, 292, 61, 24);
		contentPane.add(label_6);
		
		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(104, 290, 140, 20);
		contentPane.add(dept);
		
		JLabel label_7 = new JLabel("Reporting To");
		label_7.setBounds(10, 327, 107, 20);
		contentPane.add(label_7);
		
		report_to = new JTextField();
		report_to.setColumns(10);
		report_to.setBounds(104, 327, 109, 20);
		contentPane.add(report_to);
		
		JLabel label_9 = new JLabel("Bonus");
		label_9.setBounds(290, 127, 107, 24);
		contentPane.add(label_9);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setBounds(290, 91, 107, 24);
		contentPane.add(lblBasicSalary);
		
		bonus = new JTextField();
		bonus.setColumns(10);
		bonus.setBounds(382, 129, 97, 20);
		contentPane.add(bonus);
		
		m_sal = new JTextField();
		m_sal.setColumns(10);
		m_sal.setBounds(382, 94, 97, 20);
		contentPane.add(m_sal);
		
		JLabel label_11 = new JLabel("House No.");
		label_11.setBounds(588, 97, 93, 19);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Street Name");
		label_12.setBounds(588, 132, 93, 19);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("City");
		label_13.setBounds(588, 164, 23, 19);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("State");
		label_14.setBounds(588, 197, 93, 19);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Pin Code");
		label_15.setBounds(588, 229, 42, 20);
		contentPane.add(label_15);
		
		h_no = new JTextField();
		h_no.setColumns(10);
		h_no.setBounds(660, 94, 97, 20);
		contentPane.add(h_no);
		
		st_name = new JTextField();
		st_name.setColumns(10);
		st_name.setBounds(660, 129, 97, 20);
		contentPane.add(st_name);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBounds(660, 161, 97, 20);
		contentPane.add(city);
		
		state = new JTextField();
		state.setColumns(10);
		state.setBounds(660, 194, 97, 20);
		contentPane.add(state);
		
		pin_code = new JTextField();
		pin_code.setColumns(10);
		pin_code.setBounds(660, 226, 97, 20);
		contentPane.add(pin_code);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{  
					  String sql="delete from emp where e_id=?";
					  PreparedStatement pst=connection.prepareStatement(sql);
						pst.setString(1,emp_sr.getText());
						pst.execute();
						
						JOptionPane.showMessageDialog(null,"Employee Deleted");
						pst.close();
						
						connection.close();
						
						
				}catch(SQLException e){
					logger.error(e);
					JOptionPane.showMessageDialog(null, "Please ensure the ID is correct or that the Information is complete");
					
					
				}

				
				
				
			}
		});
		btnDelete.setBounds(427, 377, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSave = new JButton("Update");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	try{
					
					String val1=name.getText();
					String val2=e_id.getText();
					String val3=email.getText();
					String val4=emp_type.getText();
					String val5=desig.getText();
					String val6=dept.getText();
					String val7=sex.getText();
					String val8=h_no.getText();
					String val9=st_name.getText();
					String val10=city.getText();
					String val11=state.getText();
					String val12=pin_code.getText();
					
					String val14=report_to.getText();
				
					String val16=bonus.getText();
					String val17=m_sal.getText();
					String val18=emp_sr.getText();
					
					String sql="update emp set e_id='"+val2+"',name='"+val1+"', email='"+val3+"', " + "emp_type='"+val4+"',desig='"+val5+"',"
							+ "dept='"+val6+"',sex='"+val7+"',h_no='"+val8+"', st_name = '"+val9+"', " + "city = '"+val10+"', state ='"+val11+"',"
									+ " " + "p_code ='"+val12+"', report_to ='"+val14+"',  bonus ='"+val16+"', m_sal ='"+val17+"' where e_id='"+val18+"' "; 
					
					PreparedStatement pst=connection.prepareStatement(sql);
					
					pst.execute();
					
					
					
					
					
				      pst.close();
				      JOptionPane.showMessageDialog(null, "Record Updated");
					
				}catch(Exception e1) {JOptionPane.showMessageDialog(null, e1);
				logger.error(e1);
					
					
				}
			
		
			}
		});
		btnSave.setBounds(290, 377, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				emp_sr.setText("");
				e_id.setText("");
				name.setText("");
				emp_sr.setText("");
				email.setText("");
				emp_type.setText("");
				desig.setText("");
				emp_sr.setText("");
				sex.setText("");
				dept.setText("");
				report_to.setText("");
				
				bonus.setText("");
				m_sal.setText("");
				h_no.setText("");
				st_name.setText("");
				city.setText("");
				state.setText("");
				pin_code.setText("");
				
				
				
				
			}
		});
		btnClear.setBounds(152, 377, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnGoal = new JButton("Goals");
		btnGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpGoals a =new EmpGoals();
				a.setVisible(true);
			}
		});
		btnGoal.setBounds(541, 377, 89, 23);
		contentPane.add(btnGoal);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.WHITE);
		separator.setBounds(217, 2, 8, 44);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 44, 217, 2);
		contentPane.add(separator_1);
		
		JLabel lblViewAndEdit = new JLabel("View and Edit Employee");
		lblViewAndEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblViewAndEdit.setBounds(10, 9, 234, 35);
		contentPane.add(lblViewAndEdit);
		
	
				
			
		
	}
}
