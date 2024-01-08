package com.enigma.tokopedia.Dto.Request;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrdersRequest {

    private String customerId;
    private List<OrderDetailRequest> orderDetailRequests;

    @Override
    public String toString() {
        return "OrdersRequest{" +
                "customerId='" + customerId + '\'' +
                ", orderDetailRequests=" + orderDetailRequests +
                '}';
    }
}
