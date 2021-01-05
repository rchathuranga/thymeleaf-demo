package lk.rc.test.thymeleafdemo.dao;

import lk.rc.test.thymeleafdemo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
