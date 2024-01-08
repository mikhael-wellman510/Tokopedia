package com.enigma.tokopedia.Service;

import com.enigma.tokopedia.Dto.Request.OrdersRequest;
import com.enigma.tokopedia.Dto.Response.OrdersResponse;

public interface OrdersService {

    OrdersResponse createNewOrder(OrdersRequest ordersRequest);
}
