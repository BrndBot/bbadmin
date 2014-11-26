package com.brndbot.admin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandGetter {

	BufferedReader reader;
	
	public CommandGetter() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String getInput (String prompt) {
		System.out.print (prompt);
		String response;
		try {
			response = reader.readLine ();
		} catch (Exception e) {
			System.out.println ("Error: " + e.getClass().getName());
			response = "";
		}
		return response;
	}

}
