package com.inditex.tariff.repository;

import com.inditex.tariff.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PricesRepository extends CrudRepository<Price, Integer> {
    String QUERY = "SELECT * FROM PRICES p WHERE p.brand_id = ?1 " +
            "AND p.product_id = ?2 AND ?3 >= p.start_date AND ?3 <= p.end_date ORDER BY p.priority DESC LIMIT 1";

    @Query( nativeQuery = true, value = QUERY)
    Optional<Price> findApplicablePrices(Integer brandId, Integer productId, String applicationDate);
}
