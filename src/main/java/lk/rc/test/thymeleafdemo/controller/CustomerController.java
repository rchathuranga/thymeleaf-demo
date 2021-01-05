package lk.rc.test.thymeleafdemo.controller;

import lk.rc.test.thymeleafdemo.dto.CustomerDTO;
import lk.rc.test.thymeleafdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String greeting(@RequestParam(name = "name", required = false) String name, Model model) {
        List<CustomerDTO> allCustomers = new ArrayList<>();
        try {
            allCustomers = customerService.getAllCustomers();
            model.addAttribute("customerList", allCustomers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "customer-form";
    }

    @PostMapping("/operation")
    public String saveCustomer(@RequestParam String id, @RequestParam String name, @RequestParam String address, @RequestParam String contactNo, @RequestParam String buttonType, Model model) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(id);
        customerDTO.setName(name);
        customerDTO.setContactNo(contactNo);
        customerDTO.setAddress(address);

        try {
            switch (buttonType) {
                case "btnSave":
                    customerService.addCustomer(customerDTO);
                    break;
                case "btnUpdate":
                    customerService.updateCustomer(customerDTO);
                    break;
                case "btnDelete":
                    customerService.deleteCustomer(id);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/customer";
    }

}
