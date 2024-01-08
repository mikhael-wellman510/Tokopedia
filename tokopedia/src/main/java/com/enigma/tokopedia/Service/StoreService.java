package com.enigma.tokopedia.Service;

import com.enigma.tokopedia.Dto.Request.StoreRequest;
import com.enigma.tokopedia.Dto.Response.StoreResponse;

import java.util.List;

public interface StoreService {

    StoreResponse createStore(StoreRequest storeRequest);

    StoreResponse getStoreById(String id);

    List<StoreResponse> getAllStore();

    StoreResponse updateStore(StoreRequest storeRequest);

    void  deleteStore(String id);
}
