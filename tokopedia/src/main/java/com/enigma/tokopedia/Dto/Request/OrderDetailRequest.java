package com.enigma.tokopedia.Dto.Request;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailRequest {

    private String productPriceId;
    private Integer quantity;

    @Override
    public String toString() {
        return "OrderDetailRequest{" +
                "productPriceId='" + productPriceId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
