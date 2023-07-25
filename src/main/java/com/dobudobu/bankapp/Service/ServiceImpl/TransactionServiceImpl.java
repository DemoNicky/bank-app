package com.dobudobu.bankapp.Service.ServiceImpl;

import com.dobudobu.bankapp.DTO.ResponseTransactionDTO;
import com.dobudobu.bankapp.DTO.TransactionCustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionServiceImpl {
    List<ResponseTransactionDTO> getAllTransaction();

    ResponseEntity<Void> postTheTransaction(TransactionCustomerDTO transactionCustomerDTO);
}
