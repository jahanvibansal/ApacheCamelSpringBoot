package com.java;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	 static Logger LOG = LoggerFactory.getLogger(Route1.class);
	@Override
	public void configure() throws Exception {
		from("{{from.route}}").
		filter(xpath("/order[@status='U']"))
		.to("file:outgoing");
	}
	
}
