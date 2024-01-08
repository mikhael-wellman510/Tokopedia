package com.enigma.tokopedia.Service.WarungService;


import com.enigma.tokopedia.Dto.Request.WarungRequest.ProdukRequest;
import com.enigma.tokopedia.Dto.Response.WarungResponse.ProdukResponse;

public interface ProdukService {
    ProdukResponse createProdukAndHargaProduk(ProdukRequest produkRequest);
}
