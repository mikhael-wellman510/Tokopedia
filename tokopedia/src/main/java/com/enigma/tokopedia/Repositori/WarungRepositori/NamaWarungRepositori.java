package com.enigma.tokopedia.Repositori.WarungRepositori;



import com.enigma.tokopedia.Entity.WarungEntity.NamaWarung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NamaWarungRepositori extends JpaRepository<NamaWarung,String> {

}
