package com.example.fic_trading_app.repository;

import com.example.fic_trading_app.entity.Bond;
import com.example.fic_trading_app.entity.Bond.BondStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BondRepository extends JpaRepository<Bond, Long> {

    List<Bond> findByStatus(BondStatus status);

    @Query("SELECT b FROM Bond b WHERE b.maturityDate BETWEEN CURRENT_DATE AND :endDate AND b.status = 'ACTIVE'")
    List<Bond> findMaturingInNext5Days(@Param("endDate") LocalDate endDate);
}
