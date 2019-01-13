package com.assignment.token.service;


import com.assignment.token.entity.Customer;

public interface CustomerService {

    Customer findCustomerByMobileNumber(String mobileNumber);

}
