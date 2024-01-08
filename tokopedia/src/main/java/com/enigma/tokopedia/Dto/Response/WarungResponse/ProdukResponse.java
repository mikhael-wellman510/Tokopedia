package com.enigma.tokopedia.Dto.Response.WarungResponse;


import com.enigma.tokopedia.Dto.Request.WarungRequest.NamaWarungRequest;
import com.enigma.tokopedia.Entity.WarungEntity.NamaWarung;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProdukResponse {

    // Dari produk
    private String id;
    private String namaProduk;
    private String deskripsi;

    // dari harga Produk
    private Integer harga;
    private Integer stok;
    private NamaWarung namaWarung;
}
