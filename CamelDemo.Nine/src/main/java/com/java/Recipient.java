package com.java;

import org.apache.camel.RecipientList;
import org.apache.camel.language.xpath.XPath;
import org.springframework.stereotype.Component;
@Component
public class Recipient {
//	/ This annotation tells Camel that the annotated method should be used to generate the list of recipients from the exchange
//	/ This behavior gets invoked, however, only if the class is used with Camel’s bean integration.
	@RecipientList
	  public String[] recipients(String customer) {
	        if (isGoldCustomer(customer)) {
	            return new String[]{"jms:queue:accounting", "jms:queue:production"};
	        } else {
	            return new String[]{"jms:queue:accounting"};
	        }
	    }

	    private boolean isGoldCustomer(String customer) {
	        return customer.equals("honda");
	    }
}
