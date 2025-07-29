package com.sandbox.controller;

import com.sandbox.domain.AccountType;
import com.sandbox.model.AccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/list", method = GET)
    public List<AccountDto> getAccounts() {
        log.info("getAccounts");
        AccountDto account = new AccountDto(UUID.randomUUID(), "John Doe", "johndoe@me.com", AccountType.INDIVIDUAL);
        log.info("getAccounts for: {}", account.name());
        return List.of(account);
    }

    @GetMapping(value = "/{accountId}")
    public AccountDto getAccount(@PathVariable("accountId") UUID accountId) {
        log.info("getAccount {}", accountId);
        return new AccountDto(accountId, "John Doe", "johndoe@me.com", AccountType.INDIVIDUAL);
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto account) {
        log.info("createAccount: {}", account);
        return account;
    }

    @PutMapping("/{accountId}")
    public void updateAccount(@PathVariable("accountId") UUID accountId, @RequestBody AccountDto account) {
        log.info("updateAccount {}: {}", accountId, account);
    }
}
