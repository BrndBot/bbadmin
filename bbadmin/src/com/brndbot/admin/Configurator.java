/**
 *  CONFIDENTIAL
 *  
 *  All rights reserved by Brndbot, Ltd. 2014
 */
package com.brndbot.admin;

/** For a quick and dirty application like this, it's easier
 *  to put configuration information here than to go to the
 *  trouble of a configuration file.
 *  
 *  Resist the temptation to put the database password here.
 *  
 */
public class Configurator {

	private final static String dbURL =
			"brndbot.cs9gq1qnr97h.us-east-1.rds.amazonaws.com:3306/BRNDBOT";
	private final static String dbUser = "brndbot";
	
	public static String getDBUrl () {
		return dbURL;
	}
	
	public static String getDBUser () {
		return dbUser;
	}
}
