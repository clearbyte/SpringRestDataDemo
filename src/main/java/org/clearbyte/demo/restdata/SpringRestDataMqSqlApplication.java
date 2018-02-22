package org.clearbyte.demo.restdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringRestDataMqSqlApplication implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDataMqSqlApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        customerRepository.save(new Customer("Jack", "Smith"));
        customerRepository.save(new Customer("Adam", "Johnson"));
        customerRepository.save(new Customer("Kim", "Smith"));
        customerRepository.save(new Customer("David", "Williams"));
        customerRepository.save(new Customer("Peter", "Davis"));
    }
}
