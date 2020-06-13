package com.ratenok.accounting.controller;

import com.ratenok.accounting.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    @GetMapping("/transactions")
    public List<TransactionDto> getAccountTransactions() {
        return null;
    }

    @PostMapping("/transactions")
    public TransactionDto addTask(@RequestBody TransactionDto task) {
        return null;
    }

}
