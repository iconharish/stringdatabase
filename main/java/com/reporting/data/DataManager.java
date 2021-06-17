package com.reporting.data;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataManager {
	
	// DataManager.addRecord(items);
	// DataManager.getX();
	private static class DataManagerHelper{
		private static DataManager dataManager = new DataManager();
	}
	
	private DataManager() {}
	
	public static DataManager getInstance() {
		return DataManagerHelper.dataManager;
	}
	
	public void addRecord(String[] items) {
		DataStore.getInstance().addRecord(items);
	}
	
	public Map<String, Set<String>> getDistinctCustomerIdsGroupedByContractId() {
		return DataStore.getInstance().getDistinctCustomerIdsGroupedByContractId();
	}
	
	public Map<String, Set<String>> getDistinctCustomerIdsGroupedByGeoZone() {
		return DataStore.getInstance().getDistinctCustomerIdsGroupedByGeoZone();
	}
	
	public Map<String, List<Double>> getBuildDurationsGroupedByGeoZone() {
		return DataStore.getInstance().getBuildDurationsGroupedByGeoZone();
	}
}
