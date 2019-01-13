package com.assignment.token.service;

import com.assignment.token.entity.Customer;
import com.assignment.token.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public Customer findCustomerByMobileNumber(String mobileNumber) {

        return repo.findByMobileNumber(mobileNumber);

    }

}
