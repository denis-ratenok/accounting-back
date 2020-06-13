package com.ratenok.accounting.repository;

import com.ratenok.accounting.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
