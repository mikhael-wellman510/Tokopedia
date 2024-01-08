package com.enigma.tokopedia.Repositori;

import com.enigma.tokopedia.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositori extends JpaRepository<Customer , String> {


}
