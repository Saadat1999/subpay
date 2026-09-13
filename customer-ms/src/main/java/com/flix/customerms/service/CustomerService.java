package com.flix.customerms.service;

import com.flix.customerms.dto.CustomerRequestDto;
import com.flix.customerms.dto.CustomerResponseDto;
import com.flix.customerms.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDto save(CustomerRequestDto requestDto) {
        try{
            return CustomerResponseDto.responseOf(customerRepository.save(CustomerRequestDto.entityOf(requestDto)));
        } catch (Exception e) {
            log.warn("Failed to process the request: {}", requestDto.email(), e);
            return CustomerResponseDto.emptyOf();
        }
    }

    @Transactional(readOnly = true)
    public CustomerResponseDto getCustomer(Long id) {
        return CustomerResponseDto.responseOf(customerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Customer not found")));
    }
}
