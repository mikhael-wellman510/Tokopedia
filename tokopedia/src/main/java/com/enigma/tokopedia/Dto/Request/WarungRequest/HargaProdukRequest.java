package com.enigma.tokopedia.Dto.Request.WarungRequest;


import com.enigma.tokopedia.Entity.WarungEntity.NamaWarung;
import com.enigma.tokopedia.Entity.WarungEntity.Produk;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HargaProdukRequest {

    private String id;
    private Integer harga;
    private Boolean isActive;
    private Integer stock;
    private Produk produk;
    private NamaWarung namaWarung;
}
