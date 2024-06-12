package com.platzi_market.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;

}
