package com.enigma.tokopedia.Controller;


import com.enigma.tokopedia.Constant.AppPath;
import com.enigma.tokopedia.Dto.Request.StoreRequest;
import com.enigma.tokopedia.Dto.Response.CommonResponse;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.STORE)
public class StoreController {

   private final StoreService storeService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createStore(@RequestBody StoreRequest storeRequest){
       // Kirim data dari postman ke Service
        StoreResponse storeResponse = storeService.createStore(storeRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<StoreResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Buat Data")
                        .data(storeResponse)
                        .build()
                );

    }

    @GetMapping(value = "/getStoreById/{id}")
    public ResponseEntity<?> getStoreById(@PathVariable String id){


        //kirim data ke Service
        // dan juga , store response nya di kirim ke respon entity
        StoreResponse storeResponse = storeService.getStoreById(id);
        System.out.println("isi store response di controller : " +storeResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<StoreResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get Data By Id")
                        .data(storeResponse)
                        .build()
                );

    }

@GetMapping(value = "/getStoreAll")
    public ResponseEntity<?>  getAllStore(){
        List<StoreResponse> storeResponse = storeService.getAllStore();
        System.out.println("Hasil controller : " + storeResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<StoreResponse>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Get Data By Id")
                        .data(storeResponse)
                        .build()
                );

    }

    @PutMapping(value = "/updateStore")
    public ResponseEntity<?> updateStores(@RequestBody StoreRequest storeRequest){

        // Panggil dan kirim data ke Service
        StoreResponse storeResponse = storeService.updateStore(storeRequest);

        System.out.println("HAsil response di Controller : " + storeResponse);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<StoreResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Update Data ")
                        .data(storeResponse)
                        .build()
                );
    }

    @DeleteMapping(value = "/deleteStore/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable String id){
        StoreResponse deletedStore = storeService.getStoreById(id);

        storeService.deleteStore(id);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Sukses Deleted Data ")
                        .data(deletedStore.getStoreName())
                        .build()
                );
    }
}
