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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class salstruct extends JFrame {
	int a=0,b=0;

	private JPanel contentPane;
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
	private JTextField upsal;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salstruct frame = new salstruct();
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
	public salstruct() {
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
		emp_sr.setBounds(417, 48, 86, 20);
		contentPane.add(emp_sr);
		emp_sr.setColumns(10);
		
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
		
		JLabel lblOvertime = new JLabel("Overtime");
		lblOvertime.setBounds(313, 104, 64, 24);
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
		overtime.setText("0");
		overtime.setColumns(10);
		overtime.setBounds(387, 106, 121, 20);
		contentPane.add(overtime);
		
		med = new JTextField();
		med.setText("0");
		med.setColumns(10);
		med.setBounds(382, 196, 121, 20);
		contentPane.add(med);
		
		bonus = new JTextField();
		bonus.setText("0");
		bonus.setColumns(10);
		bonus.setBounds(382, 228, 121, 20);
		contentPane.add(bonus);
		
		other = new JTextField();
		other.setText("0");
		other.setColumns(10);
		other.setBounds(382, 263, 121, 20);
		contentPane.add(other);
		
		JLabel lblTotalOvertime = new JLabel("Total Overtime");
		lblTotalOvertime.setBounds(569, 104, 86, 24);
		contentPane.add(lblTotalOvertime);
		
		JLabel lblRatePerHour = new JLabel("Rate per Hour");
		lblRatePerHour.setBounds(313, 147, 87, 24);
		contentPane.add(lblRatePerHour);
		
		t_overtime = new JTextField();
		t_overtime.setColumns(10);
		t_overtime.setBounds(665, 106, 121, 20);
		contentPane.add(t_overtime);
		
		ot_rate = new JTextField();
		ot_rate.setText("0");
		ot_rate.setColumns(10);
		ot_rate.setBounds(410, 149, 121, 20);
		contentPane.add(ot_rate);
		
		JLabel lblTotalSalary = new JLabel("Total Salary :");
		lblTotalSalary.setBounds(442, 357, 74, 24);
		contentPane.add(lblTotalSalary);
		
		JLabel t_sal = new JLabel("");
		t_sal.setBounds(385, 362, 61, 19);
		contentPane.add(t_sal);
		
		JLabel up_sallbl = new JLabel("Upgrade Salary by :");
		up_sallbl.setBounds(5, 360, 112, 19);
		contentPane.add(up_sallbl);
		
		JLabel lblEmpId = new JLabel("Emp ID");
		lblEmpId.setBounds(5, 62, 61, 24);
		contentPane.add(lblEmpId);
		
		e_id = new JTextField();
		e_id.setEditable(false);
		e_id.setColumns(10);
		e_id.setBounds(58, 64, 86, 20);
		contentPane.add(e_id);
		
		upsal = new JTextField();
		upsal.setColumns(10);
		upsal.setBounds(104, 391, 61, 20);
		contentPane.add(upsal);
		
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
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
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
		report_to.setBounds(99, 281, 96, 20);
		contentPane.add(report_to);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setColumns(10);
		desig.setBounds(99, 316, 86, 20);
		contentPane.add(desig);
		
		JButton btnUpdate = new JButton("Upgrade");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int msal= Integer.parseInt(m_sal.getText());
				int usal=Integer.parseInt(upsal.getText());
				
				if(a==0 && b==0)
				{JOptionPane.showMessageDialog(null,"Choose a method of update");}
				if(a==1)
				{
					msal=(int) (msal+(msal*usal*0.01));
				}
				if(b==1)
				{
					msal=msal + usal;
				}
				
				String x = String.valueOf(msal);
				m_sal.setText(x);
				
				
				
			}
		});
		btnUpdate.setBounds(5, 390, 89, 23);
		contentPane.add(btnUpdate);
		JCheckBox per = new JCheckBox("%");
		per.setBackground(SystemColor.inactiveCaption);
		JCheckBox amt = new JCheckBox("$");
		amt.setBackground(SystemColor.inactiveCaption);
		amt.setFont(new Font("Tahoma", Font.PLAIN, 9));
		amt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				b=1;a=0;
				per.setSelected(false);
			}
		});
		amt.setBounds(156, 358, 39, 23);
		contentPane.add(amt);
		
		
		
		per.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a=1;b=0;
				amt.setSelected(false);
			}
		});
		per.setBounds(111, 358, 43, 23);
		contentPane.add(per);
		
		
		amt.setBounds(156, 358, 31, 23);
		contentPane.add(amt);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sal= Integer.parseInt(m_sal.getText());
				float ot= Float.parseFloat(overtime.getText());
				float otr= Float.parseFloat(ot_rate.getText());
				
				float hsal= sal/30/6;
				
				float t_ot=(hsal*ot*otr);
				
				float  medi= Integer.parseInt(med.getText());
				float bon= Integer.parseInt(bonus.getText());
				float oth= Integer.parseInt(other.getText());
				
				
				float tsal= medi+bon+oth+t_ot;
				
				String tots = String.valueOf(t_ot);
				t_overtime.setText(tots);
				
				String totsal = String.valueOf(tsal);
				tot_sal.setText(totsal);
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnCalculate.setBounds(622, 358, 89, 23);
		contentPane.add(btnCalculate);
		
		tot_sal = new JTextField();
		tot_sal.setEditable(false);
		tot_sal.setColumns(10);
		tot_sal.setBounds(526, 359, 86, 20);
		contentPane.add(tot_sal);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					 
					 String sql="Insert into salstruct (e_id,name,dob,dept,desig,report_to,m_sal,overtime,rate,t_ot,medical,other,bonus,t_sal) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					 PreparedStatement pst=connection.prepareStatement(sql);
					 pst.setString(1, e_id.getText());
				      pst.setString(2, name.getText());
				      pst.setString(3, dob.getText());
				      pst.setString(4, dept.getText());
				      pst.setString(5, desig.getText());
				      pst.setString(6, report_to.getText());
				      pst.setString(7, m_sal.getText());
				      pst.setString(8, overtime.getText());
				      pst.setString(9, ot_rate.getText());
				      pst.setString(10, t_overtime.getText());
				      pst.setString(11, med.getText());
				      pst.setString(12, other.getText());
				      pst.setString(13, bonus.getText());
				      pst.setString(14, tot_sal.getText());
				      pst.execute();
				      JOptionPane.showMessageDialog(null, "Saved");
				      
					
					
					
					
					
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnSave.setBounds(618, 408, 89, 23);
		contentPane.add(btnSave);
		
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
				upsal.setText("");
				emp_sr.setText("");
				other.setText("");
				
			      
				
				
				
			}
		});
		btnClear.setBounds(357, 408, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnViewSalaryTable = new JButton("View Salary Table");
		btnViewSalaryTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewsaltab v1= new viewsaltab();
				v1.setVisible(true);
				
				
			}
		});
		btnViewSalaryTable.setBounds(457, 408, 139, 23);
		contentPane.add(btnViewSalaryTable);
		
		JLabel lblUnpaidLeaves = new JLabel("Unpaid Leaves");
		lblUnpaidLeaves.setBounds(295, 296, 84, 24);
		contentPane.add(lblUnpaidLeaves);
		
		unpaid_leave = new JTextField();
		unpaid_leave.setText("0");
		unpaid_leave.setColumns(10);
		unpaid_leave.setBounds(382, 298, 121, 20);
		contentPane.add(unpaid_leave);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String val1=e_id.getText();
					String val2=name.getText();
					String val3=dob.getText();
					String val4=dept.getText();
					String val5=desig.getText();
					String val6=m_sal.getText();
					String val7=report_to.getText();
					String val8=overtime.getText();
					String val9=ot_rate.getText();
					String val10=med.getText();
					String val11=bonus.getText();
					String val12=other.getText();
					String val13=t_overtime.getText();
					String val14=tot_sal.getText();
					
					
					
					String sql="update salstruct set name='"+val2+"', dob='"+val3+"', " + "dept='"+val4+"',desig='"+val5+"',"
							+ "m_sal='"+val6+"',report_to='"+val7+"',overtime='"+val8+"', rate = '"+val9+"', " + "medical= '"+val10+"', bonus ='"+val11+"',"
									+ " " + "other ='"+val12+"', t_ot ='"+val13+"',  t_sal ='"+val14+"' where e_id='"+val1+"' "; 
					
                      PreparedStatement pst=connection.prepareStatement(sql);
					
					  pst.execute();
					  pst.close();
					  
					  String sql1="update emp set m_sal='"+val6+"', bonus='"+val11+"' where e_id='"+val1+"' ";
					
					  PreparedStatement pst1=connection.prepareStatement(sql1);
						
						pst1.execute();
						
						
						
						
						
					      pst1.close();
					      JOptionPane.showMessageDialog(null, "Record Updated");
					
					
				}catch(Exception e6)
				{
					JOptionPane.showMessageDialog(null, e6);
				}
				
				
				
				
			}
		});
		btnUpdate_1.setBounds(637, 243, 89, 23);
		contentPane.add(btnUpdate_1);
		
		
	}
}
