package com.example.javafundamentalslearning.java8.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = s-> System.out.println(s);
        Consumer<List<Integer>> listConsumer = s -> {
            for (Integer integer : s) {
                System.out.println(integer);
            }
        };

        listConsumer.accept(Arrays.asList(1,2,3,4));
        consumer.accept("Avinash");
    }
}
