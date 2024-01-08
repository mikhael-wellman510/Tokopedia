package com.enigma.tokopedia.Dto.Response;

import com.enigma.tokopedia.Entity.ProductPrice;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {


    private String id;

    @NotBlank(message = "Product nama is Required")
    private String productName;

    @NotBlank(message = "Description is required")
    private String description;


    // Ini dari table di ProductPrice
    @NotBlank(message = "Price is Required")
    private Long price;

    @NotBlank(message = "Product stock is Required")
    private Integer stock;

    @NotBlank(message = "StoreId is reuired")
    private StoreResponse store;

    // Ambil dari Entity
    private List<ProductPrice> productPrices;

    private ProductPrice productPrice;

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", store=" + store +
                ", productPrices=" + productPrices +
                ", productPrice=" + productPrice +
                '}';
    }
}
