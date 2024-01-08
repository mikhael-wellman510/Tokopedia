package com.enigma.tokopedia.Service;

import com.enigma.tokopedia.Dto.Request.CustomerRequest;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
    CustomerResponse getCustomerById(String id);
    List<CustomerResponse> getAllCustomer();
    CustomerResponse updateCustomer(CustomerRequest customerRequest);
    void deleteCustomer(String id);
}
