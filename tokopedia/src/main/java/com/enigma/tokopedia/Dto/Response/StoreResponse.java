package com.enigma.tokopedia.Dto.Response;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StoreResponse {

    private String id;
    private String noSiup;
    private String storeName;
    private String address;
    private String mobilePhone;

}
