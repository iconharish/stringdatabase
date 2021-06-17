package com.reporting.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.reporting.data.DataManager;

public class Report {
	List<String> dataForCustomerIdCountGroupedByContractId = new ArrayList<>();
	List<String> dataForCustomerIdCountGroupedByGeoZone = new ArrayList<>();
	List<String> dataForAvgBuildDurationGroupedByGeoZone = new ArrayList<>();
	List<String> dataForCustomerIdsGroupedByGeoZone = new ArrayList<>();
	
	public Report generateReportDataFromCustomerIdsGroupedByContractId() {
		Map<String, Set<String>> distinctCustomerIdsGroupedByContractId = DataManager.getInstance().getDistinctCustomerIdsGroupedByContractId();
		
		Set<String> keys = distinctCustomerIdsGroupedByContractId.keySet();
		for (String key : keys) {
			dataForCustomerIdCountGroupedByContractId.add(key + ": " + distinctCustomerIdsGroupedByContractId.get(key).size());
		}
		return this;
	}
	
	public Report generateReportDataFromCustomerIdsGroupedByGeoZone() {
		Map<String, Set<String>> distinctCustomerIdsGroupedByGeoZone = DataManager.getInstance().getDistinctCustomerIdsGroupedByGeoZone();
		
		Set<String> keys = distinctCustomerIdsGroupedByGeoZone.keySet();
		for (String key : keys) {
			dataForCustomerIdCountGroupedByGeoZone.add(key + ": " + distinctCustomerIdsGroupedByGeoZone.get(key).size());
			dataForCustomerIdsGroupedByGeoZone.add(key + ": " + distinctCustomerIdsGroupedByGeoZone.get(key));
		}
		
		return this;
	}
	
	public Report generateReportDataFromBuildDurationsGroupedByGeoZone() {
		Map<String, List<Double>> buildDurationsGroupedByGeoZone = DataManager.getInstance().getBuildDurationsGroupedByGeoZone();
		
		Set<String> keys = buildDurationsGroupedByGeoZone.keySet();
		for(String key : keys) {
			List<Double> buildDurationsForGeoZone = buildDurationsGroupedByGeoZone.get(key);
			double totalBuildDuration = 0.0;
			for(double buildDuration : buildDurationsForGeoZone) {
				totalBuildDuration += buildDuration;
			}
			
			dataForAvgBuildDurationGroupedByGeoZone.add(String.format(key + ": %.0fs", totalBuildDuration/buildDurationsForGeoZone.size()));
		}
		return this;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("The number of unique customerId for each contractId:\n");
		for (String customerIdCountGroupedByContractId: dataForCustomerIdCountGroupedByContractId) {
			sb.append(customerIdCountGroupedByContractId + "\n");
		}
		
		sb.append("The number of unique customerId for each geozone:\n");
		for (String customerIdCountGroupedByGeoZone: dataForCustomerIdCountGroupedByGeoZone) {
			sb.append(customerIdCountGroupedByGeoZone + "\n");
		}
		
		
		sb.append("The average buildduration for each geozone:\n");
		for (String avgBuildDurationGroupedByGeoZone: dataForAvgBuildDurationGroupedByGeoZone) {
			sb.append(avgBuildDurationGroupedByGeoZone + "\n");
		}
		
		sb.append("The list of unique customerId for each geozone:\n");
		for (String customerIdsGroupedByGeoZone: dataForCustomerIdsGroupedByGeoZone) {
			sb.append(customerIdsGroupedByGeoZone + "\n");
		}
		
		return sb.toString();
	}
}
