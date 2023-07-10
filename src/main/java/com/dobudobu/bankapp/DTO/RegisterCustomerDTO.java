package com.dobudobu.bankapp.DTO;

import com.dobudobu.bankapp.Entity.TypeAcc;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RegisterCustomerDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate tanggalLahir;

    @NotNull
    private String alamat;

    @NotNull
    private String noTelp;

    @NotNull
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeAcc typeAcc;

    @NotNull
    @Min(1)
    private Long saldo;

}
