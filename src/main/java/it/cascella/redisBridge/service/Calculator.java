package it.cascella.redisBridge.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Calculator {
    @Bean
    public EvenCalculator getCalculator (){

        return new EvenCalculator("TEST1");
    }
    @Bean
    @Primary
    public EvenCalculator getANNOTATEDCalculator (){
        return new EvenCalculator("TEST2");
    }

}
