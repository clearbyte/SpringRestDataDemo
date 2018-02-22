/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.clearbyte.demo.restdata;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pete
 */
//@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByLastName(@Param("name") String name);
}
