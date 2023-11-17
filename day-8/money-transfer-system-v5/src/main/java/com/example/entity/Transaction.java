package com.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TRANSACTION_HISTORY")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double amount;
    @Enumerated(EnumType.STRING)
    private TxnType type;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;
}
