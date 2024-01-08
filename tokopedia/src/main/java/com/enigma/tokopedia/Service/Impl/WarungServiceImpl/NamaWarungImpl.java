package com.enigma.tokopedia.Service.Impl.WarungServiceImpl;

import com.enigma.tokopedia.Dto.Request.WarungRequest.NamaWarungRequest;
import com.enigma.tokopedia.Dto.Response.WarungResponse.NamaWarungResponse;
import com.enigma.tokopedia.Entity.WarungEntity.NamaWarung;
import com.enigma.tokopedia.Repositori.WarungRepositori.NamaWarungRepositori;
import com.enigma.tokopedia.Service.WarungService.NamaWarungService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class NamaWarungImpl implements NamaWarungService {

    private final NamaWarungRepositori namaWarungRepositori;

    @Override
    public NamaWarungResponse createWarung(NamaWarungRequest namaWarungRequest) {
        NamaWarung nw = NamaWarung.builder()
                .namaWarung(namaWarungRequest.getNamaWarung())
                .alamat(namaWarungRequest.getAlamat())
                .noHp(namaWarungRequest.getNoHp())
                .build();

        namaWarungRepositori.save(nw);
        return NamaWarungResponse.builder()
                .namaWarung(namaWarungRequest.getNamaWarung())
                .alamat(namaWarungRequest.getAlamat())
                .noHp(namaWarungRequest.getNoHp())
                .build();
    }

    @Override
    public NamaWarungResponse getWarungById(String id) {
     NamaWarung n = namaWarungRepositori.findById(id).orElse(null);
        return NamaWarungResponse.builder()
                .id(n.getId())
                .namaWarung(n.getNamaWarung())
                .alamat(n.getAlamat())
                .noHp(n.getNoHp())
                .build();
    }

    @Override
    public List<NamaWarungResponse> getAllWarung() {
        List<NamaWarung> nwr = namaWarungRepositori.findAll();

        return nwr.stream()
                .map(warungNama -> NamaWarungResponse.builder()
                        .id(warungNama.getId())
                        .namaWarung(warungNama.getNamaWarung())
                        .alamat(warungNama.getAlamat())
                        .noHp(warungNama.getNoHp())
                        .build()).toList();



    }

    @Override
    public NamaWarungResponse updateWarung(NamaWarungRequest namaWarungRequest) {
        return null;
    }

    @Override
    public void deleteWarung(String id) {

    }
}
