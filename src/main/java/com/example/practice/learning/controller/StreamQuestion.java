package com.example.practice.learning.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class StreamQuestion {

    @GetMapping("/SecondLargestNumber")
    public Integer getSecondLargestNumber(@RequestParam List<Integer> input){

     return   input.stream().sorted(Collections.reverseOrder())
                .skip(1).findFirst().get();
    }

    @GetMapping("/reverseEachWord")
    public String reverseEachWord(@RequestParam String input){
      return   Arrays.stream(input.split(" "))
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
    }

    @GetMapping("/ElementFrequency")
    public Map<Integer,Long> frequencyOfEachElement(@RequestParam List<Integer> input){
       return input.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    @GetMapping("/joinWithPrefixAndSuffix")
    public String joinWithPrefixAndSuffix(@RequestParam List<String> input){

       return  input.stream().collect(Collectors.joining(",","[","]"));

    }

    @GetMapping("/multipleOfNumber")
    public List<Integer> multipleOfNumber(@RequestParam List<Integer> input){
        return input.stream()
                .filter(a -> a%5==0)
                .collect(Collectors.toList());
    }

    @GetMapping("/frequencyOfString")
    public Map<Character,Long> frequencyOfString(@RequestParam String input){
      return  input.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));


    }

    @GetMapping("/oddEevn")
    public Map<Boolean,List<Integer>> oddEevn(@RequestParam List<Integer> input){

      return  input.stream().sorted().collect(Collectors.partitioningBy(c->c%2==0));


    }
}
