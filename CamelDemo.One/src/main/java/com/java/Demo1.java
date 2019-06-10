package com.java;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.omg.CORBA.CTX_RESTRICT_SCOPE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class Demo1 {
	public static void main(String[] args) {
		SpringApplication.run(Demo1.class, args);
	}
}

@Component
class Route1 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("timer:timer1")
		.to("log:log1");
		
	}

	
}
//To keep the main thread blocked so that Camel stays up, either include the spring-boot-starter-web dependency, or add camel.springboot.main-run-controller=true to your application.properties or application.yml file. 