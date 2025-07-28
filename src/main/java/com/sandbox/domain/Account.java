package com.sandbox.domain;

public record Account(String accountId, String name, String email, AccountType accountType) {
}
