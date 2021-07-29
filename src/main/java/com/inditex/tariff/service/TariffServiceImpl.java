package com.inditex.tariff.service;

import com.inditex.tariff.controller.response.TariffResponse;
import com.inditex.tariff.model.Price;
import com.inditex.tariff.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TariffServiceImpl implements TariffService {

    private final PricesRepository pricesRepository;

    private final ModelMapper modelMapper;

    @Override
    public TariffResponse getApplicableProductTariff(Integer brandId, Integer productId, String applicationDate) {
        return modelMapper.map(
                pricesRepository.findApplicablePrices(brandId, productId, applicationDate).orElse(new Price()),
                TariffResponse.class);
    }
}
