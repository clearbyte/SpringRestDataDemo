/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clearbyte.demo.restdata;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 *
 * @author pete
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerRepository customerRepo;
    
    @GetMapping
    public ResponseEntity findAll() {
        LOGGER.info("Get all customers");        
        List<Customer> custList = customerRepo.findAll();
        return ResponseEntity.ok().body(custList);
    }
     
    @GetMapping("/{customerId}")
    public ResponseEntity FindById(@PathVariable(value = "customerId") Long customerId) {
        
        Customer cust = customerRepo.findOne(customerId);
        if(cust == null) {
            LOGGER.info("Customer not found ID:{}", customerId);
            return ResponseEntity.notFound().build();
        }        
        return ResponseEntity.ok().body(cust);
    }
    
    @PostMapping()
    public ResponseEntity create(@Valid @RequestBody Customer createCust) {
        Customer cust = customerRepo.save(createCust);
        return ResponseEntity.ok().body(cust);
    }
    
    @PutMapping("/{customerId}")
    public ResponseEntity update(@PathVariable(value = "customerId") Long customerId, 
            @Valid @RequestBody Customer updateCust) {
        Customer cust = customerRepo.findOne(customerId);
        if(cust == null) {
            return ResponseEntity.notFound().build();
        }
        cust = customerRepo.save(updateCust);
        return ResponseEntity.ok().body(cust);
    }
    
    @DeleteMapping("/{customerId}")
    public ResponseEntity delete(@PathVariable(value = "customerId") Long customerId) {
        Customer cust = customerRepo.findOne(customerId);
        if(cust == null) {
            return ResponseEntity.notFound().build();
        }
        customerRepo.delete(cust);
        return ResponseEntity.ok().build();
    }
}
