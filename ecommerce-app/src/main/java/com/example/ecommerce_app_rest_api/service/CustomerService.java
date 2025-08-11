package com.example.ecommerce_app_rest_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app_rest_api.model.Customer;
import com.example.ecommerce_app_rest_api.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer c = customerRepository.save(customer);
		return c;
		
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
		customerRepository.deleteById(id);
		
	}

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName(name);
	}

	public Customer getCustomerByNameAndEmail(String name, String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByNameAndEmail(name, email);
	}

	public List<Customer> getCustomerByNameStartsWith(String prefix) {
		// TODO Auto-generated method stub
		return customerRepository.findByNameStartingWith(prefix);
	}

	public long countCustomerByNameStartsWith(String prefix) {
		// TODO Auto-generated method stub
		return customerRepository.countByNameStartingWith(prefix);
	}

	public List<Customer> getCustomersByDomain(String domain) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomersByEmailDomain(domain);
	}

	public Customer getMinAgeCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerWithMinAge();
	}

	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email);
	}
}
