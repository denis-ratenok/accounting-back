package com.ratenok.accounting.service;

import com.ratenok.accounting.domain.AccountTransaction;
import com.ratenok.accounting.enumeration.TransactionType;
import com.ratenok.accounting.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public AccountTransaction save(AccountTransaction accTransaction) {
        AccountTransaction transaction = transactionRepository.save(accTransaction);

        BigDecimal delta = transaction.getType().equals(TransactionType.DEBIT) ? transaction.getAmount() : transaction.getAmount().negate();
        accountService.updateBalance(delta);

        return transaction;
    }

    @Transactional(readOnly = true)
    public List<AccountTransaction> getAll() {
        return transactionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public AccountTransaction getOne(UUID id) {
        return transactionRepository.getOne(id);
    }
}
