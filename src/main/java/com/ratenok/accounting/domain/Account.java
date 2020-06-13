package com.ratenok.accounting.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Data
public class Account {
    @Id
    private Long id;

    private final BigDecimal balance;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private final List<AccountTransaction> transactions;

}
