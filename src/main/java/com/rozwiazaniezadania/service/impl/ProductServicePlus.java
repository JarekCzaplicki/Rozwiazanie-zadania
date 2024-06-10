package com.rozwiazaniezadania.service.impl;

import com.rozwiazaniezadania.model.Produkt;
import com.rozwiazaniezadania.service.interfaces.ProductService;
import com.rozwiazaniezadania.util.CreateProducts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@Profile("plus")
public class ProductServicePlus extends ProductServiceStart {
    @Value("${vatRate}")
    private Double vatRate;

    public ProductServicePlus(CreateProducts createProducts, MessageSource messageSource) {
        super(createProducts, messageSource);
    }

    @Override
    public void print() {

        super.print();
        System.out.println(
                getMessageSource().getMessage(
                        "price_of_all_products_plus_vat"
                        , new Object[]{getSummaryPrice() + (getSummaryPrice()*vatRate)}
                        , Locale.forLanguageTag(getLocale())
                )
        );
    }

    public Double getVatRate() {
        return vatRate;
    }
}
