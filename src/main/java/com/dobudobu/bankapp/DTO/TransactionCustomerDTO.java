package com.dobudobu.bankapp.DTO;

import com.dobudobu.bankapp.Entity.Account;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionCustomerDTO {

    @NotNull
    private String transactionType;

    @NotNull
    private Long amount;

    @NotNull
    private Account account;
}
