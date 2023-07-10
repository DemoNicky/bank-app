package com.dobudobu.bankapp.Service.ServiceImpl;

import com.dobudobu.bankapp.DTO.RegisterCustomerDTO;
import com.dobudobu.bankapp.DTO.ResponseGetCustomerDTO;

import java.util.List;

public interface CustomerServiceImpl {


    List<ResponseGetCustomerDTO> getAll();

    void registerCustomer(RegisterCustomerDTO registerCustomerDTO);
}
