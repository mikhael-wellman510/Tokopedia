package com.enigma.tokopedia.Service.Impl;


import com.enigma.tokopedia.Dto.Request.CustomerRequest;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;
import com.enigma.tokopedia.Entity.Customer;
import com.enigma.tokopedia.Entity.Store;
import com.enigma.tokopedia.Repositori.CustomerRepositori;
import com.enigma.tokopedia.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // Untuk ambil object yg di repo
public class CustomerServiceImpl implements CustomerService {

    // Untuk ambil method CRUD di repositori
    private final CustomerRepositori customerRepositori ;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {

        // Ambil data dari Controller
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .address(customerRequest.getAddress())
                .mobilePhone(customerRequest.getMobilePhone())
                .email(customerRequest.getEmail())
                .build();

        customerRepositori.save(customer);

        return CustomerResponse.builder()
                .id(customerRequest.getId())
                .name(customerRequest.getName())
                .address(customerRequest.getAddress())
                .mobilePhone(customerRequest.getMobilePhone())
                .email(customerRequest.getEmail())
                .build();
    }

    @Override
    public CustomerResponse getCustomerById(String id) {

        Customer customer = customerRepositori.findById(id).orElse(null);



        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .mobilePhone(customer.getMobilePhone())
                .email(customer.getEmail())
                .build();
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {

        List<Customer> customer = customerRepositori.findAll();


        return customer.stream()
                .map(customers -> CustomerResponse.builder()
                        .id(customers.getId())
                        .name(customers.getName())
                        .address(customers.getAddress())
                        .mobilePhone(customers.getMobilePhone())
                        .email(customers.getEmail())
                        .build()
                ).toList();
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
       Customer customer = customerRepositori.findById(customerRequest.getId()).orElse(null);

       if (customer != null){

           Customer customerUpdate = Customer.builder()
                   .id(customerRequest.getId())
                   .name(customerRequest.getName())
                   .address(customerRequest.getAddress())
                   .mobilePhone(customerRequest.getMobilePhone())
                   .email(customerRequest.getEmail())
                   .build();

           // Update
           customerRepositori.save(customerUpdate);
       }




        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customerRequest.getName())
                .address(customerRequest.getAddress())
                .mobilePhone(customerRequest.getMobilePhone())
                .email(customerRequest.getEmail())
                .build();
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = customerRepositori.findById(id).orElse(null);
        if (customer != null){
            customerRepositori.deleteById(id);
        }
    }
}
