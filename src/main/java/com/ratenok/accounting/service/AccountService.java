package com.ratenok.accounting.service;

import com.ratenok.accounting.domain.Account;
import com.ratenok.accounting.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final static long ACCOUNT_ID = 1L;
    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public BigDecimal getBalance() {
        // todo: remove hardcode in order to support multiple accounts
        return accountRepository.getOne(ACCOUNT_ID).getBalance();
    }

    public void updateBalance(BigDecimal delta) {
        Account account = accountRepository.getOne(ACCOUNT_ID);
        account.setBalance(account.getBalance().add(delta));

        accountRepository.save(account);
    }

}
