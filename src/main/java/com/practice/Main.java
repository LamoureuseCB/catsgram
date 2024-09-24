package com.practice;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> languages = List.of("Go", "C++", "swift", "Pascal", "Lisp", "haskell");
//        Function<String, Integer> function = string -> {return string.length();};
        List<Integer> res = languages.stream()
                .map(lang -> lang.length())
                .toList();

        System.out.println(res);
    }
}
