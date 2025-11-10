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
        System.out.println("Similar Groups"+ StringUtils.groupBySimilarCharacters(
                Arrays.asList("CAT", "ACT", "TCS", "CTC", "SCT", "AB", "BA", "CA")));
    }
}

class StringUtils {
    public static List groupBySimilarCharacters(List<String> words) {
     return words.stream().collect(Collectors.groupingBy(StringUtils::sortCharacters)).values().stream().toList();
    }

    private static String sortCharacters(String word){
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
