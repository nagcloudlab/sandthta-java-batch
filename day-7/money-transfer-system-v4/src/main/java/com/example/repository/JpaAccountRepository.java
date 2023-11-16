package com.example.repository;

import com.example.model.Account;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component("jpaAccountRepository")
public class JpaAccountRepository implements AccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account loadAccount(String accountNumber) {
        return entityManager.find(Account.class, accountNumber);
    }

    @Override
    public Account updateAccount(Account account) {
        return entityManager.merge(account);
    }
}
