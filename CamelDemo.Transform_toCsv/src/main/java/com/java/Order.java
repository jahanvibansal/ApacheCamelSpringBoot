package com.java;

import java.util.List;

import lombok.Data;

@Data
public class Order {
	private int id;
	List<Product> products;
	User user;
}
