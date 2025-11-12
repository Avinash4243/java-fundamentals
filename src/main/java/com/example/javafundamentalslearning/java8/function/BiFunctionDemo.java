package com.example.javafundamentalslearning.java8.function;

import java.util.function.BiFunction;

public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> addTwoNumber = Integer::sum;
        Integer result = addTwoNumber.apply(1, 2);
        System.out.println(result);
    }
}
