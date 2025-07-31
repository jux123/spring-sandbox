package com.sandbox.controller;

import com.sandbox.domain.AccountType;
import com.sandbox.model.AccountDto;
import com.sandbox.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController("/account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/list", method = GET)
    public List<AccountDto> getAccounts() {
        log.info("getAccounts");
        return accountService.getAllAccounts();
    }

    @GetMapping(value = "/{accountId}")
    public AccountDto getAccount(@PathVariable("accountId") UUID accountId) {
        log.info("getAccount {}", accountId);
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    public AccountDto createAccount(@RequestBody AccountDto account) {
        log.info("createAccount: {}", account);
        return accountService.createAccount(account);
    }

    @PutMapping("/{accountId}")
    public void updateAccount(@PathVariable("accountId") UUID accountId, @RequestBody AccountDto account) {
        log.info("updateAccount {}: {}", accountId, account);
        accountService.updateAccount(accountId, account);
    }
}
