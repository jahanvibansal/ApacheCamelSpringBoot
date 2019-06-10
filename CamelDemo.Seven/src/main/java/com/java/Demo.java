package com.java;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

}
//Multicasting: eg.send a copy of a message to several destinations for processing sequentially.
@Component
 class Route1 extends RouteBuilder{
	 static Logger LOG = LoggerFactory.getLogger(Route1.class);
	@Override
	public void configure() throws Exception {
		from("{{from.route}}").
		multicast().to("jms:queue:carservice","jms:queue:flightservice");
	}
	
}
