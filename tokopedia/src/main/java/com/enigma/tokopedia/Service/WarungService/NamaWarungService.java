package com.enigma.tokopedia.Service.WarungService;

import com.enigma.tokopedia.Dto.Request.WarungRequest.NamaWarungRequest;
import com.enigma.tokopedia.Dto.Response.WarungResponse.NamaWarungResponse;

import java.util.List;

public interface NamaWarungService {

    NamaWarungResponse createWarung(NamaWarungRequest namaWarungRequest);

    NamaWarungResponse getWarungById(String id);

    List<NamaWarungResponse> getAllWarung();

    NamaWarungResponse updateWarung(NamaWarungRequest namaWarungRequest);

    void deleteWarung(String id);
}

