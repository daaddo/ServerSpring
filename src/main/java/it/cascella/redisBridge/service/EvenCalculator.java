package it.cascella.redisBridge.service;

import org.springframework.context.annotation.Bean;


public class EvenCalculator {

    private String name;

    public EvenCalculator(String name) {
        this.name = name;
    }

    public boolean isEven(int number) {
        System.out.println("EvenCalculator: " + name);
        return number % 2 == 0;
    }
}
