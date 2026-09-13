package com.flix.customerms.dto;

import com.flix.customerms.entity.Customer;
import lombok.Builder;

@Builder
public record CustomerResponseDto(Long id, String tenant_id, String name, String email,
                                  String billingAddress, String paymentMethod) {

    public static CustomerResponseDto emptyOf(){
        return CustomerResponseDto.builder().build();
    }

    public static CustomerResponseDto responseOf(Customer customer) {
        return new CustomerResponseDto(customer.getId(), customer.getTenant_id(), customer.getName(),
                customer.getEmail(), customer.getBillingAddress(), customer.getPaymentMethod());
    }
}
