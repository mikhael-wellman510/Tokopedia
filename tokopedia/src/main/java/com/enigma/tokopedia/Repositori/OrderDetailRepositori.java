package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepositori extends JpaRepository<OrderDetail,String > {
}
