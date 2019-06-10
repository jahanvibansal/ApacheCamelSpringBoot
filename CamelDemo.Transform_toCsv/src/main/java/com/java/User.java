package com.java;

import lombok.Data;

@Data
public class User {
	int id;
	Payment payment;
}
@Data
class Payment{
	String type;
	String number;
}