package com.sandbox.domain;

import com.sandbox.model.AccountDto;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public record Account(@Id UUID id, String name, String email, AccountType accountType) {
    public Account(AccountDto accountDto) {
        this(accountDto.id(), accountDto.name(), accountDto.email(), accountDto.accountType());
    }

    public Account(UUID id, AccountDto accountDto) {
        this(id, accountDto.name(), accountDto.email(), accountDto.accountType());
    }
}
