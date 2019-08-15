package com.Eazyerp.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Eazyerp.conn.Login;

import com.Eazyerp.conn.sqliteconn;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MainFrame extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Eazy ERP");
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("You are logged in as an Administrator");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 388, 263, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblYourEmployeeId = new JLabel("Your Employee ID is :");
		lblYourEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourEmployeeId.setBounds(283, 388, 156, 19);
		getContentPane().add(lblYourEmployeeId);
		
		JLabel eidlbl = new JLabel("");
		eidlbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eidlbl.setBounds(435, 388, 56, 19);
		getContentPane().add(eidlbl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 478);
		eidlbl.setText(Login.t);
		connection=sqliteconn.dbConnector();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmEditPersonalDetails = new JMenuItem("View and Edit");
		mntmEditPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				EditEmployee b = new EditEmployee();
				b.setVisible(true);
			}
		});
		mnNewMenu.add(mntmEditPersonalDetails);
		
		JMenuItem mntmAddNew = new JMenuItem("Add New");
		mntmAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				AddEmployee a= new AddEmployee();
				a.setVisible(true);
				
				
			}
		});
		mnNewMenu.add(mntmAddNew);
		
		JMenu mnNewMenu_1 = new JMenu("Payroll");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmSalaryStructure = new JMenuItem("Salary Structure");
		mntmSalaryStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalaryStructure c= new SalaryStructure();
				c.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmSalaryStructure);
		
		JMenu mnNewMenu_2 = new JMenu("Recruitment");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpRegister d= new EmpRegister();
				d.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmRegister);
		
		JMenuItem mntmRecruitmentDetail = new JMenuItem("Recruitment Detail");
		mntmRecruitmentDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RecruitmentDetails a= new RecruitmentDetails();
				a.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmRecruitmentDetail);
		
		JMenu mnNewMenu_3 = new JMenu("Appraisals");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Assess Empoloyee");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EmpAsssement f = new EmpAsssement();
				f.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Training");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmEmployeeTraining = new JMenuItem("Employee Training");
		mntmEmployeeTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmpTraining v1= new EmpTraining();
				v1.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmEmployeeTraining);
		
		JMenuItem mntmTrainingEvents = new JMenuItem("Training Events");
		mntmTrainingEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingEvent a=new TrainingEvent();
				a.setVisible(true);
				
			}
		});
		mnNewMenu_4.add(mntmTrainingEvents);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmCompanyPayroll = new JMenuItem("Company Payroll");
		mntmCompanyPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String report="C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\Company Payroll.jrxml";
					JasperReport jr=JasperCompileManager.compileReport(report);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
						
					
					
					
					
					
				}catch(JRException jre2)
				{
					JOptionPane.showMessageDialog(null, jre2);
				}
				
				
				
				
			}
		});
		mnReports.add(mntmCompanyPayroll);
		
		JMenuItem mntmEmployeePayslip = new JMenuItem("Employee Payslip");
		mntmEmployeePayslip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					String i=JOptionPane.showInputDialog("Please input Employee ID");
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\payslip1.jrxml");
					String sql="select * from salstruct where e_id='"+i+"'";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(JRException jre1)
				{
					JOptionPane.showMessageDialog(null, "Please ensure the Employee Exists and that the ID is Correct");
				}
				
			}
		});
		mnReports.add(mntmEmployeePayslip);
		
		JMenuItem mntmEmployeeProfile = new JMenuItem("Employee Profile");
		mntmEmployeeProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					String i=JOptionPane.showInputDialog("Please input Employee ID");
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\Emp_profile1.jrxml");
					String sql="select * from Emp where e_id='"+i+"'";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(JRException jre3)
				{
					JOptionPane.showMessageDialog(null, "Please ensure the Employee Exists and that the ID is Correct");
				}
				
				
			}
		});
		mnReports.add(mntmEmployeeProfile);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Recruitment Detail");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\Rec_details.jrxml");
					String sql="select * from emprec order by age";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(JRException jre4)
				{
					JOptionPane.showMessageDialog(null, "Please ensure the Employee Exists and that the ID is Correct");
				}
				
			}
		});
		mnReports.add(mntmNewMenuItem_2);
		
		JMenuItem mntmEmpAssessment = new JMenuItem("Emp. Assessment");
		mntmEmpAssessment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					String i=JOptionPane.showInputDialog("Please input Employee ID");
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\Emp_assess1.jrxml");
					String sql="select * from Emp where e_id='"+i+"'";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(JRException jre5)
				{
					JOptionPane.showMessageDialog(null, "Please ensure the Employee Exists and that the ID is Correct");
				}
				
				
			}
		});
		mnReports.add(mntmEmpAssessment);
		
		JMenuItem mntmTrainingEvents_1 = new JMenuItem("Training Events");
		mntmTrainingEvents_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\training.jrxml");
					String sql="select * from training order by event_id";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(JRException jre6)
				{
					JOptionPane.showMessageDialog(null, "Please ensure the Employee Exists and that the ID is Correct");
				}
				
				
				
			}
		});
		mnReports.add(mntmTrainingEvents_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
