package com.enigma.tokopedia.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrdersResponse {

    private String orderId;
    private LocalDateTime localDateTime;
    private CustomerResponse customerResponse;
    private List<OrderDetailRespon> orderDetailRespons;
}
