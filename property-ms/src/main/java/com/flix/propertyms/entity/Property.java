package com.flix.propertyms.entity;

import com.flix.propertyms.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "property", schema = "subpay_property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_seq")
    @SequenceGenerator(name = "property_seq", sequenceName = "property_seq", schema = "subpay_property", allocationSize = 1)
    private Long id;
    private String tenant_id;
    private String tenant_name;
    private String location;
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
