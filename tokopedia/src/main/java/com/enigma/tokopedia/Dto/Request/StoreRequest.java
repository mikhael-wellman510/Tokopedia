package com.enigma.tokopedia.Dto.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Setter Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)  // Ini untuk mapping data
public class StoreRequest {

    // Data harus tetap sama seperti yang di model
    private String id;
    private String noSiup;
    private String name ;
    private String address;
    private String mobilePhone;

}
