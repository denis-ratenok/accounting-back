package com.ratenok.accounting.service;

import com.ratenok.accounting.domain.AccountTransaction;
import com.ratenok.accounting.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public AccountTransaction save(AccountTransaction accTransaction) {
        return transactionRepository.save(accTransaction);
    }

    public List<AccountTransaction> getAll() {
        return transactionRepository.findAll();
    }

    public AccountTransaction getOne(UUID id) {
        return transactionRepository.getOne(id);
    }
}
