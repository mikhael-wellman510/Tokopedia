package com.enigma.tokopedia.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_order")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "transaksi_date" , nullable = false)
    private LocalDateTime transaksiDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private  Customer customer; // Customer Id

    @OneToMany(mappedBy = "orders" , cascade = CascadeType.PERSIST)
    private List<OrderDetail> orderDetails;

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", transaksiDate=" + transaksiDate +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
