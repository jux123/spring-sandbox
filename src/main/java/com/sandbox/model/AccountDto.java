package com.sandbox.model;

import com.sandbox.domain.Account;
import com.sandbox.domain.AccountType;
import jakarta.annotation.Nullable;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AccountDto(
        @Nullable UUID id,
        String name,
        String email,
        AccountType accountType,
        @Nullable OffsetDateTime createdAt,
        @Nullable OffsetDateTime updatedAt
        ) {
    public AccountDto(Account account) {
        this(account.id(), account.name(), account.email(), account.accountType(), account.createdAt(), account.updatedAt());
    }
}
