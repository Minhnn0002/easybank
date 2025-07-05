package com.easybank.easybank.model;

import com.easybank.easybank.utils.BalanceStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "balance")
@Getter
@Setter
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountType;
    private String currency;
    private BigDecimal amount;
    private String status;
    private Long version;
    private Timestamp lastUpdated;
    @OneToOne(mappedBy = "balance", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private BalanceHistory balanceHistory;


    public void setHistory(BalanceHistory balanceHistory) {
        this.balanceHistory = balanceHistory;
        balanceHistory.setBalance(this);
    }
}
