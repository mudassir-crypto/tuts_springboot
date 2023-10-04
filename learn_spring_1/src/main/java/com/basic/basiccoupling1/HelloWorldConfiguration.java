package com.basic.basiccoupling1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person (String name, int age, Address address) {};
record Address (String lane, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Crypto";
	}
	
	@Bean int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Raju", 22, new Address("Baker lane","NYC"));
	}
	
	@Bean
	public Person personMethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person personParameters(String name, int age, Address address3){ //name, age, address2
		return new Person(name, age, address3);
	}
	
	@Bean
	public Person person2Parameters(String name, int age, Address address){ //name, age, address(will point to the primary))
		return new Person(name, age, address);
	}
	
	@Bean
	public Person person3Parameters(String name, int age, @Qualifier("address2Qualifier") Address address){ //name, age, address(will point to the primary))
		return new Person(name, age, address);
	}
	
	@Bean(name = "address2")
	@Qualifier("address2Qualifier")
	public Address address() {
		return new Address("Baker lane", "NYC");
	}
	
	@Bean(name = "address3")
	@Primary
	public Address address3() {
		return new Address("Morland", "Mumbai");
	}
}
