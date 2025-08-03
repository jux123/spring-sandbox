package com.sandbox.service;

import com.sandbox.TestConfig;
import com.sandbox.domain.AccountType;
import com.sandbox.model.AccountDto;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Testcontainers
@SpringBootTest(classes = { TestConfig.class })
@Tag("integration")
public class AccountServiceTestIT {

    @Autowired
    DataSource dataSource;

    @Autowired
    AccountService accountService;

    @Test
    public void testCreateAccount() {
        AccountDto accountDto = new AccountDto(null, "Test User", "test@mail.ee", AccountType.INDIVIDUAL, null, null);
        AccountDto createdAccount = accountService.createAccount(accountDto);

        assertThat(createdAccount.id(), notNullValue());

        List<AccountDto> allAccounts = accountService.getAllAccounts();
        assertThat(allAccounts, hasSize(1));
        assertThat(allAccounts.getFirst().name(), is("Test User"));
        assertThat(Objects.requireNonNull(allAccounts.getFirst().id()).toString(), is(createdAccount.id().toString()));

    }
}