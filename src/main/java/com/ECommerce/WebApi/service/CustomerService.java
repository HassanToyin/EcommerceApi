package com.ECommerce.WebApi.service;


import com.ECommerce.WebApi.dto.CustomerDto;
import com.ECommerce.WebApi.model.Customer;
import com.ECommerce.WebApi.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;

    public Customer createCustomer(CustomerDto customerDTO) {

        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());

        return customerRepo.save(customer);

    }

    public Customer getCustomer(Long id) {
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public ArrayList<Customer> getAllCustomers() {
        return (ArrayList<Customer>) customerRepo.findAll();
    }

    public Customer updateCustomer(CustomerRepo customerDTO, Long id) {

        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setEmail(customerDTO.getEmail());

        return customerRepo.save(customer);
    }

    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepo.findById(id).get();
        customerRepo.deleteById(id);
        return customer;
    }
}
