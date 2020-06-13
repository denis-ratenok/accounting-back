package com.ratenok.accounting.service;

import com.ratenok.accounting.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountService {
    private final AccountRepository accountRepository;


}
