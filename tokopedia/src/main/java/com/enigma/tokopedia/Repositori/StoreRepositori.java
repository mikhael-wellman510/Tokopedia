package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
// Ini untuk ambil model dan inject Orm nya
public interface StoreRepositori extends JpaRepository<Store,String> {
}
