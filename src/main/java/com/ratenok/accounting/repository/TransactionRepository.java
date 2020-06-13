package com.ratenok.accounting.repository;

import com.ratenok.accounting.domain.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<AccountTransaction, UUID> {
}
