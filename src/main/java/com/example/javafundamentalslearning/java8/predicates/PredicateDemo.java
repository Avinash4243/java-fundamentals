package com.example.javafundamentalslearning.java8.predicates;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", "US");
        Person person2 = new Person("Avi", "INDIA");
        Person person3 = new Person("Vinod", "INDIA");
        Person person4 = new Person("Andy", "US");
        Person person5 = new Person("Altman", "US");
        Person person6 = new Person("Sam", "US");
        List<Person> personlist = Arrays.asList(person1, person2, person3, person4, person5, person6);
        // Predicate is a functional interface (boolean-valued function)
        Predicate<Person> fromUS = (p) -> Objects.equals(p.getCity(), "US");
        Predicate<Person> nameStartsWithA = (p) -> Objects.equals(p.getName().charAt(0), 'A');
        System.out.println("Persons = " + personlist.stream().filter(
                fromUS.and(nameStartsWithA)).map(Person::getName).toList());
    }
}

class Person {
    private final String name;
    private final String city;
    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public String getName() {
        return this.name;
    }
    public String getCity() {
        return this.city;
    }
}
