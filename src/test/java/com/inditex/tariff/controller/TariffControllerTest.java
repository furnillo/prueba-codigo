package com.inditex.tariff.controller;

import com.inditex.tariff.controller.response.TariffResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TariffControllerTest {

    private static final String BRAND_ID = "1";
    private static final String URL = "/v1/tariffs/{brandId}?productId=35455";
    private static final String TEST1_REQUEST = URL.concat("&applicationDate=2020-06-14 10:00:00");
    private static final String TEST2_REQUEST = URL.concat("&applicationDate=2020-06-14 16:00:00");
    private static final String TEST3_REQUEST = URL.concat("&applicationDate=2020-06-14 21:00:00");
    private static final String TEST4_REQUEST = URL.concat("&applicationDate=2020-06-15 10:00:00");
    private static final String TEST5_REQUEST = URL.concat("&applicationDate=2020-06-16 21:00:00");

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testOneOk() {
        final Double expectedPrice = 35.50;

        ResponseEntity<TariffResponse> response = testRestTemplate
                .getForEntity(TEST1_REQUEST, TariffResponse.class, BRAND_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }

    @Test
    public void testTwoOk() {
        final Double expectedPrice = 25.45;

        ResponseEntity<TariffResponse> response = testRestTemplate
                .getForEntity(TEST2_REQUEST, TariffResponse.class, BRAND_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }

    @Test
    public void testThreeOk() {
        final Double expectedPrice = 35.50;

        ResponseEntity<TariffResponse> response = testRestTemplate
                .getForEntity(TEST3_REQUEST, TariffResponse.class, BRAND_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }

    @Test
    public void testFourOk() {
        final Double expectedPrice = 30.50;

        ResponseEntity<TariffResponse> response = testRestTemplate
                .getForEntity(TEST4_REQUEST, TariffResponse.class, BRAND_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }

    @Test
    public void testFiveOk() {
        final Double expectedPrice = 38.95;

        ResponseEntity<TariffResponse> response = testRestTemplate
                .getForEntity(TEST5_REQUEST, TariffResponse.class, BRAND_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getPrice()).isEqualTo(expectedPrice);
    }
}
