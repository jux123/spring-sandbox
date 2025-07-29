package com.sandbox.model;

import com.sandbox.domain.Account;
import com.sandbox.domain.AccountType;

import java.util.UUID;

public record AccountDto(UUID id, String name, String email, AccountType accountType) {
    public AccountDto(Account account) {
        this(account.id(), account.name(), account.email(), account.accountType());
    }
}
