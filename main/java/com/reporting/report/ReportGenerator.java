package com.reporting.report;

import com.reporting.data.DataManager;
import com.reporting.utilities.StringParser;

public class ReportGenerator {
	
	private ReportGenerator() {}
	
	private static class ReportGeneratorHelper {
		private static ReportGenerator instance = new ReportGenerator();
	}
	
	public static ReportGenerator getInstance() {
		return ReportGeneratorHelper.instance;
	}
	
	public void insertData(String input) {
		String[] lines = StringParser.getLines(input);
		if (lines == null) {
			System.out.println("Data insertion failed, as input is either null or blank");
		}
		
		for (String line : lines) {
			String[] items = StringParser.getLineItems(line);
			if (items == null) {
				System.out.println("One line is either null or blank. Not adding that line.");
				continue;
			} else if (items.length != 6) {
				System.out.println("One line does not contain all the required columns. Not adding that line.");
				continue;
			}
			
			DataManager.getInstance().addRecord(items);
		}
	}
	
	public Report generateRopert() {
		return new Report().generateReportDataFromCustomerIdsGroupedByContractId()
		.generateReportDataFromCustomerIdsGroupedByGeoZone()
		.generateReportDataFromBuildDurationsGroupedByGeoZone();
	}
}