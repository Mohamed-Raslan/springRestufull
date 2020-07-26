package com.mohamed.app.dao;

import java.util.List;

import com.mohamed.app.entity.Customer;
import com.mohamed.app.response.CustomerResponse;

public interface CustomerDaoDependency {

	List<Customer> getCustomers();
	Customer getCustomerbyID(Integer id);
	CustomerResponse addCustomer(Customer customer);
	CustomerResponse deleteCustomer(Integer id);
}
