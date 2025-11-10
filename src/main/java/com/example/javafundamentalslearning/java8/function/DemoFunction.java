package com.example.javafundamentalslearning.java8.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DemoFunction {
    public static void main(String[] args) {
        Predicate<String> hasGreaterThan3Char = (String s) -> s.length() > 3;
        Function<String, String> getFirstThreeCharacters = (str) -> {
            if (hasGreaterThan3Char.test(str)){
                return str.substring(0, 3);
            }
            return str;
        };
        Function<List<Student>, List<Student>> nameStartsWithAvi = (students) -> {
            return students.stream().filter(s -> getFirstThreeCharacters.apply(s.getName()).equals("Avi")).toList();
        };
        List<Student> students = new ArrayList<>();
        students.add(new Student("Avinash", 29));
        students.add(new Student("Abhishek", 30));
        students.add(new Student("Aviraj", 31));
        students.add(new Student("Suraj", 31));
        System.out.println("All Students = "+students);
        List<Student> AllStudentsStartsWithAvi = nameStartsWithAvi.apply(
                students);
        System.out.println("Students starting with Avi = " + AllStudentsStartsWithAvi);
    }
}

class Student {
    String name;
    int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }
}
