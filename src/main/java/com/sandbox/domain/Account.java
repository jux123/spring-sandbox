package com.sandbox.domain;

import java.util.UUID;

public record Account(UUID id, String name, String email, AccountType accountType) {
}
