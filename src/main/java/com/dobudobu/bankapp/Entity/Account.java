package com.dobudobu.bankapp.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    private String id;

    @Enumerated(EnumType.STRING)
    private TypeAcc typeAcc;

    @Column(name = "saldo")
    private Long saldo;

    @Column(name = "expired_acc")
    private LocalDate expiredAccount;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transaction;

}
