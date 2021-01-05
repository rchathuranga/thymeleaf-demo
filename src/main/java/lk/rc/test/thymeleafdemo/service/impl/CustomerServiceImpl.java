package lk.rc.test.thymeleafdemo.service.impl;

import lk.rc.test.thymeleafdemo.dao.CustomerRepository;
import lk.rc.test.thymeleafdemo.dto.CustomerDTO;
import lk.rc.test.thymeleafdemo.model.Customer;
import lk.rc.test.thymeleafdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        List<Customer> all = customerRepository.findAll();
        List<CustomerDTO> customerList = new ArrayList<>();

        for (Customer customer : all) {
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setContactNo(customer.getContactNo());

            customerList.add(customerDTO);
        }

        return customerList;
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId(customerDTO.getCustomerId());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setContactNo(customerDTO.getContactNo());

        customer = customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws Exception {
        Customer customer = customerRepository.findById(customerDTO.getCustomerId()).get();

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setContactNo(customerDTO.getContactNo());

        customer = customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        Customer customer = customerRepository.findById(customerId).get();
        customerRepository.delete(customer);
    }
}
