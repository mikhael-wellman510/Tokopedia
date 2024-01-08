package com.enigma.tokopedia.Service.Impl;

import com.enigma.tokopedia.Dto.Request.OrdersRequest;
import com.enigma.tokopedia.Dto.Response.*;
import com.enigma.tokopedia.Dto.Response.WarungResponse.ProdukResponse;
import com.enigma.tokopedia.Entity.*;
import com.enigma.tokopedia.Repositori.OrdersRepositori;
import com.enigma.tokopedia.Service.CustomerService;
import com.enigma.tokopedia.Service.OrdersService;
import com.enigma.tokopedia.Service.ProductPriceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrdersService {

    private final OrdersRepositori ordersRepositori;
    private final CustomerService customerService;
    private final ProductPriceService productPriceService;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public OrdersResponse createNewOrder(OrdersRequest ordersRequest) {

        System.out.println(ordersRequest);

        // Todo 1 = ambil Id Customer
        CustomerResponse customerResponse = customerService.getCustomerById(ordersRequest.getCustomerId());

        // Todo 2 = ambil Order Detail Request(karena stream , balikan nya harus list)
        List<OrderDetail> orderDetails = ordersRequest.getOrderDetailRequests().stream().map(orderDetailRequest -> {
            System.out.println("hasil order detail req : " + orderDetailRequest);
            // Todo 3 = get OrderDetailRequest berdasarkan Id order detail request
            // Ambil semua isi Product Price
            ProductPrice productPrice = productPriceService.getById(orderDetailRequest.getProductPriceId());
            System.out.println("Hasil Produk Price " + productPrice);

            return OrderDetail.builder()
                    .productPrice(productPrice)
                    .quantity(orderDetailRequest.getQuantity())
                    .build();

        }).toList();
        System.out.println("hasil order details" + orderDetails);

        // Todo 4 : creat new order

        // Maping dari berbagai relasi dan menghubungkan ke beberapa relasi
        Orders orders = Orders.builder()
                .transaksiDate(LocalDateTime.now()) // Ambil waktu sekarang
                .customer(Customer.builder()
                        .id(customerResponse.getId())
                        .build())
                .orderDetails(orderDetails)
                .build();

        ordersRepositori.save(orders);

        // Many to one dibikin List

        List<OrderDetailRespon> orderDetailRespons = orders.getOrderDetails().stream().map(orderDetail -> {
            orderDetail.setOrders(orders);

            ProductPrice currentProductPrice = orderDetail.getProductPrice(); // ambil Produk price
       
            // Kurangin stok sama kuantiti order
            currentProductPrice.setStock(currentProductPrice.getStock() - orderDetail.getQuantity());

            return OrderDetailRespon.builder()
                    .orderDetailId(orderDetail.getId())
                    .quantity(orderDetail.getQuantity())
                    .productResponse(ProductResponse.builder()
                            // Maping  Product response
                            .id(currentProductPrice.getProduct().getId())
                            .productName(currentProductPrice.getProduct().getName())
                            .description(currentProductPrice.getProduct().getDescription())
                            .stock(currentProductPrice.getStock())
                            .price(currentProductPrice.getPrice())
                            .store(StoreResponse.builder()
                                    // Maping Store response (Masukan) setter
                                    .id(currentProductPrice.getStore().getId())
                                    .storeName(currentProductPrice.getStore().getName())
                                    .noSiup(currentProductPrice.getStore().getNoSiup())
                                    .address(currentProductPrice.getStore().getAddress())
                                    .build())
                            .productPrice(currentProductPrice)
                            .build())
                    .build();


        }).toList();
        // Todo 5 :

        System.out.println("Hasil order detail Response : " + orderDetailRespons);
        return OrdersResponse.builder()
                .localDateTime(orders.getTransaksiDate())
                .customerResponse(customerResponse)
                .orderDetailRespons(orderDetailRespons)
                .build();


    }

}