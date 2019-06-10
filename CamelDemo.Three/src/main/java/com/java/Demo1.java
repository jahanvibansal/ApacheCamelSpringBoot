package com.java;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class Demo1 {
	public static void main(String[] args) {
		SpringApplication.run(Demo1.class, args);
	}
}
//Content based routing
@Component
class Route1 extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		from("{{from.route}}")
		.choice().
			when(xpath("/order")).to("file:order")
			.when(xpath("/user")).to("file:user")
		.end();
		//.to("{{to.route}}");
		
	}

	
}
//To keep the main thread blocked so that Camel stays up, either include the spring-boot-starter-web dependency, or add camel.springboot.main-run-controller=true to your application.properties or application.yml file. 