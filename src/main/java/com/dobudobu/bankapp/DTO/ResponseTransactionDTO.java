package com.dobudobu.bankapp.DTO;

import com.dobudobu.bankapp.Entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseTransactionDTO {

    private String transactionType;

    private Long amount;

    private LocalDate transactionDate;

    private Account account;

}
