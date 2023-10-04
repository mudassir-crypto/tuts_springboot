package com.basic.basiccoupling1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	
	public static void main(String[] args) {
		// 1.Launch spring context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// 2.configure the thing which we want spring to manage - @Configuration (HelloWorldConfig)
		
		// 3. Retrieving beans managed by spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address2"));
		System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean("personMethodCall"));
		System.out.println(context.getBean("personParameters"));
		System.out.println(context.getBean("person2Parameters"));
		System.out.println(context.getBean("person3Parameters"));
		
		// List all beans
		//System.out.println("Listing Beans: ");
//		for(String x:context.getBeanDefinitionNames()) {
//			System.out.println(x);
//		}
//		Arrays.stream(context.getBeanDefinitionNames())
//			.forEach(System.out::println);

		
		context.close();
	}
	
}
