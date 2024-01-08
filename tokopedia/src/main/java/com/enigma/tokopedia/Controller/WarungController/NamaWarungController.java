package com.enigma.tokopedia.Controller.WarungController;


import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.WarungRequest.NamaWarungRequest;
import com.enigma.tokopedia.Dto.Request.WarungRequest.ProdukRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.CustomerResponse;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Dto.Response.WarungResponse.NamaWarungResponse;
import com.enigma.tokopedia.Entity.Store;
import com.enigma.tokopedia.Service.WarungService.NamaWarungService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.WARUNG)
public class NamaWarungController {

    private  final NamaWarungService namaWarungService;

    @PostMapping(value = "/createWarung")
    public ResponseEntity<?> createWarung(@RequestBody NamaWarungRequest namaWarungRequest){
         NamaWarungResponse nwr = namaWarungService.createWarung(namaWarungRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<NamaWarungResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Created Data")
                        .data(nwr)
                        .build()
                );
    }


    @GetMapping(value = "/getAllWarung")
    public ResponseEntity<?> getAllWarung(){
        List<NamaWarungResponse> nwr = namaWarungService.getAllWarung();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<NamaWarungResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get All Data")
                        .data(nwr)
                        .build()
                );

    }



}
