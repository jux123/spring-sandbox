package com.sandbox.domain;

import com.sandbox.model.AccountDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Column;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Account(
        @Id UUID id,
        String name,
        String email,
        AccountType accountType,

        @ReadOnlyProperty
        @Column("created_at")
        OffsetDateTime createdAt,

        OffsetDateTime updatedAt
) {
    public Account(AccountDto accountDto) {
        this(accountDto.id(), accountDto.name(), accountDto.email(), accountDto.accountType(), null, OffsetDateTime.now());
    }

    public Account(UUID id, AccountDto accountDto) {
        this(id, accountDto.name(), accountDto.email(), accountDto.accountType(), null, OffsetDateTime.now());
    }
}
