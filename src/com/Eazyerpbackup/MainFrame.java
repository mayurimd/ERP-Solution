package com.Eazyerpbackup;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		getContentPane().setBackground(SystemColor.inactiveCaption);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 478);
		connection=sqliteconn.dbConnector();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Employee");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAddNew = new JMenuItem("Add New");
		mntmAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Addemp a= new Addemp();
				a.setVisible(true);
				
				
			}
		});
		mnNewMenu.add(mntmAddNew);
		
		JMenuItem mntmEditPersonalDetails = new JMenuItem("View and Edit");
		mntmEditPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				editemp b = new editemp();
				b.setVisible(true);
			}
		});
		mnNewMenu.add(mntmEditPersonalDetails);
		
		JMenu mnNewMenu_1 = new JMenu("Payroll");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmSalaryStructure = new JMenuItem("Salary Structure");
		mntmSalaryStructure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				salstruct c= new salstruct();
				c.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmSalaryStructure);
		
		JMenuItem mntmLeaves = new JMenuItem("Leaves");
		mnNewMenu_1.add(mntmLeaves);
		
		JMenu mnNewMenu_2 = new JMenu("Recruitment");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmRegister = new JMenuItem("Register");
		mntmRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emprec d= new emprec();
				d.setVisible(true);
				
			}
		});
		mnNewMenu_2.add(mntmRegister);
		
		JMenuItem mntmRecruitmentDetail = new JMenuItem("Recruitment Detail");
		mntmRecruitmentDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				recdet a= new recdet();
				a.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmRecruitmentDetail);
		
		JMenu mnNewMenu_3 = new JMenu("Appraisals");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Assess Empoloyee");
		mnNewMenu_3.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_4 = new JMenu("Training");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmEmployeeTraining = new JMenuItem("Employee Training");
		mntmEmployeeTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				emptrain v1= new emptrain();
				v1.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmEmployeeTraining);
		
		JMenuItem mntmTrainingEvents = new JMenuItem("Training Events");
		mntmTrainingEvents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				train_event a=new train_event();
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
						
					
					
					
					
					
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				
				
				
			}
		});
		mnReports.add(mntmCompanyPayroll);
		
		JMenuItem mntmEmployeePayslip = new JMenuItem("Employee Payslip");
		mntmEmployeePayslip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String i=null;
					i=JOptionPane.showInputDialog("Please input Employee ID");
					JasperDesign jd=JRXmlLoader.load("C:\\Users\\SHISHIR\\Documents\\Software Development\\Reports\\payslip1.jrxml");
					String sql="select * from salstruct where e_id='"+i+"'";
					
					JRDesignQuery nq=new JRDesignQuery();
					nq.setText(sql);
					jd.setQuery(nq);
					JasperReport jr=JasperCompileManager.compileReport(jd);
					JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
					JasperViewer.viewReport(jp);
					
					
					
					
					
					
					
					
				}catch(Exception e3)
				{
					JOptionPane.showMessageDialog(null, e3);
				}
				
			}
		});
		mnReports.add(mntmEmployeePayslip);
		
		JMenuItem mntmEmployeeProfile = new JMenuItem("Employee Profile");
		mnReports.add(mntmEmployeeProfile);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Company Employees");
		mnReports.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Recruitment Detail");
		mnReports.add(mntmNewMenuItem_2);
		
		JMenuItem mntmEmpAssessment = new JMenuItem("Emp. Assessment");
		mnReports.add(mntmEmpAssessment);
		
		JMenuItem mntmTrainingEvents_1 = new JMenuItem("Training Events");
		mnReports.add(mntmTrainingEvents_1);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
