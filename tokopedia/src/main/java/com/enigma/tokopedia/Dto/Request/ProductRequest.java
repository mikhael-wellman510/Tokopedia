package com.enigma.tokopedia.Dto.Request;

import com.enigma.tokopedia.Dto.Response.StoreResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {

    private String id ;

    @NotBlank(message = "Product Name Is Required")
    private String productName ;

    @NotBlank(message = "Description is Required")
    private String description ;


    // Ini dari Product Price
    @NotBlank(message = "Price is Required")
    private Long price ;

    // Ini dari Product Price
    @NotBlank(message = "product stock is required")
    @Min(value = 0 ,message = "Stok harus lebih banyak dari 0")
    private Integer stock;

    //Ini dari produk Price
    @NotBlank(message = "Store id must required")
    private StoreResponse storeId;


}
