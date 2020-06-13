package com.ratenok.accounting.domain;

import com.ratenok.accounting.enumeration.TransactionType;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private final TransactionType type;

    @Column(nullable = false)
    private final BigDecimal amount;

    @Column(nullable = false)
    private Instant createdDate = Instant.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "account", nullable = false)
    @NotNull
    private Account account;
}
