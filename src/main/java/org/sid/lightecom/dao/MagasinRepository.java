package org.sid.lightecom.dao;

import org.sid.lightecom.entities.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("*")
@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long>{

}
