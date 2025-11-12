package com.example.javafundamentalslearning.java8.predicates;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> isAdditionEven = (a, b) -> (a+b)%2 == 0;
        System.out.println(isAdditionEven.test(1, 2));
    }
}
