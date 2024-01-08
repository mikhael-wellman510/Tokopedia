package com.enigma.tokopedia.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "m_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true) // untuk melakukan mapping
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name" ,nullable = false, length = 30)
    private String name ;

    @Column(name = "address" , nullable = false , length = 50)
    private String address;

    @Column(name = "mobile_phone" , nullable = false , unique = true, length = 50)
    private String mobilePhone ;

    @Column(name = "email" , nullable = false, unique = true ,length = 50)
    private String email;

}
