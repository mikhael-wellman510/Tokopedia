package com.enigma.tokopedia.Controller;


import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;
import com.enigma.tokopedia.Entity.ProductPrice;
import com.enigma.tokopedia.Service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUCTPRICE)
public class ProdukPriceController {

    private final ProductPriceService productPriceService;

    @GetMapping(value = "/get")
    public ResponseEntity<?> getAllProductPrice(){
        List<ProductPrice> productPrices = productPriceService.getAllProduct();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<ProductPrice>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get All Produk Price")
                        .data(productPrices)
                        .build()
                );
    }

}
