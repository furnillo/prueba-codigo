package com.inditex.tariff.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceList;

    @ManyToOne(optional = false)
    @JoinColumn(name="brand_id")
    private Brand brand;

    @DateTimeFormat(pattern = "yyyy-MM-dd-hh.mm.ss")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd-hh.mm.ss")
    private Date endDate;

    private Integer productId;
    private Integer priority;
    private Double price;
    private String curr;
}
