package com.enigma.tokopedia.Service.Impl.WarungServiceImpl;

import com.enigma.tokopedia.Dto.Request.WarungRequest.ProdukRequest;
import com.enigma.tokopedia.Dto.Response.StoreResponse;
import com.enigma.tokopedia.Dto.Response.WarungResponse.HargaProdukResponse;
import com.enigma.tokopedia.Dto.Response.WarungResponse.NamaWarungResponse;
import com.enigma.tokopedia.Dto.Response.WarungResponse.ProdukResponse;
import com.enigma.tokopedia.Entity.ProductPrice;
import com.enigma.tokopedia.Entity.Store;
import com.enigma.tokopedia.Entity.WarungEntity.HargaProduk;
import com.enigma.tokopedia.Entity.WarungEntity.NamaWarung;
import com.enigma.tokopedia.Entity.WarungEntity.Produk;
import com.enigma.tokopedia.Repositori.WarungRepositori.HargaProdukRepositori;
import com.enigma.tokopedia.Repositori.WarungRepositori.NamaWarungRepositori;
import com.enigma.tokopedia.Repositori.WarungRepositori.ProdukRepositori;
import com.enigma.tokopedia.Service.WarungService.HargaProdukService;
import com.enigma.tokopedia.Service.WarungService.NamaWarungService;
import com.enigma.tokopedia.Service.WarungService.ProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProdukWarungServiceImpl implements ProdukService {

    private final ProdukRepositori produkRepositori;
    private final HargaProdukRepositori hargaProdukRepositori;
    private final NamaWarungService namaWarungService;
    private final HargaProdukService hargaProdukService;

private final NamaWarungRepositori namaWarungRepositori;

    @Override
    public ProdukResponse createProdukAndHargaProduk(ProdukRequest produkRequest) {

        // Ambil relasi nya
        // Todo 1 : ambil Id Warung
//        NamaWarungResponse nmr = namaWarungService.getWarungById(produkRequest.getNamaWarungResponseId().getId());
//        System.out.println("Hasil no Warung : " + nmr);

        NamaWarung nm = namaWarungRepositori.findById(produkRequest.getNamaWarungResponseId().getId()).orElse(null);


        // Todo 2 :Mapping Product (Create)

        Produk pr = Produk.builder()
                .namaProduk(produkRequest.getNamaProduk())
                .deskripsi(produkRequest.getDeskripsi())
                .build();

        // create Product
        produkRepositori.save(pr);

        System.out.println("Hasil pr : " + pr);

        // Todo 3 : Buat Product Price

        HargaProduk hpr = HargaProduk.builder()
                .harga(produkRequest.getHarga())
                .stok(produkRequest.getStok())
                .produk(pr)
                .namaWarung(nm)
                .build();

        hargaProdukService.createHargaProduk(hpr);

        System.out.println("Hasil Produk : " + nm.getId());



        return ProdukResponse.builder()
                .id(pr.getId())
                .namaProduk(pr.getNamaProduk())
                .deskripsi(pr.getDeskripsi())
                .harga(hpr.getHarga())
                .stok(hpr.getStok())
                .namaWarung(nm)
                .build();
    }
}
