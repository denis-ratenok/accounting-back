package com.ratenok.accounting.dto;

import com.ratenok.accounting.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {
    private UUID id;
    @NonNull
    private final TransactionType type;
    @NonNull
    private final BigDecimal amount;
    private Instant createdDate = Instant.now();
}
