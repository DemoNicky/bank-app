package com.dobudobu.bankapp.Controller;

import com.dobudobu.bankapp.DTO.RegisterCustomerDTO;
import com.dobudobu.bankapp.DTO.ResponseGetCustomerDTO;
import com.dobudobu.bankapp.Service.ServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("get")
    public List<ResponseGetCustomerDTO> getCustomer(){
        return customerService.getAll();
    }

    @PostMapping("post")
    public ResponseEntity<Void> regisCustomer(@RequestBody RegisterCustomerDTO registerCustomerDTO){
        customerService.registerCustomer(registerCustomerDTO);
        return ResponseEntity.created(URI.create("customer/post")).build();
    }

}
