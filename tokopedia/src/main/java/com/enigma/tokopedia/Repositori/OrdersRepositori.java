package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepositori extends JpaRepository<Orders, String> {
}
