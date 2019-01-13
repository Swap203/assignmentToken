package com.assignment.token.repository;

import com.assignment.token.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {


   Customer findByMobileNumber(String mobileNumber);

}
