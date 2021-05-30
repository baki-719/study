package com.baaaki.posting.designpattern.builder;

public class Coffee {

    private final String name;
    private final int price;
    private int calories;
    private int fat;
    private int sodium;
    private String origin;

    public static class Builder {
        private final String name;
        private final int price;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private String origin = "Ethiopia";

        public Builder(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public Builder calories(int val) {
            this.calories = val;
            return this;
        }

        public Builder fat(int val) {
            this.fat = val;
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = val;
            return this;
        }

        public Builder origin(String val) {
            this.origin = val;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }

    }
    private Coffee (Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.origin = builder.origin;
    }

}
