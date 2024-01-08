package com.enigma.tokopedia.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "m_product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name" ,nullable = false , length = 30)
    private  String name ;

    @Column(name = "description" , nullable = false , length = 50)
    private String description;

    // Produk berelasi dengan ProductPrice
    @OneToMany(mappedBy = "product") // Biar ga buat table conjunction
    private List<ProductPrice> productPrices;


}
