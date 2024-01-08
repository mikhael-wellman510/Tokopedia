package com.enigma.tokopedia.Entity.WarungEntity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class HargaProduk {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "harga" , columnDefinition = "int check (harga > 0)" , length = 100)
    private Integer harga;

    @Column(name = "stok" , columnDefinition = "int check(stok > 0)" , length = 50)
    private Integer stok;

    @ManyToOne
    @JsonBackReference// Supaya tidak stack overflow saling memangil
    @JoinColumn(name = "produk_id")
    private Produk produk;

    @ManyToOne
    @JoinColumn(name = "nama_warung_id")
    private NamaWarung namaWarung;

}
