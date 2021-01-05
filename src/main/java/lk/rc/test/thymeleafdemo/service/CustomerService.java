package lk.rc.test.thymeleafdemo.service;

import lk.rc.test.thymeleafdemo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    public List<CustomerDTO> getAllCustomers() throws Exception;
    public void addCustomer(CustomerDTO customerDTO) throws Exception;
    public void updateCustomer(CustomerDTO customerDTO) throws Exception;
    public void deleteCustomer(String customerId) throws Exception;

}
