package com.sandbox.domain;

import com.sandbox.model.AccountDto;

import java.util.UUID;

public record Account(UUID id, String name, String email, AccountType accountType) {
    public Account(AccountDto accountDto) {
        this(accountDto.id(), accountDto.name(), accountDto.email(), accountDto.accountType());
    }
}
