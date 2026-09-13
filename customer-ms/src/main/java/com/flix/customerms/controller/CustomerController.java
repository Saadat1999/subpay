package com.flix.customerms.controller;

import com.flix.customerms.dto.CustomerRequestDto;
import com.flix.customerms.dto.CustomerResponseDto;
import com.flix.customerms.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto requestDto) {
        return ResponseEntity.ok(customerService.save(requestDto));
    }

    @GetMapping("/user")
    public ResponseEntity<CustomerResponseDto> getCustomer(@RequestHeader("X-Customer-Id") Long id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }
}
