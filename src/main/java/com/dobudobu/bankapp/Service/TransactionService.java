package com.dobudobu.bankapp.Service;

import com.dobudobu.bankapp.DTO.ResponseTransactionDTO;
import com.dobudobu.bankapp.DTO.TransactionCustomerDTO;
import com.dobudobu.bankapp.Entity.Transaction;
import com.dobudobu.bankapp.Repository.TransactionRepository;
import com.dobudobu.bankapp.Service.ServiceImpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService implements TransactionServiceImpl {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<ResponseTransactionDTO> getAllTransaction() {
        List<Transaction> transaction = transactionRepository.findAll();
        List<ResponseTransactionDTO> responseTransactionDTOS = transaction.stream().map((p) -> {
            ResponseTransactionDTO responseTransactionDTO = new ResponseTransactionDTO();
            responseTransactionDTO.setTransactionType(p.getTransactionType().toString());
            responseTransactionDTO.setAmount(p.getAmount());
            responseTransactionDTO.setTransactionDate(p.getTransactionDate());
            responseTransactionDTO.setAccount(p.getAccount());
            return responseTransactionDTO;

        }).collect(Collectors.toList());
        return responseTransactionDTOS;
    }

    @Override
    public ResponseEntity<Void> postTheTransaction(TransactionCustomerDTO transactionCustomerDTO) {

        return null;
    }
}
