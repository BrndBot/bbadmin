/**
 *  CONFIDENTIAL
 *  
 *  All rights reserved by Brndbot, Ltd. 2014
 */
package com.brndbot.admin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;





public class AdminMain {

	static final private String DB_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	private Connection conn;
	private CommandGetter cmd;

	
	public static void main(String[] args) {
		AdminMain admin = new AdminMain();
		admin.init();
		admin.run();
	}

	private void init() {
		cmd = new CommandGetter();
		String pw = cmd.getInput ("Database password: ");
		try {
			connect (pw);
		} catch (Exception e) {
			System.out.println (e.getClass().getName());
			System.out.println (e.getMessage());
			System.exit(-1);
		}
	}
	
	
	private void run() {
		try {
			for (;;) {
				System.out.println ("exit   End program");
				System.out.println ("...   Other commands");
				String resp = cmd.getInput ("> ");
				switch (resp) {
				case "exit":
					return;
				default:
					System.out.println ("To be implemented");
				}
			}
		} finally {
			try {
				conn.close ();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Connect to the database. */
	private boolean connect (String pw) throws Exception {
		Driver driver = (Driver)Class.forName(DB_CLASS_NAME).newInstance();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection (Configurator.getDBUrl(), 
				Configurator.getDBUser(),
				pw);
		conn.setAutoCommit(false);
		return true;
	}
	
	@SuppressWarnings("unused")
	private void commit() throws SQLException
	{
		conn.commit();
	}

	@SuppressWarnings("unused")
	private void rollback()
	{
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Database rollback failed! Error: " + e.getMessage());
		}
	}

}
