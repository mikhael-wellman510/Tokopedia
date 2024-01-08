package com.enigma.tokopedia.Dto.Response.WarungResponse;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NamaWarungResponse {

    private String id;
    private String namaWarung;
    private String alamat;
    private String noHp;
}
