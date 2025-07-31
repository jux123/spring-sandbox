package com.sandbox.service;

import com.sandbox.domain.AccountType;
import com.sandbox.model.AccountDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
public class AccountServiceTest {

    @Container
    static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
                    .withDatabaseName("cdr")
                    .withUsername("cdr_user")
                    .withPassword("pass");

    @DynamicPropertySource
    static void setPostgreSQLProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
    }

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
        assertThat(allAccounts.get(0).name(), is("Test User"));
        assertThat(allAccounts.get(0).id().toString(), is(createdAccount.id().toString()));

    }
}