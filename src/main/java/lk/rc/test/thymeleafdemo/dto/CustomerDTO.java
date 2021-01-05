package lk.rc.test.thymeleafdemo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private String customerId;
    private String name;
    private String address;
    private String contactNo;
}
