package com.example.fic-trading-app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bonds")
public class Bond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate maturityDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BondStatus status;

    public Bond() {}

    public Bond(String name, LocalDate maturityDate, BondStatus status) {
        this.name = name;
        this.maturityDate = maturityDate;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public LocalDate getMaturityDate() { return maturityDate; }
    public BondStatus getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setMaturityDate(LocalDate maturityDate) { this.maturityDate = maturityDate; }
    public void setStatus(BondStatus status) { this.status = status; }

    public enum BondStatus {
        ACTIVE, MATURED
    }
}
