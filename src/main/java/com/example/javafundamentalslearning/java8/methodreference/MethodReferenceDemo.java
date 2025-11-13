package com.example.javafundamentalslearning.java8.methodreference;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Avinash", "Atul", "Krishna");
        nameList.forEach(System.out::println);
        //constructor reference
        nameList.stream().map(GreetPerson::new).toList();
    }
}

class GreetPerson {
    String name;
    public GreetPerson(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
