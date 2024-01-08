package com.enigma.tokopedia.Dto.Request.WarungRequest;


import com.enigma.tokopedia.Dto.Response.WarungResponse.NamaWarungResponse;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

// Ini data yang harus di masukan ke Postman
public class ProdukRequest {



    // tabel produk
    private String id;
    private String namaProduk;
    private String deskripsi;

    // Table Price;
    private Integer harga;
    private Integer stok;
    private NamaWarungResponse namaWarungResponseId;
}
