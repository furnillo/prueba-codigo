package com.inditex.tariff.service;

import com.inditex.tariff.controller.response.TariffResponse;

public interface TariffService {

    TariffResponse getApplicableProductTariff(Integer brandId, Integer productId, String applicationDate);
}
