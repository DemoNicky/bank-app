package com.dobudobu.bankapp.Service;

import com.dobudobu.bankapp.DTO.RegisterCustomerDTO;
import com.dobudobu.bankapp.DTO.ResponseGetCustomerDTO;
import com.dobudobu.bankapp.Entity.Account;
import com.dobudobu.bankapp.Entity.Customer;
import com.dobudobu.bankapp.Repository.CustomerRepository;
import com.dobudobu.bankapp.Service.ServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<ResponseGetCustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<ResponseGetCustomerDTO> response = customers.stream().map((p) -> {
            ResponseGetCustomerDTO responseGetCustomerDTO = new ResponseGetCustomerDTO();
            responseGetCustomerDTO.setFirstName(p.getFirstName());
            responseGetCustomerDTO.setLastName(p.getLastName());
            responseGetCustomerDTO.setTanggalLahir(p.getTanggalLahir());
            responseGetCustomerDTO.setAlamat(p.getAlamat());
            responseGetCustomerDTO.setNoTelp(p.getNoTelp());
            responseGetCustomerDTO.setEmail(p.getEmail());
            responseGetCustomerDTO.setTypeAcc(p.getAccount().getTypeAcc());
            responseGetCustomerDTO.setSaldo(p.getAccount().getSaldo());
            responseGetCustomerDTO.setExpiredAcc(p.getAccount().getExpiredAccount());

            return responseGetCustomerDTO;
        }).collect(Collectors.toList());
        return response;
    }

    @Override
    public void registerCustomer(RegisterCustomerDTO registerCustomerDTO) {
        Account account = new Account();
        Customer customer = new Customer();
        customer.setFirstName(registerCustomerDTO.getFirstName());
        customer.setLastName(registerCustomerDTO.getLastName());
        customer.setTanggalLahir(registerCustomerDTO.getTanggalLahir());
        customer.setAlamat(registerCustomerDTO.getAlamat());
        customer.setNoTelp(registerCustomerDTO.getNoTelp());
        customer.setEmail(registerCustomerDTO.getEmail());
        account.setTypeAcc(registerCustomerDTO.getTypeAcc());
        account.setSaldo(registerCustomerDTO.getSaldo());
        account.setExpiredAccount(LocalDate.now().plus(5, ChronoUnit.YEARS));
        customer.setAccount(account);
        customerRepository.save(customer);
    }
}
