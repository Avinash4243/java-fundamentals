package com.example.javafundamentalslearning.java8.function;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {
        //Special case of Function where we need to specify single generic type if both are same
        UnaryOperator<Integer> unaryOperator = x -> x * 2;
        System.out.println(unaryOperator.apply(5));//10
        UnaryOperator<String> stringUnaryOperator = x -> "Hello" + x;
        System.out.println(stringUnaryOperator.apply(" Avinash"));

        //On similar line where all three types of BiFunction are same we can use this
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y * 2;
        System.out.println(binaryOperator.apply(5, 6));
    }
}
