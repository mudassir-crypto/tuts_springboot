package com.learnspring.examples.a1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring beans are defined in scope
//   Singleton - One obj instance per spring ioc container (NormalClass)
//   Prototype - Many obj instance per spring ioc container (PrototypeClass)


@Component
class NormalClass {
	
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
	
}


@Configuration
@ComponentScan
public class BeanScopesLauncher {	
	
	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(BeanScopesLauncher.class)){
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
		
		}
	}
}
