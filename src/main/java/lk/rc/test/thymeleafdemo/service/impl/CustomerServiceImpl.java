package lk.rc.test.thymeleafdemo.service.impl;

import lk.rc.test.thymeleafdemo.dto.CustomerDTO;
import lk.rc.test.thymeleafdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<CustomerDTO>  customerDTOList = new ArrayList<>();


    @Override
    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerDTOList;
    }

    @Override
    public void addCustomer(CustomerDTO customerDTO) throws Exception {
        customerDTOList.add(customerDTO);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws Exception {
        Optional<CustomerDTO> optional = customerDTOList.stream().filter(cus -> cus.getCustomerId().equals(customerDTO.getCustomerId())).findAny();
        if (optional.isPresent()) {
            CustomerDTO dto = optional.get();
            dto.setName(customerDTO.getName());
            dto.setAddress(customerDTO.getAddress());
            dto.setContactNo(customerDTO.getContactNo());
        }
    }

    @Override
    public void deleteCustomer(String customerId) throws Exception {
        Optional<CustomerDTO> optional = customerDTOList.stream().filter(cus -> cus.getCustomerId().equals(customerId)).findAny();
        if (optional.isPresent()) {
            CustomerDTO dto = optional.get();
            customerDTOList.remove(dto);
        }
    }
}
