package com.inditex.tariff.controller;

import com.inditex.tariff.controller.response.TariffResponse;
import com.inditex.tariff.service.TariffService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/tariffs")
public class TariffController {

    private final TariffService productService;

    @GetMapping(path = "/{brandId}" , produces = {"application/json"})
    public ResponseEntity<TariffResponse> getTariffInfo(@PathVariable Integer brandId,
                                                        @RequestParam Integer productId,
                                                        @RequestParam("applicationDate")
                                           @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate) {
        TariffResponse response = productService.getApplicableProductTariff(brandId, productId, applicationDate.toString());
        return ResponseEntity.ok().body(response);
    }
}
