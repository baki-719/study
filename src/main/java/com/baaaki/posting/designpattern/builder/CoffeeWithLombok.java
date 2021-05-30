package com.baaaki.posting.designpattern.builder;

import lombok.Builder;

@Builder(builderMethodName = "hiddenBuilder")
public class CoffeeWithLombok {
    private final String name;
    private final int price;
    private int calories;
    private int fat;
    private int sodium;
    private String origin;

    public static CoffeeWithLombokBuilder builder(String name, int price) {
        return hiddenBuilder()
                .name(name)
                .price(price);
    }
}
