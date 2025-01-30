package com.example.fic_trading_app.service;

import com.example.fic_trading_app.entity.Bond;
import com.example.fic_trading_app.repository.BondRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Service
public class BondService {

    private final BondRepository bondRepository;

    public BondService(BondRepository bondRepository) {
        this.bondRepository = bondRepository;
    }

    public List<Bond> getAllActiveBonds() {
        return bondRepository.findByStatus(Bond.BondStatus.ACTIVE);
    }

    public List<Bond> getBondsMaturingInNext5Days() {
        LocalDate endDate = LocalDate.now().plusDays(5);
        return bondRepository.findMaturingInNext5Days(endDate);
    }
}
