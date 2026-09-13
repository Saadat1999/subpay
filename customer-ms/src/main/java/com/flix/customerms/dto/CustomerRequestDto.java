package com.flix.customerms.dto;

import com.flix.customerms.entity.Customer;

import java.time.LocalDate;
import java.util.Map;

public record CustomerRequestDto(String tenant_id, String name, String email, String password,
                                 String billingAddress, String paymentMethod, Map<String, Object> metadata) {

    public static Customer entityOf(CustomerRequestDto requestDto) {
            return new Customer(null, requestDto.tenant_id(), requestDto.name(), requestDto.password(), requestDto.email(),
                    requestDto.billingAddress(), requestDto.paymentMethod(), requestDto.metadata(), LocalDate.now(), LocalDate.now());
    }
}
