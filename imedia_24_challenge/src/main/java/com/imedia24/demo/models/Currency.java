package com.imedia24.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    /***
     * This Class is just to bind data from Fixer before persist it into Product class
     */
    private long id;
    private boolean success;
    private Timestamp timestamp;
    private String base;
    private LocalDate date;
    private Map<String, Double> rates;
}
