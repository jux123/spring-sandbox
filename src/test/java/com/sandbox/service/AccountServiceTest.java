package com.sandbox.service;

import com.sandbox.domain.Account;
import com.sandbox.domain.AccountType;
import com.sandbox.model.AccountDto;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountServiceTest {

    @Test
    public void testCreateAccount() {
        AccountDto accountDto = new AccountDto(null, "John Doe", "john.doe@example.com", AccountType.INDIVIDUAL, null, null);
        Account account = new Account(accountDto);

        assertThat(account.name(), is("John Doe"));
    }
}
