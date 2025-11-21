package com.example.javafundamentalslearning.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SimilarCharacters {
    public static void main(String[] args) {
        //input: ["CAT", "ACT", "TCS", "CTC", "SCT", "AB", "BA", "CA"]
        //output: [["CAT", "ACT"], ["TCS", "SCT"], ["AB", "BA"], ["CA"], ["CTC"]]
//        System.out.println("Similar Groups"+ StringUtils.groupBySimilarCharacters(
//                Arrays.asList("CAT", "ACT", "TCS", "CTC", "SCT", "AB", "BA", "CA")));
        StringUtils.groupBySimilarCharacters(
                Arrays.asList("CAT", "ACT", "TCS", "CTC", "SCT", "AB", "BA", "CA"));
    }
}

class StringUtils {
    public static void groupBySimilarCharacters(List<String> words) {
//     return words.stream().collect(Collectors.groupingBy(StringUtils::sameASCIIValue));
        System.out.println(words.stream().collect(Collectors.groupingBy(StringUtils::sameASCIIValue)));
    }

    private static int sameASCIIValue(String word){
       var sum = 0;
       for (int i = 0; i < word.length(); i++) {
           sum += word.charAt(i);
       }
       return sum;
    }
}
