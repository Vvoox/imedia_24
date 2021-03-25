package com.imedia24.demo.openFeign;

import com.imedia24.demo.models.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "Fixer",url = "http://data.fixer.io/api/latest",configuration = Currency.class)
public interface CurrencyExchange {

     @GetMapping()
     Currency getCurrency(@RequestParam String access_key,@RequestParam String base, @RequestParam String symbols);
}
