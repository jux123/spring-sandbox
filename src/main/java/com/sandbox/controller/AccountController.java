package com.sandbox.controller;

import com.sandbox.domain.Account;
import com.sandbox.domain.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/list", method = GET)
    public List<Account> getAccounts() {
        log.info("getAccounts");
        Account account = new Account(UUID.randomUUID(), "John Doe", "johndoe@me.com", AccountType.INDIVIDUAL);
        return List.of(account);
    }

    @RequestMapping(value = "/{accountId}", method = GET)
    public Account getAccount(@PathVariable("accountId") UUID accountId) {
        log.info("getAccount {}", accountId);
        return new Account(accountId, "John Doe", "johndoe@me.com", AccountType.INDIVIDUAL);
    }
}
