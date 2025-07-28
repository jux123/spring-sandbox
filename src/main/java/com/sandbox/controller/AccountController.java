package com.sandbox.controller;

import com.sandbox.domain.Account;
import com.sandbox.domain.AccountType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("/account")
public class AccountController {

    @GetMapping("/list")
    public List<Account> getAccounts() {
        Account account = new Account("1234", "John Doe", "johndoe@me.com", AccountType.INDIVIDUAL);
        return List.of(account);
    }
}
