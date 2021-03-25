package com.imedia24.demo.service;

import com.imedia24.demo.models.Currency;
import com.imedia24.demo.models.Product;
import com.imedia24.demo.models.Rate;
import com.imedia24.demo.openFeign.CurrencyExchange;
import com.imedia24.demo.repositories.ProductRepository;
import com.imedia24.demo.repositories.RateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final RateRepository rateRepository;
    private final CurrencyExchange currencyExchange;

    public List<Rate> setCurrenciesIntoProduct(Product product){
        Currency currency = currencyExchange.getCurrency();
        double price = product.getPrice();
        List<Rate> rates = new ArrayList<>();
        currency.getRates().forEach((name,value) ->{
            Rate rate = Rate.builder().name(name).value(value*price).build();
            rates.add(rate);
            rateRepository.save(rate);
        });
        return rates;
    }



}
