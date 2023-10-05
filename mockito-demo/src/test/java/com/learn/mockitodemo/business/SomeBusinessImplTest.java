package com.learn.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

	@Test
	void findGreatestFromAllData_basicScenario() {
		DataService dataServiceStub = new DataServiceStub1();
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = someBusinessImpl.findGreatestFromAllData();
		assertEquals(42, result);
	}
	
	@Test
	void findGreatestFromAllData_withOneValue() {
		DataService dataServiceStub = new DataServiceStub2();
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = someBusinessImpl.findGreatestFromAllData();
		assertEquals(23, result);
	}

}

class DataServiceStub1 implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {1,42,5,23};
	}
}

class DataServiceStub2 implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {23};
	}
}
