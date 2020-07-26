package com.mohamed.app.dao;

import java.rmi.StubNotFoundException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.mohamed.app.entity.Customer;
import com.mohamed.app.exceptions.StudentNotFound;
import com.mohamed.app.response.CustomerResponse;


@Repository
public class CustomerDao implements CustomerDaoDependency {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session  = sessionFactory.getCurrentSession();
		List<Customer> customers  = (List<Customer>) session
				                    .createQuery("from Customer")
				                    .list();
		return customers;
	}

	@Override
	public Customer getCustomerbyID(Integer id) {
		
		Customer customer = sessionFactory
				           .getCurrentSession()
				           .get(Customer.class, id);
		
		if(customer == null)
			throw new StudentNotFound("هذا العميل غير موجود");
		
		return customer;
		
	}

	@Override
	public CustomerResponse addCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		if(customer.getId()!=null) {
		    Customer customerentity = session.get(Customer.class, customer.getId());
			if(customerentity==null) 
				throw new StudentNotFound("لاكمال عمليه التعديل هذا العميل غير متواجد ");
			
			session.merge(customer);
			return new CustomerResponse(HttpStatus.ACCEPTED.value(),"لقد تم التعديل بنجاح",System.currentTimeMillis());		
		}

			session.saveOrUpdate(customer);
			return new CustomerResponse(HttpStatus.ACCEPTED.value(),"لقد تم الحفظ بنجاح",System.currentTimeMillis());
		
		
	}

	@Override
	public CustomerResponse deleteCustomer(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		if(customer==null)
			throw new StudentNotFound("هذا العميل غير متواجد ");
		
		session.delete(customer);
		return new CustomerResponse(HttpStatus.ACCEPTED.value(),"لقد الحذف بنجاح",System.currentTimeMillis());

		
	}

}
