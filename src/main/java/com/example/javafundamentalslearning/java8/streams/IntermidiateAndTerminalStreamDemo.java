package com.example.javafundamentalslearning.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermidiateAndTerminalStreamDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Avinash", "Satish", "Vipul", "Abhishek");
        Map<Boolean, List<String>> booleanListMap = names.stream().map(name -> name + " Pandey").collect(
                Collectors.partitioningBy(name -> name.startsWith("A")));
        System.out.println("Person starts with A = " + booleanListMap.get(true) +
                "\nPerson starts without A = " + booleanListMap.get(false));

        // 1. Given a list of integers, count how many are even.
        List<Integer> integerList = Arrays.asList(21, 3, 4, 6, 66, 33, 443, 44);
        Stream<Integer> evenIntegerStream = integerList.stream().filter(num -> num % 2 == 0);
        System.out.println("Total Even Numbers= "+ evenIntegerStream.count());

        // 2. Convert list of strings to uppercase
        List<String> list = Arrays.asList("a", "b", "c", "cat", "a");
        //duplicate will be removed
        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toSet()));
        //duplicate also will be there
        System.out.println(list.stream().map(String::toUpperCase).toList());

        // 3.Find first element greater than 10 : Return Optional<Integer>
        List<Integer> integerList1 = Arrays.asList(10, 9, 5, 33, 44, 55, 6);
        System.out.println(integerList1.stream().filter(x -> x>10).findFirst().get());

        // 4. Remove empty string
        List<String> list1 = Arrays.asList("a", "", "b", "", "c");
        System.out.println(list1.stream().filter(x -> !x.isEmpty()).toList());

        // 5. Find square of each number
        List<Integer> integerList2 = Arrays.asList(3, 4, 5, 6, 25);
        System.out.println(integerList2.stream().map(x -> x*x).toList());

        // **** Medium Level *****
        // 6. Find names starting with ‘A’
        List<String> list2 = Arrays.asList("Amit", "Raju", "Anil", "Suresh");
        System.out.println(list2.stream().filter(x->x.startsWith("A")).toList());

        // 7. Find duplicate elements in a list
        List<Integer> integerList3 = Arrays.asList(1, 2, 3, 1, 2, 4);

        System.out.println(integerList3.stream().collect(
                Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().filter(
                        x -> x.getValue() > 1).map(Map.Entry::getKey).toList());

        // 8. Group words by their length
        List<String> list3 = Arrays.asList("cat", "tiger", "lion", "dog");
        System.out.println(list3.stream().collect(Collectors.groupingBy(String::length)));

        // 9. Sort a list of objects by age
        List<Person> people = Arrays.asList(
                new Person("Avinash", 33),
                new Person("Abhi", 36),
                new Person("Addu", 2));
        System.out.println(people.stream().sorted((a,b)->a.age()-b.age()).toList());//ASC order

        // 10. Sum of all numbers greater than 50
        List<Integer> integerList4 = Arrays.asList(10, 90, 25, 70);
        System.out.println((Integer) integerList4.stream().filter(
                x -> x > 50).mapToInt(x -> x).sum());

        // 11. Group anagrams (Collect similar words)
        List<String> list4 = Arrays.asList("CAT", "ACT", "TCS", "SCT", "AB", "BA", "CA");
        list4.stream().collect(Collectors.groupingBy(
                IntermidiateAndTerminalStreamDemo::sameASCIIValue)).values().stream().map(
                        x -> String.join(", ", x)).forEach(System.out::println);

        // 12. Find the second highest number
        List<Integer> list5 = Arrays.asList(10, 5, 8, 20, 20);
        System.out.println(new HashSet<>(list5).stream().sorted((a, b)-> b-a).toList().get(1)); //10

        // 13. Convert list of employees to map
        List<Employee> employeeList = Arrays.asList(
                new Employee(101, "Avinash"),
                new Employee(102, "Abhi"),
                new Employee(103, "Saurav"),
                new Employee(101, "Avinash"));
        System.out.println(
                employeeList.stream().collect(Collectors.groupingBy(Employee::id, Collectors.mapping(Employee::name, Collectors.toSet()))));

        // 14. Count occurrences of each character in a string
        var word = "banana";
        System.out.println(Arrays.stream(word.split("")).toList().stream().collect(Collectors.groupingBy(x->x, Collectors.counting())));

        // 15. Flatten a list of lists
        var nestedArray = List.of(List.of(1,2), List.of(3,4), List.of(5));
        System.out.println(nestedArray.stream().flatMap(Collection::stream).toList());

    }

    private static int sameASCIIValue(String word){
        var sum = 0;
        for (int i = 0; i < word.length(); i++) {
            sum += word.charAt(i);
        }
        return sum;
    }
}

record Employee(int id, String name){
}

record Person (String name, int age){
    @Override
    public String toString() {
        return this.age + "-" +this.name;
    }
}
