package com.example.springboot.learnspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CurrencyConfigurationController {


    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;

    CurrencyConfigurationController() {

    }

    @RequestMapping("currency-config")
    public CurrencyServiceConfiguration getCurrencyServiceConfiguration() {
        return currencyServiceConfiguration;
    }



}
