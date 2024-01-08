package com.enigma.tokopedia.Entity.WarungEntity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nama_produk" , nullable = false, length = 30 , unique = true)
    private String namaProduk;

    @Column(name = "deskripsi" , nullable = false, length = 40)
    private String deskripsi;

    @OneToMany(mappedBy = "produk")
    private List<HargaProduk> hargaProduk;

}
