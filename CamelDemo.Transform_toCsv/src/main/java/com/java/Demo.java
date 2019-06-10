package com.java;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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
// wire tap is a fixed recipient list that sends a copy of a message traveling from a source to a destination to a secondary destination.
@Component
 class Route1 extends RouteBuilder{
	 static Logger LOG = LoggerFactory.getLogger(Route1.class);
	@Override
	public void configure() throws Exception {
		from("file:incoming").to("jms:queue:order");
		from("jms:queue:order").process(new MyProcessor()).wireTap("jms:queue:audit").
		multicast().parallelProcessing().to("jms:queue:carservice","jms:queue:flightservice");
	}
	
}
class MyProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Order order= exchange.getIn().getBody(Order.class);
		exchange.getIn().setBody(order);
		System.out.println(exchange.getIn());
	}
	
}