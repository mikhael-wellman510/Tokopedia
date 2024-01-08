package com.enigma.tokopedia.Controller;


import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.CustomerRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.CUSTOMER)
public class CustomerController {

    private final CustomerService customerService ;

  @PostMapping(value = "/create")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRequest customerRequest){
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
      System.out.println("Isi response di controller : " + customerResponse);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<CustomerResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Created Data")
                        .data(customerResponse)
                        .build()
                );


    }

    @GetMapping(value = "/getAllCustomer")
    public ResponseEntity<?> getAllCustomer(){
        List<CustomerResponse> customerResponses = customerService.getAllCustomer();
        System.out.println(customerResponses);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<CustomerResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get All Data")
                        .data(customerResponses)
                        .build()
                );


    }

    @GetMapping(value = "/getCustomerById/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id){
      CustomerResponse customerResponse = customerService.getCustomerById(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<CustomerResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get Data By Id Data")
                        .data(customerResponse)
                        .build()
                );
    }

    @PutMapping(value = "/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerRequest customerRequest){
      CustomerResponse customerResponse = customerService.updateCustomer(customerRequest);

      return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<CustomerResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Update Data Customer ")
                        .data(customerResponse)
                        .build()
                );
    }

    @DeleteMapping(value = "/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
      //Panggil Customer Response nya
            CustomerResponse customerResponse = customerService.getCustomerById(id);

            customerService.deleteCustomer(id);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(CommonResponse.builder()
                            .statusCode(HttpStatus.CREATED.value())
                            .message("Sukses Deleted Data ")
                            .data("Berhasil menghapus : " + customerResponse.getName())
                            .build()
                    );

    }

}
