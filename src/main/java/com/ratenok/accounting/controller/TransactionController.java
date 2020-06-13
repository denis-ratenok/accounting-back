package com.ratenok.accounting.controller;

import com.ratenok.accounting.domain.AccountTransaction;
import com.ratenok.accounting.dto.TransactionDto;
import com.ratenok.accounting.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/transactions")
    public List<TransactionDto> getAccountTransactions() {
        return transactionService.getAll().stream().map(TransactionDto::from).collect(Collectors.toList());
    }

    @PostMapping("/transactions")
    public TransactionDto addTransaction(@RequestBody TransactionDto transactionDto) {
        AccountTransaction saved = transactionService.save(AccountTransaction.from(transactionDto));
        return TransactionDto.from(saved);
    }

    @GetMapping("/transactions/{id}")
    public TransactionDto getAccountTransactions(@PathVariable UUID id) {
        return TransactionDto.from(transactionService.getOne(id));
    }

}
