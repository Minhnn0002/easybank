package com.easybank.easybank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="balance_history")
@Setter
@Getter
public class BalanceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal changeAmount;
    private BigDecimal newBalance;
    private String action;
    private Timestamp createdAt;
    private String createdBy;
    private String reference_id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "balance_id", referencedColumnName = "id")
    private Balance balance;

}
