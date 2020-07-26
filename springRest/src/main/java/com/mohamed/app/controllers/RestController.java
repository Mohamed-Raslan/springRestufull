package com.mohamed.app.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mohamed.app.entity.Customer;
import com.mohamed.app.requests.CustomerRequest;
import com.mohamed.app.response.CustomerResponse;
import com.mohamed.app.services.CustomerDependency;
import com.mohamed.app.services.CustomerService;



@RequestMapping(value = "/api")
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	@Qualifier("customerService")
	private CustomerDependency customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public CustomerResponse addStudent(@RequestBody CustomerRequest request) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(request, customer);
		return customerService.addCustomer(customer);
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
	public Customer getCustomerByID(@PathVariable int id) {
		
		return customerService.getCustomerByID(id);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}
	
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
	public CustomerResponse deleteCustomer(@PathVariable int id) {
		
		return customerService.deleteCustomer(id);
	}
	@RequestMapping(value = "/customers", method = RequestMethod.PUT)
	public CustomerResponse updateCustomer(@RequestBody CustomerRequest request) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(request, customer);
		return customerService.addCustomer(customer);
	}
}
