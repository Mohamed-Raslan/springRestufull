package com.mohamed.app.services;

import java.util.List;

import com.mohamed.app.entity.Customer;
import com.mohamed.app.response.CustomerResponse;

public interface CustomerDependency {
	
	CustomerResponse addCustomer(Customer customer);
	Customer getCustomerByID(Integer id);
	List<Customer> getCustomers();
	CustomerResponse deleteCustomer(Integer id);
	

}
