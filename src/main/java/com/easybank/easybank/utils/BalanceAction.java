package com.easybank.easybank.utils;

public enum BalanceAction {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw"),
    FREEZE("freeze"),
    ADJUST("adjust")
    ;
    private final String action;

    BalanceAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}
