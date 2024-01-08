package com.enigma.tokopedia.Controller;


import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.OrdersRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.OrdersResponse;
import com.enigma.tokopedia.Entity.Orders;
import com.enigma.tokopedia.Service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppPath.ORDER)
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/newOrders")
    private ResponseEntity<?> createNewOrder(@RequestBody OrdersRequest ordersRequest){
        OrdersResponse ordersResponse = ordersService.createNewOrder(ordersRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<OrdersResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Created Data")
                        .data(ordersResponse)
                        .build()
                );
    }
}
