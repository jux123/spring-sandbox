package com.sandbox.service;

import com.sandbox.domain.Account;
import com.sandbox.model.AccountDto;
import com.sandbox.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account(null, accountDto);
        Account savedAccount = accountRepository.save(account);
        return new AccountDto(savedAccount);
    }

    public AccountDto getAccountById(UUID id) {
        return accountRepository.findById(id)
                .map(AccountDto::new)
                .orElseThrow();
    }

    public List<AccountDto> getAllAccounts() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false)
                .map(AccountDto::new)
                .toList();
    }

    public void updateAccount(UUID id, AccountDto accountDto) {
        Account account = new Account(id, accountDto);
        if (accountRepository.existsById(id)) {
            accountRepository.save(account);
        } else {
            throw new IllegalArgumentException("Account with id " + id + " does not exist.");
        }
    }
}
