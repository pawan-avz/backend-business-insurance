package com.backend.BIPC.repositories;

import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PropertyRepository extends JpaRepository<Property,Long> {
    Property findByUserId(Long id);
    Property findByPropertyId(Long id);
}
