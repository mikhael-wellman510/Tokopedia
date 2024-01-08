package com.enigma.tokopedia.Service.WarungService;

import com.enigma.tokopedia.Dto.Request.WarungRequest.HargaProdukRequest;
import com.enigma.tokopedia.Dto.Response.WarungResponse.HargaProdukResponse;
import com.enigma.tokopedia.Entity.WarungEntity.HargaProduk;

public interface HargaProdukService {

    HargaProduk createHargaProduk(HargaProduk hargaProduk);
}
