package com.dobudobu.bankapp.Controller;

import com.dobudobu.bankapp.DTO.ResponseTransactionDTO;
import com.dobudobu.bankapp.DTO.TransactionCustomerDTO;
import com.dobudobu.bankapp.Service.ServiceImpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping("get")
    public List<ResponseTransactionDTO> getTransaction(){
        return transactionService.getAllTransaction();
    }

    @PostMapping
    public ResponseEntity<Void> postTransaction(@RequestBody TransactionCustomerDTO transactionCustomerDTO){
        return transactionService.postTheTransaction(transactionCustomerDTO);
    }
}
