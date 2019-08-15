package com.Eazyerpbackup;
import java.sql.*;
import javax.swing.*;



public class sqliteconn {
	Connection conn=null;

	public static Connection dbConnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\SHISHIR\\Documents\\Software Development\\empdata.sqlite");
			
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}