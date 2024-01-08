package com.enigma.tokopedia.Dto.Response;


import com.enigma.tokopedia.Dto.Response.WarungResponse.ProdukResponse;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailRespon {

    private String orderDetailId;
    private ProductResponse productResponse;
    private Integer quantity;

    @Override
    public String toString() {
        return "OrderDetailRespon{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", productResponse=" + productResponse +
                ", quantity=" + quantity +
                '}';
    }
}
