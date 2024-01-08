package com.enigma.tokopedia.Controller.WarungController;

import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.WarungRequest.ProdukRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.WarungResponse.ProdukResponse;
import com.enigma.tokopedia.Service.WarungService.ProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUKWARUNG)
public class ProductController {

    private final ProdukService produkService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createProdukDanHargaProduk(@RequestBody ProdukRequest produkRequest){
        ProdukResponse pr = produkService.createProdukAndHargaProduk(produkRequest);

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProdukResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully crated new Product")
                        .data(pr)
                        .build()) ;
    }

}
