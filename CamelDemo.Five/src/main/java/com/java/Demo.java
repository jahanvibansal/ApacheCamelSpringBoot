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
	 @Autowired MyProcessor processor;
	@Override
	public void configure() throws Exception {
		from("{{from.route}}").to("jms:queue:incomingOrders");
		from("jms:queue:incomingOrders")
		.choice().
			when(header("CamelFileName").endsWith(".csv")).to("jms:queue:csvOrder")
			.when(header("CamelFileName").endsWith(".xml")).to("jms:queue:xmlOrder")
			.otherwise().to("jms:badOrders").stop()
			.end().to("jms:queue:processedOrders");
		//badOrders not sent to processed orders, rest are
	}
	
}
@Component
class MyProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		String name=(String) exchange.getIn().getHeader("CamelFileName");
		exchange.getOut().setBody(name);
	}
	
}