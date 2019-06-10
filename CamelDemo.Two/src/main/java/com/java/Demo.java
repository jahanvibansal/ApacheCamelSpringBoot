package com.java;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

}
//File transfer
@Component
 class Route1 extends RouteBuilder{
//he noop option tells Camel to leave the source file as is. If you didn’t use this option, the file would be moved.
	@Override
	public void configure() throws Exception {
		from("{{from.route}}")
		.to("{{to.route}}");
		
	}
	
}
//emp: id, name, deptid, dept: id, name