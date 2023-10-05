package com.learn.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findGreatestFromAllData_basicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,42,5,23});
		assertEquals(42, someBusinessImpl.findGreatestFromAllData());
	}
	
	@Test
	void findGreatestFromAllData_withOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {23});
		assertEquals(23, someBusinessImpl.findGreatestFromAllData());
	}
	
	@Test
	void findGreatestFromAllData_emptyArray(){
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, someBusinessImpl.findGreatestFromAllData());
	}
	
	// If not using the mock annotations - @Mock @InjectMocks @ExtendWith
//	@Test
//	void findGreatestFromAllData_basicScenario() {
//		DataService dataServiceMock = mock(DataService.class);	
//		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {21,32,56});
//		
//		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
//		assertEquals(56, someBusinessImpl.findGreatestFromAllData());
//	}
}
