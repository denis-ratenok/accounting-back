package com.ratenok.accounting.dto;

import com.ratenok.accounting.domain.AccountTransaction;
import com.ratenok.accounting.enumeration.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@NoArgsConstructor(force = true)
public class TransactionDto {
    private UUID id;
    @NonNull
    private final TransactionType type;
    @NonNull
    private final BigDecimal amount;
    private Instant createdDate = Instant.now();

    public static TransactionDto from(AccountTransaction at) {
        return new TransactionDto(at.getId(), at.getType(), at.getAmount(), at.getCreatedDate());
    }
}
