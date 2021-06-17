package com.reporting.utilities;

public class StringParser {
	
	// String lines = StringParser.getLines(String input)
	// String[] items = StringParser.getItems(String line)
	
	public static String[] getLines(String input) {
		if (input == null || input.isEmpty()) {
			return null;
		}
		
		return input.split("\\r\\n");
	}
	
	public static String[] getLineItems(String line) {
		if (line == null || line.isEmpty()) {
			return null;
		}
		
		return line.split(",");
	}

}
