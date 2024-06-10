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
@Profile("start")
public class ProductServiceStart implements ProductService {
    @Value("${locale}")
    private String locale;
    private final CreateProducts createProducts;
    private final MessageSource messageSource;
    private Double summaryPrice = 0.0D;
    public ProductServiceStart(CreateProducts createProducts, MessageSource messageSource) {
        this.createProducts = createProducts;
        this.messageSource = messageSource;
    }

    @Override
    public void print() {
        List<Produkt> products = createProducts.create(5);
        for (Produkt produkt : products) {
            summaryPrice += produkt.getPrice();
        }
        System.out.println(
                messageSource.getMessage(
                        "price_of_all_products"
                        , new Object[]{summaryPrice}
                        , Locale.forLanguageTag(locale)
                )
        );
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public Double getSummaryPrice() {
        return summaryPrice;
    }

    public String getLocale() {
        return locale;
    }
}
