package com.example.repository;

import com.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("jdbcAccountRepositoryWithTemplate")
public class JdbcAccountRepositoryWithTemplate implements AccountRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepositoryWithTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return jdbcTemplate.queryForObject("SELECT * FROM accounts WHERE number=?", (rs, index) -> {
            return new Account(rs.getString("number"), rs.getDouble("balance"));
        }, accountNumber);
    }
    @Override
    public Account updateAccount(Account account) {
        jdbcTemplate.update("update accounts set balance=? where number=?",account.getBalance(),account.getNumber());
        return account;
    }
}
