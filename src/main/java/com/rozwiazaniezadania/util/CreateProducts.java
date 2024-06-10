package com.rozwiazaniezadania.util;

import com.rozwiazaniezadania.model.Produkt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateProducts {
    private static final double MIN_PRICE = 50;
    private static final double MAX_PRICE = 500;
    List<Produkt> listOfProducts = new ArrayList<>();

    public List<Produkt> create(int numberOfProducts){
        for (int i = 1; i <= numberOfProducts; i++) {
            listOfProducts.add(new Produkt("Product_" + i,
                    Math.random() * (MAX_PRICE - MIN_PRICE) + MIN_PRICE));
        }
        return listOfProducts;
    }
}
