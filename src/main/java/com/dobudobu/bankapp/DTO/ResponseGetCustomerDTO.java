package com.dobudobu.bankapp.DTO;

import com.dobudobu.bankapp.Entity.Account;
import com.dobudobu.bankapp.Entity.TypeAcc;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ResponseGetCustomerDTO {
    private String firstName;

    private String lastName;

    private LocalDate tanggalLahir;

    private String alamat;

    private String noTelp;

    private String email;

    private TypeAcc typeAcc;

    private Long saldo;

    private LocalDate expiredAcc;
}
