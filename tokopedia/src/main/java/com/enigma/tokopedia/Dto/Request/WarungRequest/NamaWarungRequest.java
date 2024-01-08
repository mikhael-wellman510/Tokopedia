package com.enigma.tokopedia.Dto.Request.WarungRequest;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NamaWarungRequest {

    private String id;
    private String namaWarung;
    private String alamat;
    private String noHp;
}
