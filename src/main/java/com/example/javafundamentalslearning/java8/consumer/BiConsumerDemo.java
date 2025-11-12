package com.example.javafundamentalslearning.java8.consumer;

import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = (a, b) -> System.out.println(a + b);
        biConsumer.accept("Avinash", 9971);
    }
}
