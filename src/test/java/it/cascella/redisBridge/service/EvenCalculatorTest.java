package it.cascella.redisBridge.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvenCalculatorTest {
    private EvenCalculator calculator = null;
    @BeforeEach
    void setUp() {
        calculator = new EvenCalculator("test");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEven() {
        boolean even = calculator.isEven(2);
        assertTrue(even);
        boolean odd = calculator.isEven(3);
        assertFalse(odd);
    }
}