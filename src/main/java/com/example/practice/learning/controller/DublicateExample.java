package com.example.practice.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/stream")
public class DublicateExample {

    @GetMapping("/joinString")
    public String getJoiningString(@RequestParam List<String> input){
      return input.stream().collect(Collectors.joining(","));
    }


    @GetMapping("/find/dublicate/groubBy")
    public List<String> getDublicateUsingGroubBy(@RequestParam List<String> input){

       return input.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue()>1)
                .map(k -> k.getKey())
                .collect(Collectors.toList());


    }

    @GetMapping("/find/dublicate/frequency")
    public Set<String> getDublicateUsingFrequency(@RequestParam List<String> input){

      return input.stream().filter(x-> Collections.frequency(input,x)>1)
              .collect(Collectors.toSet());



    }

    @GetMapping("/find/dublicate/set")
    public Set<String> getDublicateUsingSet(@RequestParam List<String> input){
        Set<String> result= new HashSet<>();

       return input.stream().filter(x -> !result.add(x)).collect(Collectors.toSet());



    }

}
