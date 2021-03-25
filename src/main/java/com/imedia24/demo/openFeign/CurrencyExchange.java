package com.imedia24.demo.openFeign;

import com.imedia24.demo.models.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Fixer",url = "http://data.fixer.io/api/latest?access_key=468cae86b6d8b47102104320aed50999&base=EUR&symbols=MAD,EUR,USD",configuration = Currency.class)
public interface CurrencyExchange {

     @GetMapping
     Currency getCurrency();
}
