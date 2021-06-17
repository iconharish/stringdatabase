package com.reporting.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataStore {
	
	Map<String, Set<String>> distinctCustomerIdsGroupedByContractId = new HashMap<>();
	Map<String, Set<String>> distinctCustomerIdsGroupedByGeoZone = new HashMap<>();
	Map<String, List<Double>> buildDurationsGroupedByGeoZone = new HashMap<>();
	
	private static class DataStoreHelper {
		private static DataStore dataStore = new DataStore();
	}
	
	private DataStore() {
		
	}
	
	public static DataStore getInstance() {
		return DataStoreHelper.dataStore;
	}
	
	public void addRecord(String[] items) {
		String customerId = items[0].trim();
		String contractId = items[1].trim();
		String geoZone = items[2].trim();
		String buildDuration = items[5].trim();
		
		Set<String> customoerIdsForContractId = distinctCustomerIdsGroupedByContractId.get(contractId);
		if (customoerIdsForContractId == null) {
			customoerIdsForContractId = new HashSet<>();
			distinctCustomerIdsGroupedByContractId.put(contractId, customoerIdsForContractId);
		}
		customoerIdsForContractId.add(customerId);
		
		Set<String> customoerIdsForGeoZone = distinctCustomerIdsGroupedByGeoZone.get(geoZone);
		if (customoerIdsForGeoZone == null) {
			customoerIdsForGeoZone = new HashSet<>();
			distinctCustomerIdsGroupedByGeoZone.put(geoZone, customoerIdsForGeoZone);
		}
		customoerIdsForGeoZone.add(customerId);
		
		List<Double> buildDurationsForGeoZone = buildDurationsGroupedByGeoZone.get(geoZone);
		if (buildDurationsForGeoZone == null) {
			buildDurationsForGeoZone = new ArrayList<>();
			buildDurationsGroupedByGeoZone.put(geoZone, buildDurationsForGeoZone);
		}
		buildDurationsForGeoZone.add(Double.parseDouble(buildDuration.substring(0, buildDuration.length()-1)));
	}

	public Map<String, Set<String>> getDistinctCustomerIdsGroupedByContractId() {
		return distinctCustomerIdsGroupedByContractId;
	}

	public Map<String, Set<String>> getDistinctCustomerIdsGroupedByGeoZone() {
		return distinctCustomerIdsGroupedByGeoZone;
	}

	public Map<String, List<Double>> getBuildDurationsGroupedByGeoZone() {
		return buildDurationsGroupedByGeoZone;
	}
	
}
