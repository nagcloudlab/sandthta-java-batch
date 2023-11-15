package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger("mts");
    private DataSource dataSource;

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        LOGGER.info("JdbcAccountRepository component instance created");
    }

    @Override
    public Account loadAccount(String accountNumber) {
        LOGGER.info("loading account - {}", accountNumber);
        Connection connection = null;
        try {
            // get database connection
            connection = dataSource.getConnection();
            // Prepare SQL query
            String sql = "select * from accounts where number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accountNumber);
            // Execute the query
            ResultSet rs = ps.executeQuery();
            Account account = null;
            if (rs.next()) {
                account = new Account(accountNumber);
                account.setBalance(rs.getDouble("balance"));
                return account;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public Account updateAccount(Account account) {
        LOGGER.info("updating account - {}", account.getNumber());
        Connection connection = null;
        try {
            // get database connection
            connection = dataSource.getConnection();
            // Prepare SQL query
            String sql = "update accounts set balance=? where number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getNumber());
            // Execute the query
            int rowCount = ps.executeUpdate();
            if (rowCount == 1) {
                LOGGER.info("Successfully updated account");
                return account;
            } else {
                LOGGER.error("Failed to update account");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
