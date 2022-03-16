package com.fedpet.repositories;

import com.fedpet.entities.FundLeisure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundLeisureRepository extends JpaRepository<FundLeisure, Long> {
}
