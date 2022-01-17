package com.example.spring_tx_anno.service;

public interface AccountService {
    public void transfer(String outMan, String inMan, double moneyIn);
}
