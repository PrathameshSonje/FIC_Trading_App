package com.example.fic-trading-app.repository;

import com.example.fic-trading-app.entity.Bond;
import com.example.fic-trading-app.entity.Bond.BondStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BondRepository extends JpaRepository<Bond, Long> {

    List<Bond> findByStatus(BondStatus status);

    @Query("SELECT b FROM Bond b WHERE b.status = 'ACTIVE' AND b.maturityDate BETWEEN CURRENT_DATE AND CURRENT_DATE + 5")
    List<Bond> findMaturingInNext5Days();

    List<Bond> findByStatusAndMaturityDateBefore(BondStatus status, LocalDate date);
}
