package com.enigma.tokopedia.Entity.WarungEntity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NamaWarung {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nama_warung" ,unique = true,nullable = false , length = 30)
    private String namaWarung;

    @Column(name = "alamat" , nullable = false, length = 30)
    private String alamat;

    @Column(name = "no_hp" , nullable = false, unique = true , length = 40)
    private String noHp;
}
