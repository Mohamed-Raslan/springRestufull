package com.mohamed.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mohamed.app.dao.CustomerDao;
import com.mohamed.app.dao.CustomerDaoDependency;
import com.mohamed.app.entity.Customer;
import com.mohamed.app.response.CustomerResponse;
@Transactional
@Service
public class CustomerService implements CustomerDependency {

	@Autowired 
	@Qualifier("customerDao")
	private CustomerDaoDependency customerDao;
	
	@Override
	public CustomerResponse addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
		
		
	}

	@Override
	public Customer getCustomerByID(Integer id) {
		
		return customerDao.getCustomerbyID(id);
	}

	@Override
	public List<Customer> getCustomers() {
		
		return customerDao.getCustomers();
	}

	@Override
	public CustomerResponse deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.deleteCustomer(id);
	}

	
}
