package com.enigma.tokopedia.Service.Impl.WarungServiceImpl;

import com.enigma.tokopedia.Dto.Request.WarungRequest.HargaProdukRequest;
import com.enigma.tokopedia.Dto.Response.WarungResponse.HargaProdukResponse;
import com.enigma.tokopedia.Entity.WarungEntity.HargaProduk;
import com.enigma.tokopedia.Repositori.WarungRepositori.HargaProdukRepositori;
import com.enigma.tokopedia.Service.WarungService.HargaProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HargaProdukImpl implements HargaProdukService {

private final HargaProdukRepositori hargaProdukRepositori;

    @Override
    public HargaProduk createHargaProduk(HargaProduk hargaProduk) {
        return hargaProdukRepositori.save(hargaProduk);
    }
}
