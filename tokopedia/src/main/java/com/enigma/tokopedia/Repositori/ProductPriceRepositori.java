package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPriceRepositori extends JpaRepository<ProductPrice , String> {

    Optional<ProductPrice> findByProduct_IdAndIsActive(String productId, Boolean active);

}
