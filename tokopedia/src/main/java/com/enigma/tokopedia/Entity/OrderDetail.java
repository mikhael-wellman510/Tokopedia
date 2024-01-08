package com.enigma.tokopedia.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.Order;

@Entity
@Table(name = "t_order_detail")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders; // Order id

    @ManyToOne
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPrice; // price id


    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", quantity=" + quantity +
                ", orders=" + orders +
                ", productPrice=" + productPrice +
                '}';
    }
}
