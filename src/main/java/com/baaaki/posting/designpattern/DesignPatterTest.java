package com.baaaki.posting.designpattern;

import com.baaaki.posting.designpattern.builder.Coffee;
import com.baaaki.posting.designpattern.builder.CoffeeWithLombok;

public class DesignPatterTest {

    public void test() {
//        // 기본적인 생성자
//        Coffee iceAmericano = new Coffee("IceAmericano", 1000, 1000, 10, 2, "Kenya");
//
//        //JavaBeans 패턴
//        Coffee hotAmericano = new Coffee("HotAmericano", 1000);
//        hotAmericano.setCalories(1000);
//        hotAmericano.setFat(10);
//        hotAmericano.setSodium(5);
//        hotAmericano.setOrigin("Kenya");

        Coffee coffeeByBuilder = new Coffee.Builder("Latte", 1500)
                .calories(1000)
                .fat(10)
                .sodium(3)
                .origin("Ethiopia")
                .build();

        CoffeeWithLombok coffeeWithLombok = CoffeeWithLombok.builder("VanillaLatte", 2000)
                .fat(10)
                .sodium(8)
                .origin("Ethiopia")
                .build();

        System.out.println(coffeeWithLombok);
    }
}
