package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositori extends JpaRepository<Product ,String> , JpaSpecificationExecutor<Product> {
    //JpaspesificationExcekutor fugsi nya untuk di searching
}
