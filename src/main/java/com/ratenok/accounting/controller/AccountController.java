package com.ratenok.accounting.controller;

import com.ratenok.accounting.domain.Account;
import com.ratenok.accounting.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/balance")
    public BigDecimal getBalance() {
        return accountService.getBalance();
    }

}
