package it.cascella.redisBridge.controllers;

import it.cascella.redisBridge.service.EvenCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple")
public class SimpleController {
    @Autowired
    @Qualifier("getANNOTATEDCalculator")
    private EvenCalculator evenCalculator;

    @GetMapping("/ping")
    public String ping() {
        return "pong!!!";
    }
    @GetMapping("/isEven/{number}")
    public boolean isEven(@PathVariable int number) {
        return evenCalculator.isEven(number);
    }

}
