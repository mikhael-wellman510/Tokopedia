package com.enigma.tokopedia.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "m_product_price")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "stock" ,columnDefinition = "int check (stock > 0)" ,length = 100)
    private Integer stock;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "price" ,columnDefinition = "bigint check (price > 8)" ,length = 100)
    private Long price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    // Harus di buat JsonBackRefrence supaya tidak stack overflow(saling memanggil)
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id='" + id + '\'' +
                ", stock=" + stock +
                ", isActive=" + isActive +
                ", price=" + price +
                ", store=" + store +
                ", product=" + product +
                '}';
    }
}
