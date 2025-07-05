package com.easybank.easybank.utils;

public enum BalanceStatus {
    ACTIVE("active"),
    FROZEN("frozen"),
    CLOSED("closed")
    ;
    private final String status;

    BalanceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
