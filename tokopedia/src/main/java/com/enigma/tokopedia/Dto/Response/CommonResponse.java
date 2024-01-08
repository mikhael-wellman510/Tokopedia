package com.enigma.tokopedia.Dto.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Data untuk setterGetter
@NoArgsConstructor // membuat constructor
@AllArgsConstructor
@Builder(toBuilder = true) // Memamping

// Untuk menampilkan message jika sukses hit API
public class CommonResponse<T> {
    private Integer statusCode;
    private String message;
    // Ini untuk menampilkan data yang di querry
    private T data;
}
