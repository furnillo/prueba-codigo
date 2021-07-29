package com.inditex.tariff.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class TariffResponse {

    private Integer productId;
    private Integer priceList;
    private Integer brandId;
    private Date startDate;
    private Date endDate;
    private Double price;
}
