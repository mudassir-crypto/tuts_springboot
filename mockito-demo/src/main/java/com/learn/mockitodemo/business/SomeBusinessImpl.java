package com.learn.mockitodemo.business;

public class SomeBusinessImpl {
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	private DataService dataService;
	
	public int findGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int num:data) {
			if(num > greatestValue) {
				greatestValue = num;
			}
		}
		return greatestValue;
	}

	
}

interface DataService {
	int[] retrieveAllData();
}
