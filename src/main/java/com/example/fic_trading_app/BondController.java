package com.example.fic_trading_app.controller;

import com.example.fic_trading_app.entity.Bond;
import com.example.fic_trading_app.service.BondService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/bonds")
public class BondController {

    private final BondService bondService;

    @Autowired
    public BondController(BondService bondService) {
        this.bondService = bondService;
    }

    @GetMapping("/active")
    public List<Bond> getActiveBonds() {
        return bondService.getAllActiveBonds();
    }

    @GetMapping("/maturing-in-next-5-days")
    public List<Bond> getBondsMaturingInNext5Days() {
        return bondService.getBondsMaturingInNext5Days();
    }
}
