package com.ratenok.accounting.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ratenok.accounting.exception.ValidationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Account {
    @Id
    private Long id;

    private BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "account", orphanRemoval = true)
    private List<AccountTransaction> transactions;
}
