package com.dobudobu.bankapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "tbl_transaction")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "amount", length = 200, nullable = false)
    private Long amount;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false,
            referencedColumnName = "id")
    private Account account;
}
