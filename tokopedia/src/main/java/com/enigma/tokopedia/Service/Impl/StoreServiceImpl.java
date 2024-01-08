package com.enigma.tokopedia.Service.Impl;

import com.enigma.tokopedia.Dto.Request.StoreRequest;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Entity.Store;
import com.enigma.tokopedia.Repositori.StoreRepositori;
import com.enigma.tokopedia.Service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor // ini untuk ambil Objek yg di repo
public class StoreServiceImpl implements StoreService {

    private final StoreRepositori storeRepositori;

    @Override
    public StoreResponse createStore(StoreRequest storeRequest) {

        // Mapping (Mengambill isi dari postman)
        Store store = Store.builder()
                .noSiup(storeRequest.getNoSiup()) // ambil dri req
                .name(storeRequest.getName())
                .address(storeRequest.getAddress())
                .mobilePhone(storeRequest.getMobilePhone())
                .build();

        storeRepositori.save(store);

        // Ini yg akan keluar di Postman
        return StoreResponse.builder()
                .id(storeRequest.getId())
                .noSiup(storeRequest.getNoSiup())
                .storeName(storeRequest.getName())
                .address(storeRequest.getAddress())
                .mobilePhone(storeRequest.getMobilePhone())
                .build();
    }

    @Override
    public StoreResponse getStoreById(String id) {
        // ambil Model supaya bisa search ke database
        Store store = storeRepositori.findById(id).orElse(null);

        System.out.println("Hasil get By Id : " + store);
        return StoreResponse.builder()
                .id(store.getId())
                .noSiup(store.getNoSiup())
                .storeName(store.getName())
                .address(store.getAddress())
                .mobilePhone(store.getMobilePhone())
                .build();
    }

    @Override
    public List<StoreResponse> getAllStore() {

        // Ambil model , dan jadikan list
        List<Store> stores = storeRepositori.findAll();

        System.out.println("Get All Stores : " +stores);

        // Di pecah2 dulu pakai stream
        return stores.stream()
                .map(store -> StoreResponse.builder()
                        .id(store.getId())
                        .noSiup(store.getNoSiup())
                        .storeName(store.getName())
                        .address(store.getAddress())
                        .mobilePhone(store.getMobilePhone())
                        .build()).toList();

    }

    @Override
    public StoreResponse updateStore(StoreRequest storeRequest) {

        Store store = storeRepositori.findById(storeRequest.getId()).orElse(null);

        System.out.println("hasil update : " +store);

        if (store != null){

            //Build untuk di update
            Store storeUpdate =Store.builder()
                    // Ambil dari store yg get Ud
                    .id(store.getId())
                    // Selebihnya ambil dari request
                    .noSiup(storeRequest.getNoSiup())
                    .name(storeRequest.getName())
                    .address(storeRequest.getAddress())
                    .mobilePhone(storeRequest.getMobilePhone())
                    .build();

            System.out.println("Hasil build Stores :" +storeUpdate);
            // Masukan hasil Build
            storeRepositori.save(storeUpdate);

            return StoreResponse.builder()
                    .id(store.getId())
                    .noSiup(storeRequest.getNoSiup())
                    .storeName(storeRequest.getName())
                    .address(storeRequest.getAddress())
                    .mobilePhone(storeRequest.getMobilePhone())
                    .build();
        }


        return null;
    }

    @Override
    public void deleteStore(String id) {
        Store store = storeRepositori.findById(id).orElse(null);
        System.out.println("Hasi store id: " +store);
        if (store != null){
            System.out.println("Succes Deleted");
            storeRepositori.deleteById(store.getId());
        }
    }
}
