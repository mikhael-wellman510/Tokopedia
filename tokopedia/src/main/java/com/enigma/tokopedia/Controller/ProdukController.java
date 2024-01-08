package com.enigma.tokopedia.Controller;

import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.ProductRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;
import com.enigma.tokopedia.Dto.Response.ProductResponse;
import com.enigma.tokopedia.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUK)
public class ProdukController {

    private final ProductService productService;

    @PostMapping(value = "/createProduct")
    public ResponseEntity<?> createProductAndProductPrice(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.createProductAndProductPrice(productRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(productResponse)
                        .build()) ;

    }

    @GetMapping(value = "/getProduct")
    public ResponseEntity<?> getAllProduct(@PathVariable ProductRequest productRequest){
        List <ProductResponse> productResponse = productService.getAllProduct();

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(productResponse)
                        .build()) ;
    }
}
