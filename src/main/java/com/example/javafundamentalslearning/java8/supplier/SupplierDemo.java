package com.example.javafundamentalslearning.java8.supplier;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World";
        System.out.println(supplier.get());

        Predicate<Integer> isEven = i -> i % 2 == 0;
        Function<Integer, Integer> doubleIt = i -> i * 2;
        Consumer<String> consumer = System.out::println;
        Supplier<Integer> supplier2 = () -> 4;

        if (isEven.test(supplier2.get())) {
            consumer.accept("Yes it is even");
        }else{
            consumer.accept("No it is odd");
        }
    }
}
